package 字符串;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting/
 */
public class _524_通过删除字母匹配到字典里最长单词 {
    // 双指针(暴力)
    public String findLongestWord(String s, List<String> dictionary) {
        char[] cs = s.toCharArray();
        int i1 = 0, i2 = 0, maxLen = -1;
        String ans = "";
        for (String str : dictionary) {
            char[] dic = str.toCharArray();
            int len = 0;
            i1 = 0;
            i2 = 0;

            while (i1 < cs.length && i2 < dic.length) {
                if (cs[i1] == dic[i2]) {
                    i1++;
                    i2++;
                    len++;
                } else {
                    i1++;
                }
            }

            if (i2 == dic.length) {
                if (maxLen < len) {
                    ans = str;
                    maxLen = len;
                } else if (maxLen == len && (str.compareTo(ans) < 0)) {
                    ans = str;
                }
            }
        }
        return ans;
    }

    // 先对长度降序排序，再找
    public String findLongestWord2(String s, List<String> dictionary) {
        Collections.sort(dictionary, (o1, o2) -> {
            // 长度相等时，按照字典序
            if (o1.length() == o2.length()) {
                return o1.compareTo(o2);
            }
            // 按照长度降序
            return o2.length() - o1.length();
        });

        char[] cs = s.toCharArray();

        for (String word : dictionary) {
            char[] wordCs = word.toCharArray();
            int i1 = 0, i2 = 0;
            while (i1 < cs.length && i2 < wordCs.length) {
                if (cs[i1] == wordCs[i2]) {
                    i1++;
                    i2++;
                } else {
                    i1++;
                }
            }
            if (i2 == wordCs.length) return word;
        }

        return "";
    }

}
