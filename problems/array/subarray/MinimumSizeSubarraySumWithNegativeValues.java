
import java.util.*;
public class MinimumSizeSubarraySumWithNegativeValues {
    public static int minSubArrayLen(int[] A, int s) {
        int n = A.length;
        int[] prefix = new int[n+1];
        for (int i = 0; i < n; i++) {
            prefix[i+1] = prefix[i] + A[i];
        }
        int result = n+1;
        
        Deque<Integer> dq = new LinkedList<>();
        
        for (int i = 0; i < prefix.length; i++) {
            while (!dq.isEmpty() && prefix[i] <= prefix[dq.getLast()]) {
                dq.removeLast();
            }
            while (!dq.isEmpty() && prefix[i] >= prefix[dq.getFirst()]+s) {
                result = Math.min(result, i-dq.removeFirst());
            }
            dq.addLast(i);
        }
        return result == n+1 ? -1 : result;
    }

    public static void main(String[] args) {
        int[] nums = {2,-1,2};
        System.out.println(minSubArrayLen(nums, 3));
    }
}