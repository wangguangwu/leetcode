package com.wangguangwu.doublepointer;

import java.util.HashMap;

/**
 * @author wangguangwu
 */
public class CheckInclusion {

    public static void main(String[] args) {
        CheckInclusion solution = new CheckInclusion();
        boolean b = solution.checkInclusion("abc", "bbbca");
        System.out.println(b);
    }

    public boolean checkInclusion(String s1, String s2) {
        // 需要的数据
        HashMap<Character, Integer> need = new HashMap<>();
        // 窗口
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 双指针
        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);

            if (need.containsKey(c) && window.get(c).equals(need.get(c))) {
                valid++;
            }
            right++;

            // 满足条件
            while (valid == need.size()) {
                if (right - left == s1.length()) {
                    return true;
                }

                char d = s2.charAt(left);

                if (need.containsKey(d) && window.get(d).equals(need.get(d))) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
                left++;
            }
        }
        return false;
    }
}
