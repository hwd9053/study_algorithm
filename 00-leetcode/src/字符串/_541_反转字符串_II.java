package 字符串;

/**
 * https://leetcode-cn.com/problems/reverse-string-ii/
 */
public class _541_反转字符串_II {

    // 自己想的有点蠢
    // 实际按照这样做会比较好。。。
    // 反转每个下标从 2k 的倍数开始的，长度为 k 的子串。若该子串长度不足 k，则反转整个子串。
    public String reverseStr(String s, int k) {
        char[] cs = s.toCharArray();
        if (cs.length == 1) return s;

        boolean reverse = true;
        int li = 0, ri = k - 1;
        while (ri < cs.length) {
            if (reverse) {
                reverse(cs, li, ri);
            }
            li = ri + 1;
            ri = li + k - 1;
            reverse = !reverse;
        }

        if (reverse) {
            reverse(cs, li, cs.length - 1);
        }

        return new String(cs);
    }

    private void reverse(char[] cs, int li, int ri) {
        while (li < ri) {
            char temp = cs[li];
            cs[li] = cs[ri];
            cs[ri] = temp;
            li++;
            ri--;
        }
    }
}
