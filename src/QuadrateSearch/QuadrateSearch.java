package QuadrateSearch;

/**
 * LC240, https://leetcode.com/problems/search-a-2d-matrix-ii/description/
 */
class QuadrateSearch {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int initialRow = matrix.length - 1;
        int initialCol = 0;
        while (initialRow >= 0 && initialCol < matrix[0].length) {
            if (matrix[initialRow][initialCol] == target) {
                return true;
            }
            if (matrix[initialRow][initialCol] < target) {
                initialCol++;
            } else {
                initialRow--;
            }
        }
        return false;
    }
}
