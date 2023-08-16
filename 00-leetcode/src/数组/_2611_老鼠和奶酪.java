package 数组;

import java.util.Arrays;

public class _2611_老鼠和奶酪 {
    // 贪心
    public int miceAndCheese(int[] reward1, int[] reward2, int k) {
        int n = reward1.length;
        Integer[] diff = new Integer[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            diff[i] = reward1[i] - reward2[i];
            res += reward2[i];
        }

        Arrays.sort(diff, (x, y) -> y - x);

        for (int i = 0; i < k; i++) {
            res += diff[i];
        }

        return res;
    }
}
