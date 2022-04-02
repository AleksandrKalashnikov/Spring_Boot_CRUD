package com.mykata.spring_boot_crud.dao;

import com.mykata.spring_boot_crud.model.User;

import java.util.List;

public interface UserDao {
    List<User> allUsers();

    User oneUser(long id);

    void saveUser(User user);

    void updateUser(long id, User UpdateUser);

    void deleteUser(long id);
}
