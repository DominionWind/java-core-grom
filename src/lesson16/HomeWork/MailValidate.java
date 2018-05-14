package lesson16.HomeWork;

public class MailValidate {
    public static void main(String[] args) {

        System.out.println(validate("http://someMail@grom.com"));
        System.out.println(validate("http://some123Mail@grom.com"));


    }


    public static boolean validate(String adress) { //http://www.someMail@grom.com
        if (adress == null || adress.isEmpty()) {
            return false;
        }

        if (adress.endsWith(".com") || adress.endsWith(".net") || adress.endsWith(".org")) {
            String text = adress.substring(0, adress.length() - 4);
            if (adress.startsWith("http://")) {
                if (adress.startsWith("www.")){
                    text = text.substring(4);
                }
                String devText = text.substring(7);
                if (dogTest(devText) && worldsWalid(devText)){
                    return true;
                }
//                dogTest(devText);
//                worldsWalid(devText);
//                System.out.println(dogTest(devText) + "1");
//                System.out.println(worldsWalid(devText) + "2");
            } else if (adress.startsWith("https://")) {
                String devText = text.substring(8);
                if (adress.startsWith("www.")){
                    text = text.substring(4);
                }
                if (dogTest(devText)&&worldsWalid(devText)){
                    return true;
                }
//                dogTest(devText);
//                worldsWalid(devText);
//                System.out.println(dogTest(devText) + "3");
//                System.out.println(worldsWalid(devText) + "4");
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

//    private static boolean znakTest(String input) {
//        String[] test = input.split("://");
//        if (test.length > 1) ;
//        return false;
//    }

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
