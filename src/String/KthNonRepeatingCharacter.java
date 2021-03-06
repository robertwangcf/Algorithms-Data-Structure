package String;/*Given a string and a number k, find the k’th non-repeating character in the string.
Consider a large input string with lacs of characters and a small character set. How to find the character by only doing only one traversal of input string?

Examples:

Input : str = geeksforgeeks, k = 3
Output : r
First non-repeating character is f,
second is o and third is r.
*/

//s1, using two for loops, for every character, check its time of appearance and find the kth character with 1 time appearance
//Time: O(n^2)
//Space: O(1)

//s2, 1th traverse, using a hashmap to record all character in this string, key: character, value: time, 2nd traverse, traverse the string and check appearance for each character in map and find the kth character with only one time
//Time: O(2 * N)
//Space: O(N)

//s3, 1th traverse, use a regular array to check the time a character show up in the string, at the same time, use an auxiliary array to s determin if this character will be taken consider as non-repeating, by check if the character has shown up in regular array:
//case1: if it already showed up, then set value in auxiliary array to a un-reasonable value
//case2: if not, then set the value to character’s corresponding index in the string
//Time: O(N)
//Space:O(2 * N)

//I dont think there is a solution with better time complexity because at least traverse one time can a character be determined repeating or not
import java.util.Arrays;

/**
 * Created by Robert on 12/6/2016.
 */
public class KthNonRepeatingCharacter {
    static char kthNonRepeating(String str, int k) {
        //corner case1
        if (str == null ||str.length() == 0) {
            throw new IllegalArgumentException();
        }
        //corner case2
        if (str.length() == 1) {
            return str.charAt(0);
        }
        int[] regularArrayToStoreTheShowUpTime = new int[256];
        int[] auxiliaryArrayToStoreTheIndexOfNonRepeatingCharacter = new int[256];
        //here is a common mistake easy to be ignored!
        Arrays.fill(auxiliaryArrayToStoreTheIndexOfNonRepeatingCharacter, str.length());
        for (int i = 0; i < str.length(); i++) {
            regularArrayToStoreTheShowUpTime[str.charAt(i) - ' '] += 1;
            if (regularArrayToStoreTheShowUpTime[str.charAt(i) - ' '] == 1) {
                auxiliaryArrayToStoreTheIndexOfNonRepeatingCharacter[str.charAt(i) - ' '] = i;
            }
		else {
                auxiliaryArrayToStoreTheIndexOfNonRepeatingCharacter[str.charAt(i) - ' '] = str.length();
            }
        }
        Arrays.sort(auxiliaryArrayToStoreTheIndexOfNonRepeatingCharacter);
//assume k always valid, if not, throw exception
        return str.charAt(auxiliaryArrayToStoreTheIndexOfNonRepeatingCharacter[k -1]);
    }
    public static void main(String[] args) {
        String str1 = "geeksforgeeks";
        int k1 = 3;
        String str2 = "geeksforgeeks";
        int k2 = 2;
//        String str = "geeksforgeeks";
//        int k = 3;
        System.out.println(kthNonRepeating(str1, k1));
        System.out.println(kthNonRepeating(str2, k2));

    }
}
