package Java;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class GroupAnagrams {

    @Test
    void groupAnagramsTest() {

        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};

        groupAnagrams(strs);
        groupAnagramsBest(strs);
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        ArrayList<String> arrayList = new ArrayList<>(List.of(strs));

        for (String currentKey : strs) {
            List<String> currentList = new ArrayList<>();

            for (String str : strs) {
                if (isAnagramBest(currentKey, str)) {
                    currentList.add(str);
                    arrayList.remove(str);
                }
            }
            arrayList.remove(currentKey);
            String key = currentKey.chars().sorted().mapToObj(c -> String.valueOf((char) c)).collect(Collectors.joining());
            map.put(key, currentList);
        }

        return new ArrayList<>(map.values());

    }

    private boolean isAnagramBest(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] store = new int[26];

        for (int i = 0; i < s.length(); i++) {
            store[s.charAt(i) - 'a']++;
            store[t.charAt(i) - 'a']--;
        }

        for (int n : store) if (n != 0) return false;

        return true;
    }

    public List<List<String>> groupAnagramsBest(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if (strs.length == 0) return res;
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            int[] hash = new int[26];
            for (char c : s.toCharArray()) {
                hash[c - 'a']++;
            }
            String key = new String(Arrays.toString(hash));
            map.computeIfAbsent(key, k -> new ArrayList<>());
            map.get(key).add(s);
        }
        res.addAll(map.values());
        return res;
    }
}
