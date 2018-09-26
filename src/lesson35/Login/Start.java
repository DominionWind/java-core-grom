package lesson35.Login;

import lesson35.DAO.UserDAO;
import lesson35.model.User;

import java.io.*;
import java.util.Scanner;

public class Start {
    UserDAO userDAO = new UserDAO();

    public void login() throws Exception {
        String username = printUserName();
        String password = printUserPassword();

        validateUserNameAndPassword(username, password);
        saveLoggedInUser(userDAO.getUserByName(username));
    }

    public void logout() {
        try {
            PrintWriter writer = new PrintWriter("E:\\Games\\java\\Login");
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
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("E:\\Games\\java\\Login"));
            user = (User) in.readObject();

        } catch (FileNotFoundException e) {
            System.err.printf("File does not exist");
        }

        if (user == null)
            throw new IOException("Operation failed. U should logged in first");

        return user;
    }

    private String printUserName() {
        String username;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print login");
        return username = scanner.nextLine();
    }

    private String printUserPassword() {
        String userPassword;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Print password");
        return userPassword = scanner.nextLine();
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
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream("E:\\Games\\java\\Login"));
            writer.writeObject(user);
            writer.close();
        } catch (FileNotFoundException e) {
            System.err.printf("File does not exist");
        }
    }
}
