package lesson16.HomeWork;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {

        //validate("http://someMail@grom.com");

//        System.out.println(minWord("Some text is tuping right here"));
//        System.out.println(maxWord("Some text is tuping right here"));
//        System.out.println(minWord("           "));
//        System.out.println(maxWord("           "));
//        System.out.println(mostCountedWord(" т т т т мыла мыла мыла авто"));
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

        if (worlds.length == 0) {
            return null;
        }

        for (String world : worlds) {//зачем этот фор я хз. Должно работать без него но проверять лень.
            if (world.length() > 0 && wordCheck(world)) {
                maxWord = world;
                break;
            }
        }

        if (maxWord == null) {
            return null;
        }
        for (String world : worlds) {
            for (String w : worlds)
                if (w.length() > world.length() && wordCheck(w))
                    maxWord = w;
        }
        return maxWord;
    }

    public static String minWord(String input) {
        String[] worlds = input.split(" ");
        String minWorld = null;

        if (worlds.length == 0) {
            return null;
        }
        for (String world : worlds) {//Аналогичто. ХЗ зачем этот фор. А впрочем может он и нужен.
            if (world.length() > 0 && wordCheck(world)) {
                minWorld = world;
                break;
            }
        }

        if (minWorld == null) {
            return null;
        }
        for (String world : worlds) {
            for (String w : worlds)
                if (w.length() < world.length() && wordCheck(w))
                    minWorld = w;
        }

        return minWorld;
    }
//    public static String maxWord(String input) { // первый вариант. Почти рабочий. Только с налами не очень дружил.
//        if (input == null){
//            return null;}
//        String[] worlds = input.split(" ");
//        String maxWord = null;
//        if (worlds == null){
//            return null;
//        }
//        int max = worlds[0].length();
//        for (int i = 0; i < input.length(); i++) {
//            if (worlds[i].length() > max && wordCheck(worlds[i])) {
//                max = worlds[i].length();
//                for (int j = 0; j < input.length(); j++) {
//                    if (worlds[j].length() == max && wordCheck(worlds[j]))
//                        return maxWord = worlds[j];
//                    }
//                }
//            }
//        return maxWord;
//    }
//
//    public static String minWord(String input) {
//        if (input == null){
//            return null;
//        }
//        String[] worlds = input.split(" ");
//        String minWord = null;
//        if (worlds == null){
//            return null;
//        }
//        int min = worlds[0].length();
//        for (int i = 0; i < input.length(); i++) {
//            if (worlds[i].length() < min && wordCheck(worlds[i])) {
//                min = worlds[i].length();
//                for (int j = 0; j < input.length(); j++) {
//                    if (worlds[j].length() == min && wordCheck(worlds[j]))
//                        return minWord = worlds[j];
//                    }
//                }
//            }
//        return minWord;
//    }

    public static String mostCountedWord(String input) {//https://www.geeksforgeeks.org/count-occurrences-of-a-word-in-string/
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] words = input.split("\\s");
        //int count = 0; Ух я долго этот момент осознавал.
        int maxCount = 0;
        String mostRepetebleWord = null;

        for (int i = 0; i < words.length; i++) {
            int count = 0;// Таки каунт нужно тут вводить а не перед фор. Иначе будет выводить всегда последнее слово.
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j]) && wordCheck(words[i])) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                mostRepetebleWord = words[i];
            }
        }
        return mostRepetebleWord;
    }

//    public static String mostCountedWord(String input) {
//        if (input.length() == 0) {
//            return null;
//        }
//
//        String[] worlds = input.split(" ");
//        int count = 0;
//        int maxCount = 0;
//        String reiterationWord = null;
//
//        for (String word : worlds) {
//            for (String w : worlds) {
//                if (word.equals(w) && wordCheck(w)) {
//                    count++;
//                    if (count > maxCount) {
//                        maxCount = count;
//                        reiterationWord = word;
//                    }
//                }
//            }
//        }
//        return reiterationWord;
//    }

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
            } else {
                return false;
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

