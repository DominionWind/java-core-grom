package lesson35.DAO;

import lesson35.model.User;
import lesson35.model.UserType;

import java.io.*;
import java.util.ArrayList;

public class UserDAO {

    private DAO<User> dao = new DAO<User>() {
        @Override
        public User convector(String string) {
            String[] mod = string.split(",");

            long id = Long.parseLong(mod[0]);
            String userName = mod[1];
            String password = mod[2];
            String country = mod[3];

            User user = new User(id, userName, password, country);
            setUserType(user, mod[4]);
            return user;
        }
    };

    private void setUserType(User user, String string) {
        if (string != "ADMIN") {
            user.setType(UserType.USER);
        } else {
            user.setType(UserType.ADMIN);
        }
    }

    public User convector(String string) {
        String[] mod = string.split(",");

        long id = Long.parseLong(mod[0]);
        String userName = mod[1];
        String password = mod[2];
        String country = mod[3];

        User user = new User(id, userName, password, country);
        setUserType(user, mod[4]);

        return user;
    }

    private String path = "E:\\Games\\java\\User.txt";

    public String getPath() {
        return path;
    }

    public User saveUserToDB(User user) {
        dao.writerToFile(user, path);
        return user;
    }

    // Непонятно, нужен ли метод ниже. Пока пусть будет
    public void saveUsersToDb(ArrayList<User> users) throws FileNotFoundException {
        deleteContentFromDb();
        for (User u : users) {
            dao.writerToFile(u, path);
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
        return dao.readFromFile(path);
    }

    private void deleteContentFromDb() throws FileNotFoundException {
        dao.deleteContent(path);
    }
}
