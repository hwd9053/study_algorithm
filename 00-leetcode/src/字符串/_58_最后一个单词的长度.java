package 字符串;

/**
 * https://leetcode-cn.com/problems/length-of-last-word/
 */
public class _58_最后一个单词的长度 {
    // 正向
    public int lengthOfLastWord(String s) {
        char[] cs = s.toCharArray();
        int begin = 0, end = 0;
        boolean preSpace = true;

        for (int i = 0; i < cs.length; i++) {
            if (cs[i] == ' ') {
                if (!preSpace) {
                    end = i - 1;
                }
                preSpace = true;
            } else {
                if (preSpace) {
                    begin = i;
                    preSpace = false;
                }
            }
        }

        if (!preSpace) {
            end = cs.length - 1;
        }

        return end - begin + 1;
    }

    // 反向
    public int lengthOfLastWord2(String s) {
        char[] cs = s.toCharArray();
        int end = cs.length - 1;

        while (cs[end] == ' ') {
            end--;
        }

        int begin = end;
        while (begin >= 0 && cs[begin] != ' ') {
            begin--;
        }

        return end - begin;
    }
}
