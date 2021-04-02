package 刷题用包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations-ii/
 */
public class _47_全排列_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        boolean[] used = new boolean[nums.length];
        List<Integer> resList = new ArrayList<>();
        Arrays.sort(nums);

        dfs(0, nums, used, resList, res);

        return res;
    }

    private void dfs(int idx, int[] nums, boolean[] used, List<Integer> resList, List<List<Integer>> res) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(resList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
            resList.add(nums[i]);
            used[i] = true;
            dfs(idx + 1, nums, used, resList, res);
            used[i] = false;
            resList.remove(resList.size() - 1);
        }
    }
}
