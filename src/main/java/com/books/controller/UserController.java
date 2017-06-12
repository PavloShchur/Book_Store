package com.books.controller;

import com.books.service.MailSenderService;
import com.books.validator.Validator;
import com.books.validator.userLoginValidation.UserLoginValidationMessages;
import com.books.validator.userValidator.UserValidationMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.books.entity.User;
import com.books.service.UserService;

import java.security.Principal;
import java.util.UUID;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailSenderService mailSenderService;

    @Autowired
    @Qualifier("userLoginValidator")
    private Validator validator;

    @GetMapping("/signUp")
    public String signp(Model model) {
        model.addAttribute("users", userService.findAll());
        model.addAttribute("user", new User());
        return "views-user-signUp";
    }

    @PostMapping("/signUp")
    public String signUpAfter(@ModelAttribute User user, Model model) throws Exception {

        String uuid = UUID.randomUUID().toString();
        user.setUuid(uuid);

        try {
            userService.save(user);
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserValidationMessages.USERNAME_ALREADY_EXISTS)) {
                model.addAttribute("UserNameException", e.getMessage());
            }
            return "views-user-signUp";
        }

        String theme = "Thank You";
        String mailBody = "gl & hf  http://localhost:8080/confirm/" + uuid;

        mailSenderService.sendMail(theme, mailBody, user.getEmail());
        return "redirect:/signUp";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable int id) {
        userService.delete(id);
        return "redirect:/signUp";
    }

    @GetMapping("/updateUser/{id}")
    public String getUser(@PathVariable int id, Model model) {
        model.addAttribute("userAttribute", userService.findOne(id));
        return "views-user-updateUser";
    }

    @PostMapping("/updateUser/{id}")
    public String updateUser(@ModelAttribute("user") User user, @PathVariable int id, Model model) {
        user.setId(id);
        userService.update(user);
        model.addAttribute("users", userService.findAll());
        return "views-user-signUp";
    }

    @GetMapping("/profile")
    public String profile(Principal principal, Model model) {
        model.addAttribute("userBasket", userService.findUserWithBooks(Integer.parseInt(principal.getName())));
        return "views-user-profile";
    }

    @PostMapping("/failureLogin")
    public String failureLogin(Model model, @RequestParam String username,
                               @RequestParam String password) {

        try {
            validator.validate(new User(username, password));
        } catch (Exception e) {
            if (e.getMessage().equals(UserValidationMessages.EMPTY_USERNAME_FIELD) ||
                    e.getMessage().equals(UserLoginValidationMessages.EMPTY_PASSWORD_FIELD) ||
                    e.getMessage().equals(UserLoginValidationMessages.WRONG_USERNAME_OR_PASSWORD)) {
                model.addAttribute("exception", e.getMessage());
            }
        }
        model.addAttribute("user", new User());

        return "views-user-signUp";
    }

    @GetMapping("/history")
    public String history(Principal principal, Model model) {

        model.addAttribute("user", userService.findUserWithOrders(Integer.parseInt(principal.getName())));

        return "views-user-history";
    }


    @GetMapping("/confirm/{uuid}")
    public String confirm(@PathVariable String uuid) {

        User user = userService.findByUuid(uuid);
        user.setEnable(true);

        userService.update(user);
        return "redirect:/";
    }

    @GetMapping("/send/{id}")
    public String like(@PathVariable int id, Principal principal) {
        System.out.println("like");
        userService.like(principal, id);
        return "views-base-index";
    }
}