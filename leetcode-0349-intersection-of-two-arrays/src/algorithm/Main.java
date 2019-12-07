package algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        System.out.println(intersection(nums1, nums2).length);
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>(nums1.length);
        for (int num : nums1) {
            set.add(num);
        }
        int[] res = new int[Math.min(nums1.length, nums2.length)];
        int k = 0;
        for (int num : nums2) {
            if (set.contains(num)) {
                res[k++] = num;
                set.remove(num);
            }
        }
        return Arrays.copyOf(res, k);
    }
}
