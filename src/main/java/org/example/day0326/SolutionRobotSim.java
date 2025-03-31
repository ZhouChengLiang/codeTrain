package org.example.day0326;

import java.util.HashSet;
import java.util.Set;

/**
 * @author zhouchengliang
 * <p>
 * 模拟机器人行走
 * leetCode 874
 */
public class SolutionRobotSim {

    public int robotSim(int[] commands, int[][] obstacles) {
        Set<Long> set = new HashSet<>();
        for (int[] arr : obstacles) {
            set.add(calcHash(arr));
        }
        int x = 0, y = 0;
        int dir = 0;
        // 网格行走题目，技巧，方向数组
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        int ans = 0;
        for (int command : commands) {
            if (command == -1) {
                dir = (dir + 1) % 4;
            } else if (command == -2) {
                dir = (dir + 3) % 4;
            } else {
                for (int i = 0; i < command; i++) {
                    int nx = x + dx[dir];
                    int ny = y + dy[dir];
                    if (set.contains(calcHash(new int[]{nx, ny}))) {
                        break;
                    }
                    x = nx;
                    y = ny;
                    ans = Math.max(ans, x * x + y * y);
                }
            }


        }
        return 0;
    }

//    private String calcHash(int[] obstacles) {
//        return "".concat(String.valueOf(obstacles[0])).concat(",").concat(String.valueOf(obstacles[1]));
//    }

    private Long calcHash(int[] obstacles) {
        return (obstacles[0] + 30000) * 60001L + (obstacles[1] + 30000);
    }

}
