package com.mykata.spring_boot_crud.repository;

import com.mykata.spring_boot_crud.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
