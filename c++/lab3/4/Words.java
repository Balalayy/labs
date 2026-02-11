import java.util.*;

public class Words {
    public static void main(String[] args) {
        String text = "Hi. Hello. Hey. Greetings.";
        
        Map<String, Integer> wordCount = new HashMap<>();
        String[] words = text.toLowerCase().split("\\W+");
        
        for (String word : words) {
            if (!word.isEmpty()) {wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);}
        }
        System.out.println(wordCount);
    }
}