package algorithm;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(firstUniqChar(str));
        System.out.println(firstUniqCharUsingHash(str));
    }

    public static int firstUniqChar(String s) {
        int[] freq = new int[26];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        for (char c : s.toCharArray()) {
            if (1 == freq[c - 'a']) {
                return s.indexOf(c);
            }
        }
        return -1;
    }

    public static int firstUniqCharUsingHash(String s) {
        HashMap<Character, Integer> count = new HashMap<>(s.length());
        for (char c : s.toCharArray()) {
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (count.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }
}
