package algorithm;

/**
 * 适用于区间为空、答案不存在、有重复元素、搜索开/闭的上/下界等情况
 *
 * @author XueweiHuang
 * @see <a href="https://www.zhihu.com/question/36132386">@Jason Li</a>
 */
public class LowerBoundBinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 3, 3, 5, 5, 6};
        int target = 4;
        System.out.println("target value is " + target);
        System.out.println(
            "first element index in the range : " + lowerBound(nums, 0, nums.length, target));
    }

    /**
     * 求非降序范围 [first, last) 内第一个不小于 value 的值的位置
     */
    public static int lowerBound(int[] nums, int first, int last, int value) {
        int mid;
        // 搜索区间 [first, last) 不为空
        while (first < last) {
            // prevent integer-overflow
            mid = first + (last - first) / 2;
            if (nums[mid] < value) {
                first = mid + 1;
            } else {
                last = mid;
            }
        }
        // first or last 都可以，因为 [ first, last) 为空的时候他们重合
        return first;
    }
}