package QuadrateSearch;/*reference: https://leetcode.com/problems/search-for-a-range/
Given a sorted array of n integers, find the starting and ending position of a given target value.
* If the target is not found in the array, return [-1, -1].
* Example
* Given [5, 7, 7, 8, 8, 10] and target value 8,
* return [3, 4].

*/

//solution, use two binary search, every search to find left / right bound. Time: O(2 * logN), Space: O(1)
class Solution {
    public static int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int[] ret = new int[2];
        int start = 0;
        int end = nums.length - 1;
        int left = start;
        int right = end;
        int middle;
        //first find the left bound
        while (left + 1 < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] >= target) {
                right = middle;
            } else {
                left = middle;
            }
        }
        ret[0] = nums[left] == target ? left :
                nums[right] == target ? right :
                        -1;

        //second binary search for the right bound
        left = start;
        right = end;
        while (left + 1 < right) {
            middle = left + (right - left) / 2;
            if (nums[middle] > target) {
                right = middle;
            } else {
                left = middle;
            }
        }
        ret[1] = nums[right] == target ? right :
                nums[left] == target ? left :
                        -1;
        return ret;
    }

    public static void main(String[] args) {
        int[] array = new int[]{5, 7, 7, 8, 8, 10};
        int target = 8;
        System.out.println(searchRange(array, target));
    }
}
