package com.dakr.Dakr_Solutions.Controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.dakr.Dakr_Solutions.EntityModel.User;
import com.dakr.Dakr_Solutions.Service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/form")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "form";
    }

    @PostMapping("/submitForm")
    public String submitForm(@Valid @ModelAttribute("user") User user, 
                             BindingResult result, 
                             RedirectAttributes redirectAttributes) {

        if (result.hasErrors()) {
            // If there are validation errors, return to the form page
            return "form";
        }

        // Save user details to the database
        userService.saveUser(user);

        // Redirect to success page with a success message
        redirectAttributes.addFlashAttribute("successMessage", "Form submitted successfully!");
        return "redirect:/success";
    }

    // Show the success page
    @GetMapping("/success")
    public String showSuccessPage(Model model) {
        return "success";
    }
}
