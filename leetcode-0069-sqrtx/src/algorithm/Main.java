package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();
    int x = 5;
    System.out.println(
        "using binary search : "
            + "x = "
            + x
            + ", square root is "
            + main.mySqrtUsingBinarySearch(x));
    System.out.println(
        "using binary search : "
            + "x = "
            + x
            + ", square root is "
            + main.mSqrtDoubleAndUsingBinarySearch(x, 1e-9));
  }

  public int mySqrtUsingBinarySearch(int x) {
    if (x < 0) {
      return -1;
    }

    if (x == 0 || x == 1) {
      return x;
    }

    int left = 0;
    int right = x;

    while (left <= right) {
      int middle = left + (right - left) / 2;
      if (middle == x / middle) {
        return middle;
      } else if (middle > x / middle) {
        right = middle - 1;
      } else {
        left = middle + 1;
      }
    }

    return left;
  }

  public double mSqrtDoubleAndUsingBinarySearch(int x, double epsilon) {
    if (x < 0) {
      return -1;
    }
    if (x == 0 || x == 1) {
      return x;
    }

    double left = 0;
    double right = x;

    while (left <= right) {
      double mid = left + (right - left) / 2;
      if (Math.abs(mid - x / mid) < epsilon) {
        return mid;
      } else if (mid > x / mid) {
        right = mid;
      } else {
        left = mid;
      }
    }

    return Double.NEGATIVE_INFINITY;
  }
}
