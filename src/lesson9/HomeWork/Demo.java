package lesson9.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {

        //сохраняем юзера в массив +
        //пересохраняем юзера в массив +
        //сохраняем юзеров больше чем длинна массива
        //сохраняем null
        UserRepository userRepository = new UserRepository();

        System.out.println("Создаём массив");
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println("----------------");

        User user = new User(88,"Bob","N1");
        userRepository.save(user);

        System.out.println();
        System.out.println("Сохраняем Юзера");
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println("----------------");

        System.out.println();
        System.out.println("Пересохраняем Юзера");
        userRepository.save(user);
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println("----------------");

        System.out.println();
        System.out.println("Заполняем массив большим колличеством Юзеров чем длинна массива");
        int n = 10;
        while (n>0){
            User user1 = new User(n, "Test", "some id");
            System.out.println(userRepository.save(user1));
            n--;
        }
        System.out.println(Arrays.deepToString(userRepository.getUsers()));
        System.out.println("----------------");

//        System.out.println();
//        System.out.println("сохраняем null");
//        System.out.println(userRepository.update(null));
//        System.out.println(Arrays.deepToString(userRepository.getUsers()));
//        System.out.println("----------------");
        // Получаем ошибку. Но ведь мы её и должны получить.

        System.out.println();
        System.out.println("Проверяем метод getUserNames");
        System.out.println(Arrays.deepToString(userRepository.getUserNames()));
        System.out.println("----------------");

        System.out.println();
        System.out.println("Проверяем метод getUserNamesMK2");
        System.out.println(Arrays.deepToString(userRepository.getUserNamesMK2()));
        System.out.println("----------------");

        System.out.println();
        System.out.println("Проверяем метод getUserIds");
        System.out.println(Arrays.toString(userRepository.getUserIds()));
        System.out.println("----------------");

        System.out.println();
        System.out.println("Проверяем метод getUserNameById");
        System.out.println(userRepository.getUserNameById(88));
        System.out.println(userRepository.getUserNameById(78));
        System.out.println("----------------");

        System.out.println();
        System.out.println("Проверяем метод getUserByName");
        System.out.println(userRepository.getUserByName("Bob"));
        System.out.println(userRepository.getUserByName("bob"));
        System.out.println("----------------");

        System.out.println();
        System.out.println("Проверяем метод getUserById");
        System.out.println(userRepository.getUserById(88));
        System.out.println(userRepository.getUserById(78));
        System.out.println("----------------");

        System.out.println();
        System.out.println("Проверяем метод findById");
        System.out.println(userRepository.findById(88));
        System.out.println(userRepository.findById(78));
        System.out.println("----------------");

        







    }
}
