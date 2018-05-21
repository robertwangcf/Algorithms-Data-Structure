package Sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String args[]) {
        //for testing only
        int test[] = {3,2,1,4,5};
        sortIntegers2(test);
        Arrays.stream(test)
                .forEach(ele -> System.out.print(ele));
    }
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public static void sortIntegers2(int[] A) {
        // write your code here
        if (A == null || A.length == 0) {
            return;
        }
        int[] helper = new int[A.length];
        int left = 0;
        int right = A.length - 1;
        mergeSort(A, left, right, helper);
    }

    private static void mergeSort(int[] A, int left, int right, int[] helper) {
        if (left < right) {
            int middle = left + (right - left) / 2;
            mergeSort(A, left, middle, helper);
            mergeSort(A, middle + 1, right, helper);
            mergeTwoSortedArray(A, left, middle, right, helper);
        }
    }

    private static void mergeTwoSortedArray(int[] A, int left, int middle, int right, int[] helper) {
        for (int i = left; i <= right; i++) {
            helper[i] = A[i];
        }
        int startPointer1 = left;
        int startPointer2 = middle + 1;
        int i = left;
        while (startPointer1 < (middle + 1) && startPointer2 < (right + 1)) {
            if (helper[startPointer1] <= helper[startPointer2]) {
                A[i++] = helper[startPointer1++];
            } else {
                A[i++] = helper[startPointer2++];
            }
        }

        int remainingLeftPart = middle - startPointer1;
        while(remainingLeftPart-- >= 0) {
            A[i++] = helper[startPointer1++];
        }
    }
}