package algorithm;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String s = "aacc";
        String t = "ccac";
        System.out.println(isAnagramUsingSort(s, t));
        System.out.println(isAnagramUsingHashTable(s, t));
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
}
