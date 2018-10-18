package lesson35.servise;

import lesson35.DAO.UserDAO;
import lesson35.Login.Start;
import lesson35.model.User;
import lesson35.model.UserType;

import java.io.File;
import java.util.UUID;

public class UserService {

    private UserDAO userDAO = new UserDAO();
    private Start start = new Start();

    public User registerUser() throws Exception {
        User user = start.regUser();
        userCheck(user);
        userValidator(user);

        userDAO.registerUser(user);
        return user;
    }


    private void userCheck(User user) throws Exception {
        for (User u : userDAO.readUserFromFile()) {
            if (user.getUserName().equals(u.getUserName())) {
                throw new Exception("User " + u.getUserName() + " already in bd");
            }
        }
    }

    private void userValidator(User user) throws Exception {
        if (user.getUserName() == null) {
            throw new Exception("user name can`t be null");
        }

        if (user.getCountry() == null) {
            throw new Exception("country can`t be null");
        }

        if (user.getPassword() == null) {
            throw new Exception("user password can`t be null");
        }
    }

    private void fileUserExist() throws Exception {
        File f = new File("E:\\Games\\java\'User.txt");
        if (!f.exists())
            throw new Exception("File User.txt does not exist");
    }

    public void rightValidation(User user) throws Exception {
        if (!user.getType().equals(UserType.ADMIN)) {
            throw new Exception("User " + user.getUserName() + " don`t have enough rights. Contact with administratorenou");
        }
    }

    public long createUniqueId() {
        long id;
        return id = UUID.randomUUID().getMostSignificantBits() & Long.MAX_VALUE;
    }

}
