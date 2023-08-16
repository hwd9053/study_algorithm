package 数组;

import java.util.HashMap;
import java.util.Map;

public class _2475_数组中不等三元组的数目 {
    public int unequalTriplets(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int n = nums.length, ans = 0, l = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int cnt = entry.getValue();
            int r = n - l - cnt;
            ans += l * r * cnt;
            l += cnt;
        }

        return ans;
    }
}
