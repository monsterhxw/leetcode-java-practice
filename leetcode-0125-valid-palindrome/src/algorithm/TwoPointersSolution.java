package algorithm;

/**
 * @author XueweiHuang
 */
public class TwoPointersSolution {

    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println("String Value is : " + str);
        System.out.println("Valid Palindrome result is : " + isPalindrome(str));

        str = "race a car";
        System.out.println();
        System.out.println("String Value is : " + str);
        System.out.println("Valid Palindrome result is : " + isPalindrome(str));

        str = "A___b_____a";
        System.out.println();
        System.out.println("String Value is : " + str);
        System.out.println("Valid Palindrome result is : " + isPalindrome(str));
    }

    public static boolean isPalindrome(String s) {

        if (s.length() == 1) {
            return true;
        }

        s = s.toLowerCase();

        int leftPtr = 0;
        int rightPtr = s.length() - 1;

        while (leftPtr < rightPtr) {
            while (leftPtr < rightPtr && !isLetterOrDigit(s.charAt(leftPtr))) {
                leftPtr++;
            }

            while (leftPtr < rightPtr && !isLetterOrDigit(s.charAt(rightPtr))) {
                rightPtr--;
            }

            if (s.charAt(leftPtr) != s.charAt(rightPtr)) {
                return false;
            }

            leftPtr++;
            rightPtr--;
        }

        return true;
    }

    private static boolean isLetterOrDigit(char c) {
        return (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
}