package algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        int[] results = maxSlidingWindow(nums, k);
        printArray(results);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length * k == 0) {
            return new int[0];
        }
        if (k == 1) {
            return nums;
        }
        // 双向队列 保存当前窗口最大值的数组位置 保证队列中数组位置的数值按从大到小排序
        Deque<Integer> deque = new ArrayDeque<>(k);
        // 结果数组,长度为 nums.length - (k - 1)
        int[] results = new int[nums.length - (k - 1)];
        // 遍历 num s数组
        for (int i = 0; i < nums.length; i++) {
            // 判断当前队列中队首的值是否为窗口之外，deque.peekFirst() == i + 1 - k - 1;
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            // 保证从大到小 如果前面数小则需要依次弹出，直至满足要求
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            // 添加当前值对应的数组下标
            deque.offerLast(i);
            // 当窗口长度为 k 时 保存当前窗口中最大值
            if (i + 1 >= k) {
                results[i + 1 - k] = nums[deque.peekFirst()];
            }
        }
        return results;
    }

    public static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i);
        }
        System.out.println();
    }
}
