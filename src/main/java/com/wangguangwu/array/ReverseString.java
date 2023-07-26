package com.wangguangwu.array;

import java.util.Arrays;

/**
 * @author wangguangwu
 */
public class ReverseString {

    public static void main(String[] args) {
        char[] chars = "Hello".toCharArray();

        ReverseString solution = new ReverseString();
        solution.reverseString(chars);
        System.out.println(Arrays.toString(chars));
    }

    public void reverseString(char[] chars) {
        int left = 0;
        int right = chars.length - 1;
        char temp;
        while (left < right) {
            // 冒泡排序
            temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;
            left++;
            right--;
        }
    }
}
