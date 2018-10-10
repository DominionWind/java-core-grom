package gromcode.main.lesson16.HomeWork;

public class MinMax {
    public static void main(String[] args) {

        System.out.println(maxWord("Some text is writing right there right now"));
        System.out.println(minWord("Some text is writing right there right now"));



    }
    public static String maxWord(String input) {
        String[] worlds = input.split(" ");
        String maxWord = null;

        if (worlds.length == 0) {
            return null;
        }

        for (String world : worlds) {
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
        for (String world : worlds) {
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

    static boolean wordCheck(String input) {
        char[] letters = input.toCharArray();
        for (char letter : letters) {
            if (!Character.isLetter(letter))
                return false;
        }
        return true;
    }
}
