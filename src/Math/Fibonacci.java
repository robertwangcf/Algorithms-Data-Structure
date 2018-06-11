package Math;

/**
 * Write a function to find nth Fibonacci number with O(1) space
 */
//0, 1, 1, 2, 3, 5, 8, 11
public class Fibonacci {
    public static void main(String args[]) {
        //for testing only
        //System.out.println(fibonacci(16));
        String i = "a b c";
        System.out.print(i.replaceAll(" ", "  "));
    }

    public static int fibonacci(int n) {
        int i = 0;
        int j = 1;
        if (n == 1) {
            return i;
        }
        if (n == 2) {
            return j;
        }
        int ret = 0;
        for (int nth = 3; nth <= n; nth++) {
            ret = i + j;
            i = j;
            j = ret;
        }
        return ret;
    }
}
