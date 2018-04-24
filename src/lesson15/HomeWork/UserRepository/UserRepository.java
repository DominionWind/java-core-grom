package lesson15.HomeWork.UserRepository;

public class UserRepository {
    private User[] users = new User[10];

    public User[] getUser() {
        return users;
    }

    public User findById(long id) {

        if (users != null)
            for (User user : users) {
                if (user != null){
                    if (user.getId() == id)
                    return user;
                }
            }
        return null;
    }

    public User save(User user) {
        if (user == null){
        return null;
        }
        for (int i = 0; i < users.length; i++){
            if (users[i] == null) {
                users[i] = user;
                return users[i];
            }
        }
        return null;
    }


    public User update(User user) {
        if (user == null)
            return null;
        for (int i = 0; i < users.length; i++) {
            if (users[i].equals(findById(user.getId()))) {
                users[i] = user;
                return user;
            }
            return null;
        }
        return null;
    }

    public void delete(long id) {
        if (findById(id) != null) {
            for (int i = 0; i < users.length; i++) {
                if (users[i].equals(findById(id)))
                    users[i] = null;
            }
        }
    }
}
