package lesson16.HomeWork;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        String test =("Some text for test Some text for test Some Some Some for for word");
        System.out.println(Arrays.toString(test.split("\\s+")));
        System.out.println(countWordsUsingSplit(test));
        System.out.println(mostCountedWord(test));

    }

    public static int countWordsUsingSplit(String input){
        if (input == null || input.isEmpty()){
            return 0;
        }

        String[] words=input.split("\\s+");
        return words.length;
    }

    public static String mostCountedWord(String input) {//https://www.geeksforgeeks.org/count-occurrences-of-a-word-in-string/
        if (input == null || input.isEmpty()) {
            return null;
        }

        String[] words = input.split("\\s");
        //int count = 0;
        int maxCount = 0;
        String mostRepetebleWord = null;

        for (int i = 0; i < words.length; i++) {
            int count = 0;// Таки каунт нужно тут вводить а не перед фор. Иначе будет выводить всегда последнее слово.
            for (int j = 0; j < words.length; j++) {
                if (words[i].equals(words[j])) {
                    count++;
                }
            }
            if (count > maxCount){
                maxCount = count;
                mostRepetebleWord = words[i];
            }
        }
        return mostRepetebleWord;
    }
}
