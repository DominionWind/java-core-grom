package lesson35.DAO;

import lesson35.Login.Start;
import lesson35.servise.UserService;

public class DAO {

    private UserService userService = new UserService();
    private Start start = new Start();

    public void checkAdminRights () throws Exception {
        userService.rightValidation(start.getLoggedInUser());
    }
}
