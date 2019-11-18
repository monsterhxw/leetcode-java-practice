package algorithm;

import java.util.PriorityQueue;

/**
 * @author monstervivi
 */
public class KthLargest {

    private PriorityQueue<Integer> priQueue;

    private int limit;

    public KthLargest(int k, int[] nums) {
        limit = k;
        priQueue = new PriorityQueue<>();
        for (int num : nums) {
            add(num);
        }
    }

    public int add(int val) {
        if (limit > priQueue.size()) {
            priQueue.add(val);
        } else if (val > priQueue.peek()) {
            priQueue.poll();
            priQueue.add(val);
        }
        return priQueue.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */