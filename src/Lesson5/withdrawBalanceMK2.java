package Lesson5;

import java.util.Arrays;

public class withdrawBalanceMK2 {
    public static void main(String[] args) {
        String [] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "Jhon"};
        int [] balances = {100, 500, 8432, -99, 1200, -54, 0};
        withdraw(names, balances, "Jack", 100);
        System.out.println(Arrays.toString(balances));
    }

    public static int withdraw(String[] clients, int [] balances, String client, int amount){
        int clientIndex = 0;
        for (String cl: clients){
            if (cl == client){
                break;
            }
            clientIndex ++;
        }
        if (amount <= balances[clientIndex])
            balances[clientIndex] -= amount;
        else {
            System.out.println("-1");
        }
        return amount;
    }
}
