package com.wangguangwu.doublepointer;

import java.util.HashMap;

/**
 * @author wangguangwu
 */
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        LengthOfLongestSubstring solution = new LengthOfLongestSubstring();
        int result = solution.lengthOfLongestSubstring("pwwkew");
        System.out.println(result);
    }

    public int lengthOfLongestSubstring(String s) {
        int result = 0;

        HashMap<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;

            // 收缩窗口
            while (window.get(c) > 1) {
                char d = s.charAt(left);
                window.put(d, window.get(d) - 1);
                left++;
            }
            result = Math.max(right - left, result);
        }
        return result;
    }
}
