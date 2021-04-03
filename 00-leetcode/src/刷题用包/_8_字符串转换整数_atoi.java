package 刷题用包;

/**
 * https://leetcode-cn.com/problems/string-to-integer-atoi/
 */
public class _8_字符串转换整数_atoi {
    public int myAtoi(String s) {
        char[] cs = s.toCharArray();

        int idx = 0;
        while (idx < cs.length && cs[idx] == ' ') {
            idx++;
        }
        if (idx == cs.length) return 0;

        boolean neg = false;
        if (cs[idx] == '-') {
            neg = true;
            idx++;
        } else if (cs[idx] == '+') {
            idx++;
        }

        int res = 0;
        int last = res;
        while (idx < cs.length && Character.isDigit(cs[idx])) {
            last = res;
            res = res * 10 + (cs[idx] - '0');
            if ((res / 10) != last) {
                if (neg) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }

            idx++;
        }
        return neg ? - res : res;
    }

}
