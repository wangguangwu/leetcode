package com.wangguangwu.doublepointer;

import java.util.HashMap;

/**
 * @author wangguangwu
 */
public class MinWindow {

    public static void main(String[] args) {
        MinWindow solution = new MinWindow();
        String result = solution.minWindow("ADOBECODEBANC", "ABC");
        System.out.println(result);
    }

    public String minWindow(String s, String t) {
        // 需要的字符
        HashMap<Character, Integer> need = new HashMap<>();
        // 窗口
        HashMap<Character, Integer> window = new HashMap<>();
        // 统计 t 中各字符出现的次数
        for (char c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 双指针
        int left = 0;
        int right = 0;
        // 窗口中需要满足的字符个数
        int valid = 0;
        // 记录最小覆盖子串的起始索引及长度
        int start = 0;
        int len = Integer.MAX_VALUE;
        while (right < s.length()) {
            // 将要移入窗口的字符
            char c = s.charAt(right);
            // 扩大窗口
            right++;
            // 进行窗口内的数据更新
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(need.get(c))) {
                    valid++;
                }
            }

            // 判断左侧窗口是否要收缩
            while (valid == need.size()) {
                // 更新最小覆盖子串
                if (right - left < len) {
                    start = left;
                    len = right - left;
                }
                // 将要移出窗口的字符
                char d = s.charAt(left);
                // 缩小窗口
                left++;
                // 进行窗口内的数据更新
                if (need.containsKey(d)) {
                    window.put(d, window.get(d) - 1);
                    if (window.get(d).compareTo(need.get(d)) < 0) {
                        // 移出后不再符合条件
                        valid--;
                    }
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
