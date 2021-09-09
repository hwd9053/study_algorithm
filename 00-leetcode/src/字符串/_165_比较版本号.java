package 字符串;

/**
 * https://leetcode-cn.com/problems/compare-version-numbers/
 */
public class _165_比较版本号 {
    public int compareVersion(String version1, String version2) {
        char[] cs1 = version1.toCharArray();
        char[] cs2 = version2.toCharArray();
        int i1 = 0, i2 = 0;

        while (i1 < cs1.length || i2 < cs2.length) {
            int num1 = 0, num2 = 0;
            while (i1 < cs1.length && cs1[i1] != '.') {
                int val = cs1[i1++] - '0';
                if (num1 == 0 && val == 0) continue;
                num1 = num1 * 10 + val;
            }

            while (i2 < cs2.length && cs2[i2] != '.') {
                int val = cs2[i2++] - '0';
                if (num2 == 0 && val == 0) continue;
                num2 = num2 * 10 + val;
            }

            if (num1 > num2) {
                return 1;
            } else if (num1 < num2) {
                return -1;
            }
            i1++;
            i2++;
        }

        return 0;
    }

    public static void main(String[] args) {
        System.out.println(new _165_比较版本号().compareVersion("1.01", "1.001"));
    }
}
