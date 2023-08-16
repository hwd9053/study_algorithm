package 字符串;

/**
 * https://leetcode.cn/problems/add-strings/description/
 */
public class _415_字符串相加 {
    public String addStrings(String num1, String num2) {
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();

        int i1 = cs1.length - 1, i2 = cs2.length - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i1 >= 0 || i2 >= 0) {
            int val1 = 0, val2 = 0;
            if (i1 >= 0) {
                val1 = cs1[i1--] - '0';
            }
            if (i2 >= 0) {
                val2 = cs2[i2--] - '0';
            }
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            sb.append(sum % 10);
        }

        if (carry > 0) {
            sb.append(carry);
        }

        return sb.reverse().toString();
    }
}
