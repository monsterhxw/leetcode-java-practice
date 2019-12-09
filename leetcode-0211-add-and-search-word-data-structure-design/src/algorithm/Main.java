package algorithm;

public class Main {

    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        // return false
        System.out.println(wordDictionary.search("pad"));
        // return true
        System.out.println(wordDictionary.search("bad"));
        // return true
        System.out.println(wordDictionary.search(".ad"));
        // return true
        System.out.println(wordDictionary.search("b.."));
    }
}
