package lesson17.HomeWork;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        String text = ("123 954g gfd -20g 154 894 -3");
        System.out.println(Arrays.toString(findNumbers(text)));

    }

    public static int[] findNumbers(String text) {
        String[] words = text.split(" ");
//        int[] stepen = new int[words.length];
        int count = 0;
        int i = 0;
//        int j = 0;
//
//        for (String w : words) {
//            try {
//                stepen[j] = Integer.parseInt(w)*Integer.parseInt(w);
//                j++;
//            } catch (Exception e){
//                j++;
//            }
//        }
//        System.out.println(Arrays.toString(stepen));

        for (String word : words) {
            if (checkNumber(word))
                count++;
        }
//        System.out.println(count);
        int[] numbers = new int[count];

        for (String word : words) {
            try {
                numbers[i] = Integer.parseInt(word);
                i++;
            } catch (Exception e) {
                System.out.println(word + " not a nymber");
//                i++;
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
