package 模拟;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/walking-robot-simulation/description/
 * https://leetcode.cn/problems/walking-robot-simulation/solutions/306901/tu-jie-mo-ni-xing-zou-ji-qi-ren-by-dekeshile/
 */
public class _874_模拟行走机器人 {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] dirX = {0,1,0,-1};
        int[] dirY = {1,0,-1,0};
        int curx = 0, cury = 0, dir = 0, res = 0;
        Set<String> obs = new HashSet<>();
        for (int[] obstacle : obstacles) {
            obs.add(obstacle[0] + " " + obstacle[1]);
        }

        for (int c : commands) {
            if (c == -1) dir = (dir + 1) % 4;
            else if (c == -2) dir = (dir + 3) % 4;
            else {
                while (c > 0 && !obs.contains((curx + dirX[dir]) + " " + (cury + dirY[dir]))) {
                    curx += dirX[dir];
                    cury += dirY[dir];
                    c--;
                    res = Math.max(res, curx * curx + cury * cury);
                }
            }
        }
        return res;
    }
}
