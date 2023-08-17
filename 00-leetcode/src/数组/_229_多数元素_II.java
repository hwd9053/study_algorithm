package 数组;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * https://leetcode.cn/problems/majority-element-ii/
 */
public class _229_多数元素_II {
    public List<Integer> majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int targetCnt = nums.length / 3;
        List<Integer> ans = new ArrayList<>();

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > targetCnt) {
                ans.add(entry.getKey());
            }
        }

        return ans;
    }

    // https://leetcode.cn/problems/majority-element-ii/solution/169ti-sheng-ji-ban-xiang-jie-zhu-xing-jie-shi-tong/
    // 摩尔投票
    public List<Integer> majorityElement2(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if (nums.length == 1) {
            ans.add(nums[0]);
            return ans;
        }
        int candiA = 0, candiB = 0;
        int cntA = 0, cntB = 0;
        for (int num : nums) {
            if (num == candiA) {
                cntA++;
            } else if (num == candiB) {
                cntB++;
            } else if (cntA == 0) {
                candiA = num;
                cntA = 1;
            } else if (cntB == 0) {
                candiB = num;
                cntB = 1;
            } else {
                cntA--;
                cntB--;
            }
        }

        cntA = cntB = 0;
        for (int num : nums) {
            if (num == candiA) {
                cntA++;
            } else if (num == candiB) {
                cntB++;
            }
        }

        if (cntA > nums.length / 3) {
            ans.add(candiA);
        }
        if (cntB > nums.length / 3) {
            ans.add(candiB);
        }

        return ans;
    }
}
