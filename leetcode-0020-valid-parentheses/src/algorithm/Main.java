package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        String s = "(({[{}]}))";

        System.out.println("using stack to valid parentheses.");
        System.out.println(isValid(s));

        System.out.println("not using map to valid parentheses.");
        System.out.println(isValidNotUsingMap(s));
    }

    private static final Map<Character, Character> MAP = new HashMap<Character, Character>() {
        {
            put(')', '(');
            put(']', '[');
            put('}', '{');
        }
    };

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (MAP.containsKey(ch)) {
                // 当栈 stack 为空时，执行 stack.pop() 操作会报错
                // 假设 s 中第一个元素是 (，此时就会报错了。但在最开始加一个 # 就可以避免这个问题。
                char top = stack.empty() ? '#' : stack.pop();
                if (top != MAP.get(ch)) {
                    return false;
                }
            } else {
                stack.add(ch);
            }
        }
        return stack.empty();
    }

    public static boolean isValidNotUsingMap(String s) {
        Stack<Character> stack = new Stack();
        for (char ch : s.toCharArray()) {
            if ('(' == ch) {
                stack.add(')');
            } else if ('{' == ch) {
                stack.add('}');
            } else if ('[' == ch) {
                stack.add(']');
            } else if (stack.empty() || ch != stack.pop()) {
                return false;
            }
        }
        return stack.empty();
    }
}
