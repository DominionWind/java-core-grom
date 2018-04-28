package lesson15.HomeWork.UserRepository;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        UserRepository userRepository=new UserRepository();
        User user1 = new User(11, "11","11");
        User user2 = new User(22, "22","22");
        System.out.println(Arrays.deepToString(userRepository.getUser()));
        userRepository.save(user1);
        userRepository.save(user2);
        System.out.println(Arrays.deepToString(userRepository.getUser()));
    }
}
