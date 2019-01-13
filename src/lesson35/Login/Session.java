package lesson35.Login;

import lesson35.DAO.UserDAO;
import lesson35.model.User;

public class Session {
    private UserDAO userDAO = new UserDAO();

    private static User loginUser;

    public static User getLoginUser() {
        return loginUser;
    }

    public void logOut() {
        loginUser = null;
    }

    public void logIn(String username, String password) throws Exception {
        validateUserNameAndPassword(username, password);
        loginUser = userDAO.getUserByName(username);
    }


    public void validateUserNameAndPassword(String username, String password) throws Exception {
        if (!userDAO.getUserByName(username).getPassword().equals(password)) {
            throw new Exception("Login failed. Access denied");
        } else {
            return;
        }
    }

}
