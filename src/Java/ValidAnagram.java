package Java;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static void main(String[] args) {

        String s = "a";
        String t = "ab";

        System.out.println(isAnagram(s, t));

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            sMap.merge(s.charAt(i), 1, Integer::sum);
        }
        for (int i = 0; i < t.length(); i++) {
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char character = entry.getKey();
            int counter = entry.getValue();

            if (tMap.containsKey(character)) {
                if (counter != tMap.get(character))
                    return false;
            } else return false;
        }
        return true;
    }
}
