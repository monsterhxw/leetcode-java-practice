package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int x = 5;
    System.out.println(
        "using binary search : " + "x = " + x + ", square root is " + main.mySqrt(x));
  }

  public int mySqrt(int x) {
    if (x == 0 || x == 1) {
      return x;
    }
    int left = 0;
    int right = x;
    int result = 0;
    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (middle == x / middle) {
        return middle;
      } else if (middle > x / middle) {
        right = middle - 1;
      } else {
        left = middle + 1;
        result = middle;
      }
    }
    return result;
  }
}
