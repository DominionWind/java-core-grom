package lesson35.controller;

import lesson35.model.User;
import lesson35.servise.UserService;

public class UserController {

    UserService userService = new UserService();

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }
}
