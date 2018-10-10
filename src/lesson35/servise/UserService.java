package lesson35.servise;

import lesson35.DAO.UserDAO;
import lesson35.model.User;

public class UserService {

    private UserDAO userDAO = new UserDAO();

    public User registerUser(User user) throws Exception {
        return userDAO.registerUser(user);
    }
}
