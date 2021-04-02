package 刷题用包;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/permutations/
 */
public class _46_全排列 {
    public List<List<Integer>> permute(int[] nums) {
        if (nums == null) return null;
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) return res;

        boolean[] used = new boolean[nums.length];
        List<Integer> resList = new ArrayList<>();

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
            resList.add(nums[i]);
            used[i] = true;
            dfs(idx + 1, nums, used, resList, res);
            used[i] = false;
            resList.remove(resList.size() - 1);
        }
    }
}
