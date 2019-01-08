package lesson35.Login;

import lesson35.DAO.UserDAO;
import lesson35.model.User;
import lesson35.model.UserType;
import lesson35.servise.UserService;

import java.io.*;
import java.util.Scanner;

public class Start {
    UserDAO userDAO = new UserDAO();
    UserService userService = new UserService();
    Utils utils = new Utils();

    private static String path = "E:\\Games\\java\\Login.txt";

    public User regUser() throws Exception {
        long id = utils.createUniqueId();
        String username = printUserName();
        String password = printUserPassword();
        String country = printUserCountry();
        User user = new User(id, username, password, country, UserType.USER);
        userService.registerUser(user);
        return user;
    }

    public void login() throws Exception {
        String userName = printUserName();
        String password = printUserPassword();

        validateUserNameAndPassword(userName, password);

        saveLoggedInUser(userDAO.getUserByName(userName));
    }

    public void logout() {
        try {
            PrintWriter writer = new PrintWriter(path);
            writer.print("");
            writer.close();
            System.out.println("Logout successful");
        } catch (FileNotFoundException e) {
            System.err.printf("File does not exist. Some one delete DB");
        }
    }


    public User getLoggedInUser() throws IOException, ClassNotFoundException {
        User user = null;
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            user = userDAO.convector(br.toString());
        } catch (FileNotFoundException e) {
            System.err.printf("File does not exist");
        }

//        if (user == null)
//        throw new IOException("Operation failed. U should logged in first");

        return user;
    }

    public void checkAdminRights() throws Exception {
        userService.rightValidation(getLoggedInUser());
    }

    private String printUserName() {
        System.out.println("Print UserName");
        return printText();
    }

    private String printUserPassword() {
        System.out.println("Print password");
        return printText();
    }

    private String printUserCountry() {
        System.out.println("Print Country");
        return printText();
    }

    private String printText() {
        String text;
        Scanner scanner = new Scanner(System.in);
        return text = scanner.nextLine();
    }

    private void validateUserNameAndPassword(String username, String password) throws Exception {
        if (!userDAO.getUserByName(username).getPassword().equals(password)) {
            throw new Exception("Login failed. Access denied");
        } else {
            return;
        }
    }

    private void saveLoggedInUser(User user) throws IOException {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(path));
            writer.writeObject(user);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.printf("File does not exist");
        }
    }
}
