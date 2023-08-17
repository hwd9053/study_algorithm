package 字符串;

/**
 * https://leetcode-cn.com/problems/count-and-say/
 */
public class _38_外观数列 {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String ans = "1";
        for (int i = 2; i <= n; i++) {
            char[] cs = ans.toCharArray();
            int idx = 0;
            StringBuilder sb = new StringBuilder();

            while (idx < cs.length) {
                int cnt = 1;
                while (idx + 1 < cs.length && cs[idx + 1] == cs[idx]) {
                    cnt++;
                    idx++;
                }

                sb.append(cnt);
                sb.append(cs[idx]);

                idx++;
            }

            ans = sb.toString();
        }

        return ans;
    }
}
