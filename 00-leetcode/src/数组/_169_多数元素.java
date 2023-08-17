package 数组;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/majority-element/
 */
public class _169_多数元素 {
    // 利用map统计出现次数。朴素想法
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        int ans = 0, maxCnt = 0;

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCnt) {
                maxCnt = entry.getValue();
                ans = entry.getKey();
            }
        }

        return ans;
    }

    // 投票法，利用众数数量大于n/2，最后留下的必然是众数
    public int majorityElement2(int[] nums) {
        int ans = nums[0];
        int cnt = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == ans) {
                cnt++;
            } else {
                cnt--;
                if (cnt == 0) {
                    ans = nums[i];
                    cnt = 1;
                }
            }
        }

        return ans;
    }
}
