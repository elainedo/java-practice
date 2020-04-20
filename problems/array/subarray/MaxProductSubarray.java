/*
Given an integer array nums, find the contiguous subarray within an array 
(containing at least one number) which has the largest product.

Input: [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.
*/

public class MaxProductSubarray {
    public static int maxProductSubarray(int[] nums) {
        int max = nums[0], min = nums[0], result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < 0) {
                int temp = min;
                min = max;
                max = temp;
            }

            max = Math.max(nums[i], nums[i]*max);
            min = Math.min(nums[i], nums[i]*min);

            result = Math.max(result, max);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,-2,4};
        System.out.println(maxProductSubarray(nums));
    }
}