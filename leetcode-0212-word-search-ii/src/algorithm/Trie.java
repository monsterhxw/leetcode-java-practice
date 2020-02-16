package algorithm;

/** @author monstervivi */
public class Trie {

  class TrieNode {

    public TrieNode[] children = new TrieNode[26];

    public boolean isWord;

    public TrieNode() {}
  }

  private TrieNode root;

  public Trie() {
    root = new TrieNode();
  }

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
