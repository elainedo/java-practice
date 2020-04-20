/*
Given a string, find the length of the longest substring T that contains at most k distinct characters.

Input: s = "eceba", k = 2
Output: 3
Explanation: T is "ece" which its length is 3.
*/
import java.util.*;

public class LongestSubstringWithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstring(String s, int k) {
        int i = 0, j = 0, n = s.length(), result = 0;
        Map<Character, Integer> map = new HashMap<>();
        while (j < n) {
            char right = s.charAt(j);
            map.put(right, map.getOrDefault(right, 0)+1);
            while (map.size()>k) {
                char left = s.charAt(i);
                map.put(left, map.get(left)-1);
                if (map.get(left)==0) map.remove(left);
                i++;
            }
            result = Math.max(result, j-i+1);
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "eceba";
        System.out.println(lengthOfLongestSubstring(s, 2));
    }
}