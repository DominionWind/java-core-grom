package gromcode.main.lesson15.cast;

public class Demo {
    public static void main(String[] args) {
        InternetProvider provider = (InternetProvider) test();
        FoodProvider foodProvider = (FoodProvider) testFood();

        System.out.println(provider);

    }
    static Object test(){
        return new InternetProvider();
    }

    static Object testFood(){
        return new InternetProvider();
    }
}
