package lesson35.DAO;

import lesson35.model.User;
import lesson35.model.UserType;

import java.io.*;
import java.util.ArrayList;

public class UserDAO {

    public User saveUserToDB(User user) {
        writeUserToDb(user);
        return user;
    }

    private void writeUserToDb(User user) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter("E:\\Games\\java\'User.txt", true))) {
            br.newLine();
            br.write(user.toString());
        } catch (IOException e) {
            System.err.println("Can`t save User " + user.getUserName() + " to DB");
        }
    }

    // Непонятно, нужен ли метод ниже. Пока пусть будет
    public void saveUsersToDb(ArrayList<User> users) throws FileNotFoundException {
        deleteContentFromDb();
        for (User u : users) {
            writeUserToDb(u);
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

    private void deleteContentFromDb() throws FileNotFoundException {
        PrintWriter writer = new PrintWriter("E:\\Games\\java\'User.txt");
        writer.print("");
        writer.close();
    }
}
