package lesson9.HomeWork;

public class UserRepository {
    private User[] users = new User[5];

    public User[] getUsers() {
        return users;
    }

    public String[] getUserNames() {
        String userName[] = new String[getUsers().length];
        for (int i = 0; i < getUsers().length; i++)
            if (getUsers()[i] != null)
                userName[i] = getUsers()[i].getName();
        return userName;
    }

    String[] getUserNamesMK2() {
        int i = 0;
        String userName[] = new String[getUsers().length];
        for (User a : users)
            if (a != null)
                userName[i++] = a.getName();
        return userName;
    }

    public long[] getUserIds() {
        int n = 0;
        int i = 0;
        if (getUsers() != null)
            for (User user : getUsers())
                if (user != null)
                    n++;
        long[] userId = new long[n];
        for (User user : getUsers())
            if (user != null){
                userId[i] = user.getId();
                return userId;}
        i++;
        return userId;
    }

    public String getUserNameById(long id) {
        String name = null;
        if (users != null)
            for (int i = 0; i < getUsers().length; i++)
                if (users[i] != null)
                    if (users[i].getId() == id)
                        name = users[i].getName();
        return name;
    }

    public User getUserByName(String name) {
        for (User a : users)
            if (a != null && a.getName() == name)
                return a;
        return null;
    }

    public User getUserById(long id) {
        for (User a : users)
            if (a != null && a.getId() == id)
                return a;
        return null;
    }

    public User getUserBySessionId(String sessionId) {
        for (User a : users)
            if (a != null && a.getSessionId() == sessionId)
                return a;
        return null;
    }

    public User findById(long id) {
        return this.getUserById(id);
    }

    public User save(User user) {
        if (findById(user.getId()) == null)
            for (int i = 0; i < users.length; i++)
                if (users[i] == null) {
                    users[i] = user;
                    return user;
                }
        return null;
    }

    public User update(User user) {
        if (findById(user.getId()) != null) {
            for (int i = 0; i < getUsers().length; i++)
                if (users[i] == findById(user.getId()))
                    users[i] = user;
            return user;
        }
        System.out.println("FATAL ERROR!!! User can`t be null!!!");
        return null;
    }

    public void delete(long id) {
        if (findById(id) != null)
            for (int i = 0; i < users.length; i++)
                if (users[i] == findById(id))
                    users[i] = null;
    }


    /*public User getUserNameById(long id) {
        for (User u : users) {
            if (u != null && u.getId() == id) {
                return u;
            }
        }
        return null;
    }*/

}
