package algorithm;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    int n = 5;

    int[] answersOptimization = (new Main()).countBitsOptimization(n);
    System.out.println("Optimization method : n is " + n);
    for (int i = 0; i < answersOptimization.length; i++) {
      System.out.print(answersOptimization[i] + " ");
    }

    System.out.println();

    int[] answers = (new Main()).countBits(n);
    System.out.println("ordinary method : n is " + n);
    for (int i = 0; i < answers.length; i++) {
      System.out.print(answers[i] + " ");
    }
  }

  // i & (i - 1)中 1 的个数一定比少 1 ，而且 i & (i - 1) < i 满足拓扑序可以 dp
  // 总结一下常见的位运算 dp 可以有:
  // i & j < i
  // i | j > i
  // i << k > i
  // i >> k < i
  // 但凡有这种大小关系都可以拿来 dp
  public int[] countBitsOptimization(int num) {
    int[] answers = new int[num + 1];

    for (int i = 1; i <= num; i++) {
      answers[i] = answers[i & (i - 1)] + 1;
    }

    return answers;
  }

  public int[] countBits(int num) {
    int[] answers = new int[num + 1];

    for (int i = 1; i <= num; i++) {
      // 偶数：二进制表示中，偶数中 1 的个数一定和除以 2 之后的那个数一样多。
      // 因为最低位是 0，除以 2 就是右移一位，也就是把那个 0 抹掉而已，所以 1 的个数是不变的。
      if (i % 2 == 0) {
        answers[i] = answers[i / 2];
      } else {
        // 奇数：二进制表示中，奇数一定比前面那个偶数多一个 1，因为多的就是最低位的 1。
        answers[i] = answers[i - 1] + 1;
      }
    }

    return answers;
  }
}
