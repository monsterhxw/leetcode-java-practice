package algorithm;

/** @author monstervivi */
public class TrieUsingArray {

  class TrieNode {

    public boolean isWord;

    public TrieNode[] children = new TrieNode[26];

    public TrieNode() {}
  }

  private TrieNode root;

  /** Initialize your data structure here. */
  public TrieUsingArray() {
    root = new TrieNode();
  }

  /** Inserts a word into the trie. */
  public void insert(String word) {
    TrieNode dummy = root;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (dummy.children[c - 'a'] == null) {
        dummy.children[c - 'a'] = new TrieNode();
      }
      dummy = dummy.children[c - 'a'];
    }

    dummy.isWord = true;
  }

  /** Returns if the word is in the trie. */
  public boolean search(String word) {
    TrieNode dummy = root;

    for (int i = 0; i < word.length(); i++) {
      char c = word.charAt(i);
      if (dummy.children[c - 'a'] == null) {
        return false;
      }
      dummy = dummy.children[c - 'a'];
    }

    return dummy.isWord;
  }

  /** Returns if there is any word in the trie that starts with the given prefix. */
  public boolean startsWith(String prefix) {
    TrieNode dummy = root;

    for (int i = 0; i < prefix.length(); i++) {
      char c = prefix.charAt(i);
      if (dummy.children[c - 'a'] == null) {
        return false;
      }
      dummy = dummy.children[c - 'a'];
    }

    return true;
  }
}
