package com.wangguangwu.dp;

/**
 * 斐波那契数列：每个数字都是前两个数字的和
 *
 * @author wangguangwu
 */
public class Fib {

    public static void main(String[] args) {
        Fib fib = new Fib();
        System.out.println(fib.fib(10));
    }

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }
}
