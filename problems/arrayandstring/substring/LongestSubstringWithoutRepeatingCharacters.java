/*
Given a string, find the length of the longest substring without repeating characters.

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
*/

import java.util.*;
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0, n = s.length(), result = 0;
        Set<Character> set = new HashSet<>();
        while (j < n) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));
                i++;
            }
            result = Math.max(result, j-i+1);
            set.add(s.charAt(j));
            j++;
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}