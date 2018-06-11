package String;

import java.util.Arrays;

/**
 * Created by Robert on 5/27/2018.
 */
public class LongestPalindronicSubstring {
    public static void main(String[] args) {
        String[] str = "asd asd    ".split(" ");
        //Arrays.stream(str).forEach(System.out::println);
/*        StringBuilder sb = new StringBuilder();
        System.out.print("st".substring(0, 0));*/
    }
    public static String longestPalindrome(String s) {
        int i = 0;
        int start = 0;
        int end = 0;
        //int globalMax = 0;
        while (i < s.length()) {
            int length1 = expand(s, i, i);
            int length2 = expand(s, i, i + 1);
            int curMax = Math.max(length1, length2);
            if (curMax > end - start + 1) {
                start = i - (curMax - 1) / 2;
                end = i + curMax / 2;
                //curMax
            }
            i++;
        }
        return s.substring(start, end + 1);
    }

    private static int expand(String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            i--;
            j++;
        }
        return j - i - 1;
    }
}
