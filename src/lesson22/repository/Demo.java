package lesson22.repository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        User user1 = new User(1001,"Daniil","32434234sdsfuuuuo");
        User user2 = new User(1002,"Andrey","32434234sdsfuuuuo");
        User user3 = new User(1001,"Test","32434234sdsfuuuuo");

        UserRepository.save(user1);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        UserRepository.save(user2);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        UserRepository.update(user3);

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));

        System.out.println(Arrays.deepToString(UserRepository.getUsers()));
    }
}
