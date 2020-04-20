/*
Given an integer array nums, find the contiguous subarray 
(containing at least one number) which has the largest sum 
and return its sum.
*/
public class MaxSubarray {
    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            cur = Math.max(nums[i], cur+nums[i]);
            max = Math.max(max, cur);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
}