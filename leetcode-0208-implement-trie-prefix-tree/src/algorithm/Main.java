package algorithm;

public class Main {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        // returns true
        System.out.println(trie.search("apple"));

        // returns false
        System.out.println(trie.search("app"));
        // returns true
        System.out.println(trie.startsWith("app"));

        trie.insert("app");
        // returns true
        System.out.println(trie.search("app"));
    }
}
