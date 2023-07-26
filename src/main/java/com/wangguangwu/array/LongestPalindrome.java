package com.wangguangwu.array;

/**
 * @author wangguangwu
 */
public class LongestPalindrome {

    public static void main(String[] args) {
        String s = "cbb";

        LongestPalindrome solution = new LongestPalindrome();
        System.out.println(solution.longestPalindrome(s));
    }

    /**
     * 如何解决奇数的问题
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 找出以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 找出以 s[i] 和 s[i + 1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);

            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;
    }

    /**
     * 在 s 中寻找以 s[l] 和 s[r] 为中心的最长字符串
     */
    private String palindrome(String s, int l, int r) {
        // 防止索引越界
        int length = s.length();
        while (l >= 0 && r < length
                && s.charAt(l) == s.charAt(r)) {
            // 双指针展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        // 如果满足回文条件，会进入到上面的 while 循环中，l 和 r 都做过调整
        // 如果不满足回文条件，l + 1 = r，返回空字符串
        return s.substring(l + 1, r);
    }
}
