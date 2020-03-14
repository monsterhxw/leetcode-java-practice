package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    String s = "22622";

    System.out.println("s is : " + s);

    System.out.println("using recursion , result is : " + main.numDecodings(s));
  }

  public int numDecodings(String s) {
    if (s == null || s.length() == 0 || s.charAt(0) == '0') {
      return 0;
    }

    if (s.length() == 1) {
      return 1;
    }

    return dfsHelper(0, s);
  }

  private int dfsHelper(int index, String s) {
    if (index == s.length()) {
      return 1;
    }

    if (s.charAt(index) == '0') {
      return 0;
    }

    int oneNumber = dfsHelper(index + 1, s);
    int twoNumber = 0;
    if (index < s.length() - 1) {
      if ((s.charAt(index) - '0') * 10 + (s.charAt(index + 1) - '0') <= 26) {
        twoNumber = dfsHelper(index + 2, s);
      }
    }
    return oneNumber + twoNumber;
  }
}
