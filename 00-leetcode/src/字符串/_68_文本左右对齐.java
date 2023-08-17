package 字符串;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/text-justification/
 */
public class _68_文本左右对齐 {
    // 可以参考下下面这个解答，写的比较好。
    // 自己写的这个太丑
    // https://leetcode-cn.com/problems/text-justification/solution/text-justification-by-ikaruga/
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int cur = 0;

        while (cur < words.length) {
            int count = count(words, cur, maxWidth);
            int nextCur = cur + count;
            System.out.println(nextCur);
            // 最后一行左对齐
            if (nextCur == words.length) {
                StringBuilder sb = new StringBuilder();
                int len = 0;
                for (int i = cur; i < nextCur; i++) {
                    sb.append(words[i]);
                    len = sb.length();
                    if (len < maxWidth) {
                        sb.append(" ");
                        len++;
                    }
                }
                len = maxWidth - len;
                while (len > 0) {
                    sb.append(" ");
                    len--;
                }
                ans.add(sb.toString());
                break;
            } else {
                // 最后一行以外
                String str = stringJoint(words, cur, count, maxWidth);
                ans.add(str);
                cur = nextCur;
            }
        }

        return ans;
    }

    // 计算当前行能放几个单词
    private int count(String[] words, int cur, int maxWidth) {
        int count = 1;
        int remain = maxWidth - words[cur].length();
        for (int i = cur + 1; i < words.length && (words[i].length() + 1) <= remain; i++) {
            count++;
            remain -= words[i].length() + 1;
        }

        return count;
    }

    // 从words的start位置开始，拼接count个字符串
    private String stringJoint(String[] words, int start, int count, int maxWidth) {
        if (count == 1) {
            return spacePadding(words[start], maxWidth);
        }

        // 剩余多少个空格位
        int spaceCount = maxWidth;
        // [start, end)
        int end = start + count;
        for (int i = start; i < end; i++) {
            spaceCount -= words[i].length();
        }

        // 每个单词前面要补多少空格
        int[] spaces = new int[count];
        int spaceAvg = spaceCount / (count - 1);

        // 注意，第一个单词前面不要加空格
        for (int i = 1; i < spaces.length; i++) {
            spaces[i] = spaceAvg;
        }

        // 还多的空格，依次加到左边的位置
        int spaceExtra = spaceCount % (count - 1);
        for (int i = 1; i <= spaceExtra; i++) {
            spaces[i]++;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(words[start]);

        for (int i = 1; i < count; i++) {
            while (spaces[i] > 0) {
                sb.append(" ");
                spaces[i]--;
            }
            sb.append(words[start + i]);
        }

        return sb.toString();
    }

    // 只有一个单词时的左对齐
    private String spacePadding(String word, int maxWidth) {
        int remain = maxWidth - word.length();
        StringBuilder sb = new StringBuilder(word);
        while (remain > 0) {
            sb.append(' ');
            remain--;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String[] strs = {"This", "is", "an", "example", "of", "text", "justification."};
        new _68_文本左右对齐().fullJustify(strs, 16);
    }

}
