package lesson16.HomeWork;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        //validate("http://someMail@grom.com");

//        System.out.println(minWord("Some text is tuping right here"));
//        System.out.println(maxWord("Some text is tuping right here"));
//        System.out.println(minWord("           "));
//        System.out.println(maxWord("           "));

//        System.out.println(validate("http://someMail@grom.com"));
//        System.out.println(validate("http://some123Mail@grom.com"));

//        System.out.println(dogTest("http://someMail@grom.com"));
//        System.out.println(dogTest("http://someMail@@grom.com"));
//        System.out.println(worldsWalid("someMail@grom"));
//        System.out.println(worldsWalid("some//123Mail@grom"));
//        System.out.println(wordCheck("someMail"));
//        System.out.println(wordCheck("some//123Mail"));
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

        if (input != null && !input.isEmpty() && input.length() > 0)
            for (int i = 0; i < input.length(); i++) {
                if (worlds[i].length() > max && worlds[i].length() > 0 && wordCheck(worlds[i])) {
                    max = worlds[i].length();
                    for (int j = 0; j < input.length(); j++) {
                        if (worlds[j].length() == max && worlds[j].length() > 0 && wordCheck(worlds[j]))
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
                if (worlds[i].length() < min && worlds[i].length() > 0 && wordCheck(worlds[i])) {
                    min = worlds[i].length();
                    for (int j = 0; j < input.length(); j++) {
                        if (worlds[j].length() == min && worlds[j].length() > 0 && wordCheck(worlds[j]))
                            return minWord = worlds[j];
                    }
                }
            }
        return minWord;
    }

    public static String mostCountedWorld(String input) {
        String[] worlds = input.split(" ");
        int count = 0;
        int maxCount = 0;
        String reiterationWord = null;


        for (String word : worlds) {
            for (String w : worlds) {
                if (w.equals(word) && word.length() > 0 && wordCheck(word))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                reiterationWord = word;
            }
        }
        return reiterationWord;
    }

    public static boolean validate(String adress) { //http://www.someMail@grom.com
        if (adress.endsWith(".com") || adress.endsWith(".net") || adress.endsWith(".org")) {
            String text = adress.substring(0, adress.length() - 4);
            if (adress.startsWith("http://")) {
                String devText = text.substring(7);
                dogTest(devText);
                worldsWalid(devText);
                System.out.println(dogTest(devText) + "1");
                System.out.println(worldsWalid(devText) + "2");
            } else if (adress.startsWith("https://")) {
                String devText = text.substring(8);
                dogTest(devText);
                worldsWalid(devText);
                System.out.println(dogTest(devText) + "3");
                System.out.println(worldsWalid(devText) + "4");
            }
        }
        return false;
    }

    private static boolean dogTest(String input) {
        char[] chars = input.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == '@') {
                count++;
                if (count > 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean znakTest(String input) {
        String[] test = input.split("://");
        if (test.length > 1) ;
        return false;
    }

    private static boolean worldsWalid(String input) {
        String[] worlds = input.split("@");
        for (String world : worlds) {
            if (wordCheck(world) == false)
                return false;
        }
        return true;
    }


    private static boolean wordCheck(String input) {
        char[] letters = input.toCharArray();
        for (char letter : letters) {
            if (!Character.isLetter(letter)) {
                return false;
            }
        }
        return true;
    }
}

