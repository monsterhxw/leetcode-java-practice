package algorithm;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagramUsingSort(s, t));
        System.out.println(isAnagramUsingHashTable(s, t));
        System.out.println(isAnagramUsingMap(s, t));
    }

    public static boolean isAnagramUsingSort(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] chart = t.toCharArray();
        Arrays.sort(chars);
        Arrays.sort(chart);
        return Arrays.equals(chars, chart);
    }

    public static boolean isAnagramUsingHashTable(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i) - 'a']++;
            counts[t.charAt(i) - 'a']--;
        }
        for (int count : counts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isAnagramUsingMap(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> maps = new HashMap<>(s.length());
        Map<Character, Integer> mapt = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            maps.put(s.charAt(i), maps.get(s.charAt(i)) == null ? 0 : maps.get(s.charAt(i)) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            mapt.put(t.charAt(i), mapt.get(t.charAt(i)) == null ? 0 : mapt.get(t.charAt(i)) + 1);
        }
        return maps.equals(mapt);
    }
}
