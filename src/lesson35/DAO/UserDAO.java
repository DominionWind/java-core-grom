package lesson35.DAO;

import lesson35.model.User;
import lesson35.model.UserType;

import java.io.*;
import java.util.ArrayList;

public class UserDAO {

    //считывание данных - считывание файла
    //обработка данных - обработка данных, маппинг данных

    public User registerUser(User user) throws Exception {
        ArrayList<User> users = readUserFromFile();
        users.add(user);
        saveUsersToDb(users);
        return user;
    }

    public void saveUsersToDb(ArrayList<User> users){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("E:\\Games\\java\'User.txt"))){
            bufferedWriter.write(String.valueOf(users));
        } catch (IOException e) {
            System.err.println("Can`t save Users to BD");
        }
    }

    public User getUserByName(String name) throws Exception {
        if (name.equals(null))
            return null;

        for (User u : readUserFromFile()) {
            if (u.getUserName().equals(name)) {
                return u;
            }
        }
        throw new Exception("Cant find user with name " + name);
    }

    public User getUserById(long id) throws Exception {
        if (id == 0)
            return null;

        for (User u : readUserFromFile()) {
            if (u.getId() == id) {
                return u;
            }
        }
        throw new Exception("Cant find user with id " + id);
    }

    public ArrayList<User> readUserFromFile() throws Exception {

        ArrayList<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(
                new FileReader("E:\\Games\\java\'User.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                userValidator(line);
                users.add(stringToUserConvector(line));
            }
        } catch (IOException e) {
            System.err.println("Reading from file E:\\Games\\java\\User.txt failed");
        }

        return users;
    }

    private User stringToUserConvector(String string) {

        String[] mod = string.split(",");

        long id = Long.parseLong(mod[0]);
        String userName = mod[1];
        String password = mod[2];
        String country = mod[3];
        UserType userType = UserType.valueOf(mod[4]);

        User user = new User(id, userName, password, country, userType);

        return user;
    }

    private void userValidator(String line) throws Exception {

        String[] text = line.split(",");

        if (text.length != 4) {
            throw new Exception("File User.txt broken. Collapse.");
        }

        if (text[1] == null) {
            throw new Exception("field User name is empty. ID " + text[0]);
        }

        if (text[2] == null) {
            throw new Exception("field password is empty. ID " + text[0]);
        }

        if (text[3] == null) {
            throw new Exception("field country is empty. ID " + text[0]);
        }

        if (UserType.valueOf(text[4]) != UserType.ADMIN && UserType.valueOf(text[4]) != UserType.USER) {
            throw new Exception("field UserType is wrong. ID " + text[0]);
        }
    }
}
