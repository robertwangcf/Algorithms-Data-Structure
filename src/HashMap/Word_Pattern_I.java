package HashMap;

import java.util.HashMap;
import java.util.Objects;

/*Given a pattern and a string str, find if str follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

Examples:

    pattern = "abba", str = "dog cat cat dog" should return true.
    pattern = "abba", str = "dog cat cat fish" should return false.
    pattern = "aaaa", str = "dog cat cat dog" should return false.
    pattern = "abba", str = "dog dog dog dog" should return false.

Notes:
You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space. 
*/

/*Data structure: HashMap
  Alogorithm: Solution 1: To make sure that each character in pattern is bijective to word in str, do this with two hashmaps,
  in hashmap1, key: character, value: word; in hashmap2, key: word, value: character. 
              Time Complexity : O(N * M)    N = pattern.length(), M = max(str[i].length())

              Solution 2: Make use of return value of put() with only one hashmap. 
              Time Complexity : O(N) 
*/

public class Word_Pattern_I {
    public boolean wordPattern(String pattern, String str) {
        String[] des = str.split(" ");
        if (des.length != pattern.length()) {
            return false;
        }
        HashMap<Character, String> hmap1 = new HashMap<>();
        HashMap<String, Character> hmap2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!check1(hmap1, pattern, des, i)) {
                return false;
            }
            if (!check2(hmap2, pattern, des, i)) {
                return false;
            }
    }
    return true;
}
    public boolean check1(HashMap hmap, String pattern, String[] des, int i) {
        if (!hmap.containsKey(pattern.charAt(i))) {
                hmap.put(pattern.charAt(i), des[i]);
            }
            else {
                if (!hmap.get(pattern.charAt(i)).equals(des[i])) {
                    return false;
                }
            }
            return true;
    }
    public boolean check2(HashMap hmap, String pattern, String[] des, int i) {
        if (!hmap.containsKey(des[i])) {
                hmap.put(des[i], pattern.charAt(i));
            }
            else {
                if (!hmap.get(des[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
            return true;
    }
}
class Word_Pattern_I2 {
    public boolean wordPattern(String pattern, String str) {
        String[] des = str.split(" ");
        if (des.length != pattern.length()) {
            return false;
        }
        HashMap hmap = new HashMap<>();
        //HashMap<String, Character> hmap2 = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
            if (!Objects.equals(hmap.put(des[i], i), hmap.put(pattern.charAt(i), i))) {
                return false;
            }
    }
    return true;
}
}
/*Notes:
 1. What's the time comlexity of Objects.euqals(), as class String extends class Object, how about overriden function 
    in String?
    corner cases:  
    String Strii = "STR STR";
    String[] st = Strii.split(" ");
    System.out.println(st[0] == (st[1]));  //false because different reference
    System.out.println(st[0].equals(st[1])); //true because same value
    String[] st2 = {"STR", "STR"};
    System.out.println(st2[0] == (st[1])); //true because same in string pool

 2. Review String.toCharArray() and String.split()
    char[] ch = "".toCharArray();
    String test = "";
    String[] st = test.split(" ");
    System.out.println(ch.length == 0); //true
\   System.out.println(st.length == 0); //flase, because st contains one element with length of 0
*/