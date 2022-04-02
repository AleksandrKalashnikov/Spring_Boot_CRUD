package com.mykata.spring_boot_crud.dao;

import com.mykata.spring_boot_crud.model.User;
import com.mykata.spring_boot_crud.repository.UserRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    private UserRepository userRepository;

    @Override
    public List<User> allUsers() {
        return userRepository.findAll();
    }

    @Override
    public User oneUser(long id) {
        return userRepository.getById(id);
    }

    @Override
    public void saveUser(User user) {
        userRepository.save(user);
    }

    @Override
    public void updateUser(long id, User updateUser) {
        User oldUser = userRepository.getById(id);
        oldUser.setName(updateUser.getName());
        oldUser.setLastname(updateUser.getLastname());
        oldUser.setAge(updateUser.getAge());
        userRepository.save(updateUser);
    }

    @Override
    public void deleteUser(long id) {
        userRepository.deleteById(id);
    }
}
