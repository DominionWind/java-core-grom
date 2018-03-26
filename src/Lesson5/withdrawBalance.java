package Lesson5;

import java.util.Arrays;

public class withdrawBalance {
    public static void main(String[] args) {
        String [] names = {"Jack", "Ann", "Denis", "Andrey", "Nikolay", "Irina", "Jhon"};
        int [] balances = {100, 500, 8432, -99, 1200, -54, 0};
        withdraw(names, balances, "Jack", 10);
        System.out.println(Arrays.toString(balances));

    }
    public static int withdraw(String[] clients, int [] balances, String client, int amount){
        System.out.println(client);
        System.out.println(Arrays.toString(balances));
        if (amount <= findClientIndexByName(clients, client))
            balances[findClientIndexByName(clients, client)] -= amount;
        else
            System.out.println("-1");
        return amount;
    }
    public static int findClientIndexByName(String []clients, String client){
        int clientIndex = 0;
        for (String cl: clients){
            if (cl == client){
                break;
            }
            clientIndex ++;
        }
        return clientIndex;
    }
}

