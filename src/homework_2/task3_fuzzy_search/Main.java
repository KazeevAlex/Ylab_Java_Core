package homework_2.task3_fuzzy_search;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
        Task3
            Реализовать функцию нечеткого поиска
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Result of cycle implementation of Fuzzy Search");
        for (String[] pair : TEST_DATA) {
            System.out.println(fuzzySearch(pair[0], pair[1]));
        }

        System.out.println("\nResult of stream implementation of Fuzzy Search");
        for (String[] pair : TEST_DATA) {
            System.out.println(streamFuzzySearch(pair[0], pair[1]));
        }
    }

    // Cycle implementation
    public static boolean fuzzySearch(String target, String text) {
        if (text.length() < target.length()) return false;

        char[] textChars = text.toCharArray();
        char[] targetChars = target.toCharArray();

        for (int i = 0, j = 0; i < text.length(); i++) {
            if (textChars[i] == targetChars[j]) {
                j++;
                if (j == target.length()) return true;
            }
        }
        return false;
    }

    // Stream implementation
    public static boolean streamFuzzySearch(String target, String text) {
        return Arrays.stream(text.split(""))
                .filter(target::contains)
                .collect(Collectors.joining()).contains(target);
    }

    private static final String[][] TEST_DATA = {
            {"car", "ca6$$#_rtwheel"},
            {"cwhl", "cartwheel"},
            {"cwhee", "cartwheel"},
            {"cartwheel", "cartwheel"},
            {"cwheeel", "cartwheel"},
            {"lw", "cartwheel"}
    };
}
