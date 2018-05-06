package DynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Maximum sum increasing subsequence,
 * ref: https://practice.geeksforgeeks.org/problems/maximum-sum-increasing-subsequence/0
 * ref: https://leetcode.com/problems/maximum-subarray/description/
 */
public class MaxSumSubSequenceAssending {
    public static void main (String[] args) {
        //code
        int[] numsForSubArrayTest = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] numsForSubSequenceTest = {1, 101, 2, 3, 100, 4, 5};
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(7);
        list.add(100);
        System.out.print(-Collections.binarySearch(list, 0) - 1);
        System.out.println();

        int result = MaxSumSubArray(numsForSubArrayTest);
        List<Integer> indexes = MaxSumSubArrayIndex(numsForSubArrayTest);
        //System.out.print(result);
        indexes.forEach(i -> System.out.print(i));
        System.out.println();
        System.out.print(maxSubSequenceSumSolution1(numsForSubSequenceTest));
    }
    public static int MaxSumSubArray(int[] nums) {
        int sum = nums[0];
        int curMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum = nums[i] > (sum + nums[i]) ? nums[i] : (sum + nums[i]);
            curMax = Math.max(curMax, sum);
        }
        return curMax;
    }

    public static List<Integer> MaxSumSubArrayIndex(int[] nums) {
        int sum = nums[0];
        int curMax = nums[0];
        int curStart = 0, curEnd = 0, globalStart = 0, globalEnd = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > (sum + nums[i])) {
                curStart = i;
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            curEnd = i;
            if (sum > curMax) {
                globalStart = curStart;
                globalEnd = curEnd;
                curMax = sum;
            }
        }
        List<Integer> ret = new ArrayList<>();
        ret.add(globalStart);
        ret.add(globalEnd);
        return ret;
    }

    public static int maxSubSequenceSumSolution1(int[] nums) {
        int[] curSum = new int[nums.length];
        curSum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    curSum[i] = Math.max(curSum[i], nums[i] + curSum[j]);
                }
            }
        }
        int globalMax = curSum[0];
        for (int i = 1; i < curSum.length; i++) {
            globalMax = Math.max(globalMax, curSum[i]);
        }
        return globalMax;
    }

    public static int maxSubSequenceSumSolution2(int[] nums) {
        int[] curSum = new int[nums.length];
        curSum[0] = nums[0];
        int indicator = 0;
        List<Integer> sumTracker = new ArrayList<>();
        int ret = curSum[0];
        for (int i = 1; i < nums.length; i++) {
            int pos = Collections.binarySearch(sumTracker, nums[i]);
            if (pos < 0) {
                pos = -pos - 1;
            }
            if (pos == 0) {
                curSum[i] = nums[i];
            } else {
                curSum[i] = curSum[indicator] + nums[i];
            }

            if (pos == sumTracker.size()) {
                sumTracker.add(nums[i]);
                indicator = sumTracker.size() - 1;
            } else {
                indicator = pos;
            }
            ret = Math.max(curSum[i], ret);
        }
        return ret;
    }
}
