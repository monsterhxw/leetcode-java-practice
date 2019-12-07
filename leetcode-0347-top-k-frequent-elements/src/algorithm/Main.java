package algorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {
        int k = 1;
        int[] nums = new int[]{3, 0, 1, 0};
        topKFrequent(nums, k).forEach(num -> System.out.print(num));
    }

    public static List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
//        PriorityQueue<Integer> minHeap = new PriorityQueue<>((num1, num2) -> map.get(num1) - map.get(num2))
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int num : map.keySet()) {
            if (minHeap.size() < k) {
                minHeap.add(num);
            } else if (map.get(num) > map.get(minHeap.peek())) {
                minHeap.poll();
                minHeap.add(num);
            }
        }
        List<Integer> topK = new LinkedList<>();
        while (!minHeap.isEmpty()) {
            topK.add(minHeap.poll());
        }
        Collections.reverse(topK);
        return topK;
    }
}
