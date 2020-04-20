/*
Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.

Input:
A: [1,2,3,2,1]
B: [3,2,1,4,7]
Output: 3
Explanation: 
The repeated subarray with maximum length is [3, 2, 1].
*/
public class MaxLengthSubarray {
    public static int findLength(int[] A, int[] B) {
        int m = A.length, n = B.length, result = 0;
        int[][] memo = new int[m+1][n+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i]==B[j]) {
                    memo[i+1][j+1] = memo[i][j] +1;
                    result = Math.max(result, memo[i+1][j+1]);
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] A = {1,2,3,2,1};
        int[] B = {3,2,1,4,7};

        System.out.println(findLength(A, B));
    }
}