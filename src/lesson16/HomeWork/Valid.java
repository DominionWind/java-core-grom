package lesson16.HomeWork;

import java.util.Arrays;

public class Valid {
    public static void main(String[] args) {

        System.out.println(validate("http://www.someMail@grom.com"));
        System.out.println(validate("http://some123Mail@grom.com"));

        System.out.println(validate("http://someMail@@grom.com"));
        System.out.println(validate("http://some.Mail@grom.com"));
        System.out.println(validate("http://://someMail@grom.com"));

        System.out.println(validate(" "));
        System.out.println(validate(""));

    }

    public static boolean validate(String adress) {
        if (adress.equals(null) || adress.isEmpty()) {
            return false;
        }

        if (adress.endsWith(".com") || adress.endsWith(".net") || adress.endsWith(".org")){
            adress = adress.substring(0,adress.length()-4);
            if (adress.startsWith("http://") || adress.startsWith("https://")) {
                String[] words = adress.split("://");
                if (words[1].startsWith("www.")){
                    words[1]=words[1].substring(4);
                }
                
            }
        }

        return false;
    }


    private static boolean nullEmptyCheck(String input) {
        if (input == null || input.isEmpty()) {
            return false;
        }
        return true;
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
        if (test.length > 2) {
            return false;
        }
        return true;
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
