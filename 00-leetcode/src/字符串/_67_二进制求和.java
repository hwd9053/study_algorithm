package 字符串;

/**
 * https://leetcode.cn/problems/add-binary/?company_slug=microsoft
 */
public class _67_二进制求和 {
    public String addBinary(String a, String b) {
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        int len1 = a.length(), len2 = b.length();
        int idx1 = 0, idx2 = 0;

        while (idx1 < len1 || idx2 < len2) {
            int val1 = 0, val2 = 0;
            if (idx1 < len1) {
                val1 = a.charAt(len1 - idx1 - 1) - '0';
                idx1++;
            }
            if (idx2 < len2) {
                val2 = b.charAt(len2 - idx2 - 1) - '0';
                idx2++;
            }
            int sum = val1 + val2 + carry;
            sb.append(sum % 2);
            carry = sum / 2;
        }

        if (carry != 0) sb.append(carry);

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(new _67_二进制求和().addBinary("1010", "1011"));
    }
}
