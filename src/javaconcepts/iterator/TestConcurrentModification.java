package javaconcepts.iterator;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by shumishra on 11/28/17.
 */
public class TestConcurrentModification {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();

        map.put("1", "A");
        map.put("2", "B");
        map.put("3", "C");
        map.put("4", "D");

        map.forEach((k,v) -> {
            String read = map.get(k);

        });
    }
}
