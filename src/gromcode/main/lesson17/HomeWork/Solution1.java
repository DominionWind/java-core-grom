package gromcode.main.lesson17.HomeWork;

import java.util.Arrays;

public class Solution1 {
    public static void main(String[] args) {
        String text = ("123 954g gfd -20g 154 894 -3");
        System.out.println(Arrays.toString(findNumbers(text)));
    }

    public static int[] findNumbers(String text) {
        String[] words = text.split(" ");
        int count = 0;
        int j = 0;

        for (String word : words) {
            if (checkNumber(word))
                count++;
        }
        int[] numbers = new int[count];

        for (int i = 0; i < words.length; i++) {
            if (checkNumber(words[i]) && words[i] != null) {
                numbers[j] = Integer.parseInt(words[i]);
                j++;
            } else {
                System.out.println(words[i] + " not a number");
            }
        }
        return numbers;
    }

    private static boolean checkNumber(String input) {
        char[] digits = input.toCharArray();
        for (char digit : digits) {
            if (!Character.isDigit(digit) && digit != '-') {
                return false;
            }
        }
        return true;
    }
}
