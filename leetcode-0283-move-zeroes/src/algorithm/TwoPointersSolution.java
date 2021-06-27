package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-06-28
 */
public class TwoPointersSolution {

  public void moveZeroes(int[] nums) {
    // 指向已处理好的序列的尾部指针
    int handledTail = 0;
    // 指向待处理序列的头部指针
    int unHandledHead = 0;
    // unHandledHead 向右移动，指向非零元素，并交换 handledTail 指向的元素，同时 handledTail 向右移动
    while (unHandledHead < nums.length) {
      if (nums[unHandledHead] != 0) {
        if (handledTail != unHandledHead) {
          swap(nums, handledTail, unHandledHead);
        }
        handledTail++;
      }
      unHandledHead++;
    }
  }

  private void swap(int[] arr, int index1, int index2) {
    arr[index1] = arr[index1] ^ arr[index2];
    arr[index2] = arr[index1] ^ arr[index2];
    arr[index1] = arr[index1] ^ arr[index2];
  }
}
