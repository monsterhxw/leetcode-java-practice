package algorithm;

/**
 * @author XueweiHuang
 * @created 2021-07-08
 */
public interface MinStack {

  void push(int val);

  void pop();

  int top();

  int getMin();
}
