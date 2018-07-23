package lesson31.HomeWork;

import java.util.TreeMap;

public class Solution {

    public TreeMap<Character, Integer> countSymbols(String text) {
        TreeMap<Character, Integer> symbols = new TreeMap();

        char[] words = text.toCharArray();

        for (Character w : words) {
            if (Character.isLetter(w)) {
                if (!symbols.containsKey(w)) {
                    symbols.put(w, 1);
                } else {
                    symbols.put(w, symbols.get(w) + 1);
                }
            }
        }

        return symbols;
    }

    public TreeMap<String, Integer> words(String text) {
        TreeMap<String, Integer> result = new TreeMap();

        String[] words = text.split(" ");

        for (String w : words) {
            if (w.length() > 1) {
                if (!result.containsKey(w)) {
                    result.put(w, 1);
                } else {
                    result.put(w, result.get(w) + 1);
                }
            }

        }

        return result;
    }
}
