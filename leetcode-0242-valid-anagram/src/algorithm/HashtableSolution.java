package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-27
 */
public class HashtableSolution {
  /** Hashtable Solution; Time Complexity: O(n); Space Complexity: O(n); */
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    } else {
      int[] freq = new int[26];
      char[] sCharArr = s.toCharArray();
      char[] tCharArr = t.toCharArray();
      for (char c : sCharArr) {
        freq[c - 'a']++;
      }
      for (char ch : tCharArr) {
        if (freq[ch - 'a'] == 0) {
          return false;
        } else {
          freq[ch - 'a']--;
        }
      }
      return true;
    }
  }
}
