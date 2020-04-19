/*

Given an array of n positive integers and a positive integer s, 
find the minimal length of a contiguous subarray of which the sum ≥ s. 
If there isn't one, return 0 instead.
*/
public class MinimumSizeSubarraySum {
    public static int minSubArrayLen(int[] nums, int s) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int i = 0, j = 0, sum = 0, min = Integer.MAX_VALUE;
        while (j < nums.length) {
            sum += nums[j];

            while (sum >= s) {
                min = Math.min(min, j-i+1);
                sum -= nums[i];
                i++;
            }
            j++;
        }
        return min;
    }

    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        System.out.println(minSubArrayLen(nums, 7));
    }
}