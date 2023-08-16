package 前缀和;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/can-make-palindrome-from-substring/description/
 * https://leetcode.cn/problems/can-make-palindrome-from-substring/solutions/2309725/yi-bu-bu-you-hua-cong-qian-zhui-he-dao-q-yh5p/
 */
public class _1177_构建回文串检测 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        char[] cs = s.toCharArray();
        int[][] cnt = new int[cs.length + 1][26];
        // 统计26个小写字母的前缀和
        for (int i = 1; i <= cs.length; i++) {
            cnt[i] = cnt[i - 1].clone();
            cnt[i][cs[i - 1] - 'a'] = cnt[i - 1][cs[i - 1] - 'a'] + 1;
        }

        List<Boolean> ans = new ArrayList<>();

        for (int[] query : queries) {
            int l = query[0], r = query[1], k = query[2], m = 0;
            for (int i = 0; i < 26; i++) {
                m += (cnt[r + 1][i] - cnt[l][i]) % 2; // 奇数+1, 偶数+0。统计奇数个数
            }

            ans.add((m / 2) <= k); // 奇数个数/2 <= k, 即满足
        }

        return ans;
    }
}
