/*

Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

Find the maximum coins you can collect by bursting the balloons wisely.

Example:
Input: [3,1,5,8]
Output: 167 
Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
             coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
*/
class BurstBalloons {

    public static int maxCoins(int[] balloons) {
        int[][] memo = new int[balloons.length][balloons.length];
        return maxCoinsInRange(balloons, 0, balloons.length-1, memo);
    }

    public static int maxCoinsInRange(int[] balloons, int start, int end, int[][] memo) {
        if (start > end) return 0;
        if (memo[start][end] != 0) {
            return memo[start][end];
        }
        int coins = balloons[start];
        for (int i = start; i <= end; i++) {
            int c = maxCoinsInRange(balloons, start, i-1, memo) +
                getCoin(balloons, i) * 
                getCoin(balloons, start-1) * 
                getCoin(balloons, end+1) +
                maxCoinsInRange(balloons, i+1, end, memo);
            coins = Math.max(coins, c);
        }
        memo[start][end] = coins;
        return memo[start][end];
    }

    public static int getCoin(int[] balloons, int index) {
        if (index < 0 || index >= balloons.length) {
            return 1;
        }
        return balloons[index];
    }

    public static void main (String[] args) {
        int[] balloons = {3,1,5,8};
        System.out.println(maxCoins(balloons));
    }
}