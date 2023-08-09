package com.wangguangwu.bfs;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author wangguangwu
 */
public class OpenLock {

    public static void main(String[] args) {
        String[] deadends = new String[]{"8887","8889","8878","8898","8788","8988","7888","9888"};
        String target = "8888";
        OpenLock solution = new OpenLock();
        int i = solution.openLock(deadends, target);
        System.out.println(i);
    }

    public int openLock(String[] deadends, String target) {
        // 记录需要跳过的死亡密码
        Set<String> deadSet = Arrays.stream(deadends).collect(Collectors.toSet());
        // 记录已经穷举过的密码，防止走回头路
        HashSet<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        // 从起点开始启动 BFS
        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                // 判断是否到达终点
                // 如果当前状态在 deadSet 中，会跳过当前状态，也不会将其相邻状态添加到队列中
                if (deadSet.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                // 将一个节点的未遍历相邻节点加入队列
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    // 将 s[j] 向上拨动一次
    String plusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '9') {
            ch[j] = '0';
        } else {
            ch[j] += 1;
        }
        return new String(ch);
    }

    // 将 s[i] 向下拨动一次
    String minusOne(String s, int j) {
        char[] ch = s.toCharArray();
        if (ch[j] == '0') {
            ch[j] = '9';
        } else {
            ch[j] -= 1;
        }
        return new String(ch);
    }
}
