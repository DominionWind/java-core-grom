package Lesson3;

import java.net.Socket;

public class FindOdd {
    public static void main(String[] args) {
        int a = 0;
        int sum = 0;
        while (a < 1000) {
            a++;
            if (a % 2 == 0) {
            } else {
                System.out.println("Found");
                sum += a;
            }
        }
        if (sum * 5 > 5000){
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller or equal");
        }
    }
}
