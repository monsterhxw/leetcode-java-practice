package algorithm;

public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int[] heights = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};

    System.out.println("using double pointers solutions. max area is : " + main.maxArea(heights));
  }

  public int maxArea(int[] height) {
    int maxArea = 0;
    int left = 0;
    int right = height.length - 1;

    while (left < right) {
      int curArea;
      if (height[left] <= height[right]) {
        curArea = height[left] * (right - left);
        left++;
      } else {
        curArea = height[right] * (right - left);
        right--;
      }
      maxArea = curArea > maxArea ? curArea : maxArea;
    }

    return maxArea;
  }
}
