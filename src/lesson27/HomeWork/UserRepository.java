package lesson27.HomeWork;

import lesson20.task1.exeption.BadRequestException;
import lesson20.task1.exeption.InternalServerException;
import lesson20.task1.exeption.UserNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();

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

        return user;
    }

    public User update(User user) throws Exception {
        if (user == null)
            throw new BadRequestException("Can`t update null user");

        users.remove(findById(user.getId()));
        users.add(user);

        return user;
    }

    public void delete(long id) throws Exception {
        findById(id);

        users.remove(findById(id));

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
