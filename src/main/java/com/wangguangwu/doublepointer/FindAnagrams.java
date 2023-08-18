package com.wangguangwu.doublepointer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author wangguangwu
 */
public class FindAnagrams {

    public static void main(String[] args) {
        FindAnagrams solution = new FindAnagrams();
        List<Integer> list = solution.findAnagrams("cbaebabacd", "abc");
        System.out.println(list);
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        // 窗口
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        // 双指针
        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s.length()) {
            char c = s.charAt(right);
            window.put(c, window.getOrDefault(c, 0) + 1);
            right++;
            if (need.containsKey(c) && need.get(c).equals(window.get(c))) {
                valid++;
            }

            while (valid == need.size()) {
                if (right - left == p.length()) {
                    result.add(left);
                }
                char d = s.charAt(left);
                left++;
                if (need.containsKey(d) && need.get(d).equals(window.get(d))) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
            }
        }
        return result;
    }
}
