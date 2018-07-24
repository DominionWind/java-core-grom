package lesson32.HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
    public int readNumbers() throws IOException {

        System.out.println("Please, enter ten numbers from 0 to 99 divided by space");

        int sum = 0;
        int n = 4;

        while (n > 0) {
            String incomeText = printer();

            String[] lines = incomeText.split(" ");

            System.out.println(validate(incomeText));

            if (validate(incomeText) == true) {
                for (String l : lines) {
                    sum += Integer.parseInt(l);
                    n = 0;
                }
            } else {
                n--;
            }

            if (n == 0) {
                System.out.println("Your numbers are wrong. Number of attempts exceeded");
            } else {
                System.out.println("Your numbers are wrong. You have " + n + " attempts to try again");
            }
        }


        System.out.println(sum);

        return sum;
    }

    private String printer() throws IOException {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        String line = br.readLine();

        return line;
    }

    private boolean validate(String text) {
        String[] words = text.split(" ");

        if (words.length != 10)
            return false;

        String numbers = text.replaceAll(" ", "");
        char[] digits = numbers.toCharArray();
        for (char digit : digits) {
            if (!Character.isDigit(digit) && digit != '-') {
                return false;
            }
        }

        for (String w : words) {
            if (!(Integer.parseInt(w) < 100)) {
                return false;
            }
        }

        for (String w : words) {
            if (!(Integer.parseInt(w) > 0)) {
                return false;
            }
        }

        return true;
    }


}
