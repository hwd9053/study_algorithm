package 二分;

import java.util.Arrays;

/**
 * https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/description/
 * https://leetcode.cn/problems/maximum-tastiness-of-candy-basket/solutions/2292300/javapython3tan-xin-pai-xu-er-fen-cha-zha-fxvv/
 */
public class _2517_礼盒的最大甜蜜度 {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        // 最小甜蜜度为0，最大甜蜜度等于最大价格-最小价格
        // 在此区间寻找符合条件的最大甜蜜度
        int li = 0, ri = price[price.length - 1] - price[0];
        int res = 0;
        // 二分
        while (li <= ri) {
            int mid = li + (ri - li) / 2;
            int prev = price[0];
            int cnt = 1;
            // 判断当前甜蜜度是否符合
            for (int i = 1; i < price.length; i++) {
                if (price[i] - prev >= mid) {
                    prev = price[i];
                    cnt++;
                }
            }

            if (cnt >= k) {
                res = mid;
                li = mid + 1;
            } else {
                ri = mid - 1;
            }
        }

        return res;
    }
}
