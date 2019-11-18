package algorithm;

/**
 * @author monstervivi
 */
public class Main {

    public static void main(String[] args) {
        int k = 3;
        int[] arr = {4, 5, 8, 2};
        KthLargest kthLargest = new KthLargest(k, arr);
        System.out.println(String.format("kthLargest add 3, return %d", kthLargest.add(3)));
        System.out.println(String.format("kthLargest add 5, return %d", kthLargest.add(5)));
        System.out.println(String.format("kthLargest add 10, return %d", kthLargest.add(10)));
        System.out.println(String.format("kthLargest add 9, return %d", kthLargest.add(9)));
        System.out.println(String.format("kthLargest add 4, return %d", kthLargest.add(4)));
    }
}
