import java.util.*;

public class Mapp {
    public static <K, V> Map <V, K> swap(Map<K, V> map) {
        Map<V, K> swapped = new HashMap<>();
        for (Map.Entry<K, V> entry : map.entrySet()) {
            swapped.put(entry.getValue(), entry.getKey());
        }
        return swapped; 
    }  
    public static void main(String[] args) {
        Map<String, Integer> original = Map.of("q", 1, "w", 2, "e", 3);
        Map<Integer, String> swapped = swap(original);
        System.out.println(swapped);
    }
}