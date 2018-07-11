package lesson27.HomeWork;

import lesson20.task1.exeption.BadRequestException;
import lesson20.task1.exeption.InternalServerException;
import lesson20.task1.exeption.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();
    //private User[] users = new User[10];

    public User save(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can`t save null user");

        try {
            findById(user.getId());
            throw new BadRequestException("User with id: " + user.getId() + " already exist");
        } catch (UserNotFoundException e) {
            System.out.println("User with id: " + user.getId() + " not found. Will be saved");
        }

        users.add(user);

//        int index = 0;
//        for (User us : users) {
//            if (us == null) {
//                users[index] = user;
//                return users[index];
//            }
//            index++;
//        }

//        throw new InternalServerException("Not enough space to save user with id: " + user.getId());
        return user;
    }

    public List update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can`t update null user");

        findById(user.getId());

        users.remove(user.getId());
        users.add(user);

//        int index = 0;
//        for (User us : users) {
//            if (us != null && us.getId() == user.getId()) {
//                users[index] = user;
//                return users[index];
//            }
//            index++;
//        }

        throw new InternalServerException("Unexeption error");
    }

    public void delete(long id) throws Exception {
        findById(id);

        users.remove(findById(id));

//        int index = 0;
//        for (User us : users) {
//            if (us.getId() == id) {
//                users[index] = null;
//                break;
//            }
//            index++;
//        }
    }

    public User findById(long id) throws UserNotFoundException {
        for (User user : users) {
            if (user != null && id == user.getId())
                return user;
        }

        throw new UserNotFoundException("User with id: " + id + " not found");
    }

    public List<User> getUsers() {
        return users;
    }
}
