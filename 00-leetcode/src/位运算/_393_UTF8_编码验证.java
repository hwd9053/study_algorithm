package 位运算;

/**
 * https://leetcode-cn.com/problems/utf-8-validation/
 */
public class _393_UTF8_编码验证 {
    private static final int MASK1 = 1 << 7;
    private static final int MASK2 = (1 << 7) + (1 << 6);
    public boolean validUtf8(int[] data) {
        int i = 0;
        while (i < data.length) {
            int byteLen = getBytes(data[i]);
            // UTF-8编码的字节数必须为1~4字节
            if (byteLen <= 0 || byteLen > 4) return false;
            // 若数组剩下的字节不足，那么也为false
            if (i + byteLen > data.length) return false;
            for (int j = i + 1; j < i + byteLen; j++) {
                if ((data[j] & MASK2) != MASK1) return false;
            }
            i += byteLen;
        }
        return true;
    }

    // 获取改字符的字节数
    private int getBytes(int num) {
        // 第一位为0，字节数为1
        if ((num & MASK1) == 0) return 1;
        int len = 0;
        int mask = MASK1;
        // 统计先头1的个数
        while ((num & mask) != 0) {
            len++;
            if (len > 4) return -1;
            mask >>= 1;
        }
        return len == 1 ? -1 : len;
    }

    public static void main(String[] args) {
        int[] data = {235, 140, 4};
        new _393_UTF8_编码验证().validUtf8(data);
        System.out.print(Integer.toBinaryString(145));
    }
}
