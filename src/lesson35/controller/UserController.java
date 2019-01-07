package lesson35.controller;

import lesson35.Login.Start;
import lesson35.model.User;
import lesson35.servise.UserService;

public class UserController {

    UserService userService = new UserService();
    Start start = new Start();

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        start.login();
    }

    public void logOut(){
        start.logout();
    }
}
