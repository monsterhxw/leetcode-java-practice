package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-1, 0, 1, 2, -1, -4};

        System.out.println((new Main()).threeSumUsingBF(nums));

        System.out.println((new Main()).threeSumUsingSet(nums));
    }

    public List<List<Integer>> threeSumUsingSet(int[] nums) {
        if (nums.length < 3) {
            return Collections.EMPTY_LIST;
        }

        Set<List<Integer>> result = new HashSet<>();

        // 将 nums 进行排序
        Arrays.sort(nums);

        Set<Integer> dummy;

        for (int i = 0; i < nums.length - 2; i++) {
            // 固定第一个数为 v
            int v = nums[i];
            // 与上一个值相等，则上一轮已经找到过相同解法
            if (i > 0 && v == nums[i - 1]) {
                continue;
            }
            dummy = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                Integer x = nums[j];
                // 若当前的 x 不存在于 dummy 集合中，则将预期数放入 dummy 集合中
                // 若存在于 dummy 集合中，则找出了正确的组合， 将组合放入 result 集合（去重）
                if (!dummy.contains(x)) {
                    // 当其中一个数为 x，另一个数只能是 -v - x
                    // 因 v + x + d = 0，所以 d = -v - x
                    dummy.add(-v - x);
                } else {
                    result.add(Arrays.asList(v, -v - x, x));
                }
            }
        }
        return new ArrayList<>(result);
    }

    public List<List<Integer>> threeSumUsingBF(int[] nums) {
        List<List<Integer>> ret = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> temp = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k]));
                        if (isInList(ret, temp)) {
                            continue;
                        }
                        ret.add(temp);
                    }
                }
            }
        }
        return ret;
    }

    private boolean isInList(List<List<Integer>> l, List<Integer> a) {
        for (int i = 0; i < l.size(); i++) {
            if (isSame(l.get(i), a)) {
                return true;
            }
        }
        return false;
    }

    private boolean isSame(List<Integer> a, List<Integer> b) {
        Collections.sort(a);
        Collections.sort(b);
        for (int i = 0; i < a.size(); i++) {
            if (!a.get(i).equals(b.get(i))) {
                return false;
            }
        }
        return true;
    }
}
