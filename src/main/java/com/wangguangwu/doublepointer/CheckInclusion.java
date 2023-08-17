package com.wangguangwu.doublepointer;

import java.util.HashMap;

/**
 * @author wangguangwu
 */
public class CheckInclusion {

    public static void main(String[] args) {
        CheckInclusion solution = new CheckInclusion();
        boolean b = solution.checkInclusion("trinitrophenylmethylnitramine", "dinitrophenylhydrazinetrinitrophenylmethylnitramine");
        System.out.println(b);
    }

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        // 需要的数据
        for (int i = 0; i < s1.length(); i++) {
            char c = s1.charAt(i);
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 双指针维护窗口
        int left = 0;
        int right = 0;
        int valid = 0;
        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否收缩
            while (right - left >= s1.length()) {
                // 判断是否找到了合法的子串
                if (valid == need.size()) {
                    return true;
                }
                // 要移出的数据
                char d = s2.charAt(left);
                left++;
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }
        }
        return false;
    }
}
