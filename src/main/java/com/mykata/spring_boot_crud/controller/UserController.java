package com.mykata.spring_boot_crud.controller;

import com.mykata.spring_boot_crud.model.User;
import com.mykata.spring_boot_crud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String allUsers(Model model){
        model.addAttribute("users", userService.allUsers());
        return "/users";
    }

    @GetMapping("/{id}")
    public String user(@PathVariable int id, Model model){
        model.addAttribute("user", userService.oneUser(id));
        return "/show";
    }

    @GetMapping("/new")
    public String newUser( Model model){
        model.addAttribute("user", new User());
        return "/new";
    }

    @PostMapping()
    public String addUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.oneUser(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String update(@ModelAttribute("user") User user, @PathVariable("id") long id) {
        userService.updateUser(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") long id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }
}
