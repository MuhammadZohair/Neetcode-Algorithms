package Java;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given two strings s and t, return true if t is an anagram of s, and false otherwise.
 * <p>
 * An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length, t.length <= 5 * 104
 * s and t consist of lowercase English letters.
 * <p>
 * Link: https://leetcode.com/problems/valid-anagram/
 */
public class ValidAnagram {

    @Test
    public void isAnagramTest() {

        String s = "anagram";
        String t = "nagaram";

        String s1 = "rat";
        String t1 = "car";

        Assertions.assertTrue(isAnagram(s, t));
        Assertions.assertFalse(isAnagram(s1, t1));

        Assertions.assertTrue(isAnagramBest(s, t));
        Assertions.assertFalse(isAnagramBest(s1, t1));
    }

    /**
     * Note: This method was written best to my knowledge
     *
     * @param s the super string
     * @param t the string which has to be checked
     * @return true if t string contains all the characters which are in s
     */
    public boolean isAnagram(String s, String t) {
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

    /**
     * Note: This method is based on the best solutions I found over the
     * internet in terms of Time and Space complexity.
     *
     * @param s the super string
     * @param t the string which has to be checked
     * @return true if t string contains all the characters which are in s
     */
    public boolean isAnagramBest(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }
}