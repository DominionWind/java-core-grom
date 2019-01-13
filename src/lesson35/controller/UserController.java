package lesson35.controller;

import lesson35.Login.Session;
import lesson35.Login.Start;
import lesson35.model.User;
import lesson35.servise.UserService;

public class UserController {

    UserService userService = new UserService();
    Session session = new Session();

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        session.logIn(userName, password);
    }

    public void logOut() {
        session.logOut();
    }
}
