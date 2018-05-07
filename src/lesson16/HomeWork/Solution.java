package lesson16.HomeWork;

public class Solution {
    public static void main(String[] args) {
        System.out.println(minWord("Some text is tuping right here"));
        System.out.println(maxWord("Some text is tuping right here"));
        System.out.println(minWord("           "));
        System.out.println(maxWord("           "));

    }

    public int countWords(String input) {
        int count = 0;
        boolean w = false;
        int enfOdString = input.length() - 1;

        for (int i = 0; i < input.length(); i++) {
            if (Character.isLetter(input.charAt(i)) && i != enfOdString) {
                w = true;
            } else if (!Character.isLetter(input.charAt(i)) && w) {
                count++;
                w = false;
            } else if (Character.isLetter(input.charAt(i)) && i == enfOdString) {
                count++;
            }
        }
        return count;
    }

    public static String maxWord(String input) {
        String[] worlds = input.split(" ");
        String maxWord = null;
        int max = worlds[0].length();

        if (input != null && !input.isEmpty())
        for (int i = 0; i < input.length(); i++) {
            if (worlds[i].length() > max) {
                max = worlds[i].length();
                for (int j = 0; j < input.length(); j++) {
                    if (worlds[j].length() == max)
                        return maxWord = worlds[j];
                }
            }
        }
        return maxWord;
    }

    public static String minWord(String input) {
        String[] worlds = input.split(" ");
        String minWord = null;
        int min = worlds[0].length();

        if (input != null && !input.isEmpty())
        for (int i = 0; i < input.length(); i++) {
            if (worlds[i].length() < min) {
                min = worlds[i].length();
                for (int j = 0; j < input.length(); j++) {
                    if (worlds[j].length() == min)
                        return minWord = worlds[j];
                }
            }
        }
        return minWord;
    }
}
