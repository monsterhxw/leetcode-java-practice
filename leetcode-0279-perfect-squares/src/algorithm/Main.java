package algorithm;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/** @author monstervivi */
public class Main {

  public static void main(String[] args) {
    Main main = new Main();

    int n = 13;
    System.out.println("n is : " + n);

    System.out.println("using bfs, result is : " + main.numSquaresUsingBFS(n));
  }

  public int numSquaresUsingBFS(int n) {
    Queue<Integer> queue = new LinkedList<>();
    queue.add(0);

    Set<Integer> visited = new HashSet<>();
    visited.add(0);

    int distance = 0;

    while (!queue.isEmpty()) {
      distance++;

      int size = queue.size();
      for (int i = 0; i < size; i++) {
        int curr = queue.poll();
        for (int j = 1; j * j + curr <= n; j++) {
          int next = j * j + curr;
          if (next == n) {
            return distance;
          }
          if (next < n && !visited.contains(next)) {
            queue.add(next);
            visited.add(next);
          }
        }
      }
    }

    return distance;
  }
}
