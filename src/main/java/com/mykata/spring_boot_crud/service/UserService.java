package com.mykata.spring_boot_crud.service;

import com.mykata.spring_boot_crud.model.User;

import java.util.List;

public interface UserService {
    List<User> allUsers();

    User oneUser(long id);

    void saveUser(User user);

    void updateUser(long id, User updateUser);

    void deleteUser(long id);
}
