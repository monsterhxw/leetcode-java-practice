package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    System.out.println("using map");
    TrieUsingMap trieUsingMap = new TrieUsingMap();
    trieUsingMap.insert("apple");
    // returns true
    System.out.println(trieUsingMap.search("apple"));

    // returns false
    System.out.println(trieUsingMap.search("app"));
    // returns true
    System.out.println(trieUsingMap.startsWith("app"));

    trieUsingMap.insert("app");
    // returns true
    System.out.println(trieUsingMap.search("app"));

    System.out.println("using array");
    TrieUsingArray trieUsingArray = new TrieUsingArray();
    trieUsingArray.insert("apple");
    // returns true
    System.out.println(trieUsingArray.search("apple"));

    // returns false
    System.out.println(trieUsingArray.search("app"));
    // returns true
    System.out.println(trieUsingArray.startsWith("app"));

    trieUsingArray.insert("app");
    // returns true
    System.out.println(trieUsingArray.search("app"));
  }
}
