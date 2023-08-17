package 回溯;

import java.sql.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode.cn/problems/word-break-ii/
 */
public class _140_单词拆分_II {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (String word : wordDict) {
            set.add(word);
        }

        List<String> path = new ArrayList<>();
        char[] cs = s.toCharArray();
        dfs(cs, set, 0, ans, path);

        return ans;
    }

    private void dfs(char[] cs, Set<String> set, int idx, List<String> ans, List<String> path) {
        if (idx == cs.length) {
            StringBuilder sb = new StringBuilder();
            for (String s : path) {
                sb.append(s).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            ans.add(sb.toString());
            return;
        }

        for (int i = idx; i < cs.length; i++) {
            String str = new String(cs, idx, i - idx + 1);
            if (set.contains(str)) {
                path.add(str);
                dfs(cs, set, i + 1, ans, path);
                path.remove(path.size() - 1);
            }
        }
    }
}
