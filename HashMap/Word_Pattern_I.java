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
  Alogorithm: Solution 1: To make sure that each character in pattern is bijective to word in str, do this with two hashmap,
  in hashmap1, key: character; in hashmap2, key: word.
              Solution 2: Make use of return value of put(). 
*/

public class WordPattern {
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
