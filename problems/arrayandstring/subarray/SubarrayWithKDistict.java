/*
Given an array A of positive integers, call a (contiguous, not necessarily distinct) 
subarray of A good if the number of different integers in that subarray is exactly K.

(For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)

Return the number of good subarrays of A.

Input: A = [1,2,1,2,3], K = 2
Output: 7
Explanation: Subarrays formed with exactly 2 different integers: 
[1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
*/

import java.util.*;
public class SubarrayWithKDistict {
    public static int subarraysWithKDistinct(int[] A, int K) {
        return subarraysWithAtMostK(A, K) - subarraysWithAtMostK(A, K-1);
    }

    public static int subarraysWithAtMostK(int[] A, int K) {
        Map<Integer, Integer> map = new HashMap<>();
        int i = 0, j = 0, n = A.length, count=0;
        while (j < n) {
            map.put(A[j], map.getOrDefault(A[j], 0)+1);
            while (map.size()>K) {
                map.put(A[i], map.get(A[i])-1);
                if (map.get(A[i])<= 0) map.remove(A[i]);
                i++;
            }
            count += j-i+1;
            j++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] A = {1,2,1,2,3};
        System.out.println(subarraysWithKDistinct(A, 2));
    }
}