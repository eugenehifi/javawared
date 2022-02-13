package stage1;

import java.util.HashMap;

public class Task6 {
    public static void main(String[] args) {
        String text = "Hello World !";
        char[] s = text.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (!hashMap.containsKey(c)) {
                hashMap.put(c, 1);
            } else {
                Integer integer = hashMap.get(c);
                integer++;
                hashMap.put(c, integer);
            }
        }
        hashMap.entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .forEach(System.out::println);
    }
}



