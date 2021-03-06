package com.greenfrog.qna.controller;

import com.greenfrog.qna.domain.User;
import com.greenfrog.qna.dto.UserDTO;
import com.greenfrog.qna.dto.UserUpdateDTO;
import com.greenfrog.qna.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("")
    public String showList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/user/list";
    }

    @PostMapping("")
    public String signUp(UserDTO userDTO) {
        userService.signUp(userDTO);
        return "redirect:/users";
    }

    @GetMapping("/{id}")
    public String showProfile(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "/user/profile";
    }

    @GetMapping("/{id}/form")
    public String showUpdateForm(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.findUserById(id));
        return "/user/updateForm";
    }


    @PutMapping("/{id}/update")
    public String updateUser(@PathVariable int id, UserUpdateDTO userUpdateDTO) {
        boolean updateResult = userService.updateUser(id, userUpdateDTO);
        if (updateResult) {
            return "redirect:/users";
        }
        return "redirect:/users/" + id + "/form";
    }
}
