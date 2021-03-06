package by.it.korotkevich.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {

    private static String[] words = {};
    private static int[] counts = {};


    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while (matcher.find()) {
            String word = matcher.group();
            processOneWord(word);
        }
        for (int i = 0; i < words.length; i++) {
            System.out.printf("%s=%d\n", words[i], counts[i]);
        }
    }

    private static void processOneWord(String word) {
        for (int i = 0, wordsLength = words.length; i < wordsLength; i++) {
            String currentWord = words[i];
            if (currentWord.equals(word)) {
                counts[i] = counts[i] + 1;
                return;
            }
        }
        final int newLength = words.length + 1;
        words = Arrays.copyOf(words, newLength);
        counts = Arrays.copyOf(counts, newLength);
        words[words.length - 1] = word;
        counts[counts.length - 1] = 1;
    }
}
