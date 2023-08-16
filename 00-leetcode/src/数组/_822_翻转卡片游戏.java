package 数组;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/card-flipping-game/description/
 * https://leetcode.cn/problems/card-flipping-game/solutions/1331234/js-bian-li-by-marswiz-vou2/
 */
public class _822_翻转卡片游戏 {
    public int flipgame(int[] fronts, int[] backs) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < fronts.length; i++) {
            if (fronts[i] == backs[i]) set.add(fronts[i]);
        }

        int res = Integer.MAX_VALUE;

        for (int front : fronts) {
            if (front < res && !set.contains(front)) res = front;
        }

        for (int back : backs) {
            if (back < res && !set.contains(back)) res = back;
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}
