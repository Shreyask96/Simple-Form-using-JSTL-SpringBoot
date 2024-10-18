package com.dakr.Dakr_Solutions.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dakr.Dakr_Solutions.EntityModel.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
