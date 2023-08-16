package 前缀和;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.cn/problems/count-vowel-strings-in-ranges/description/
 */
public class _2559_统计范围内的元音字符串数 {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] prefixSums = new int[words.length + 1];
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('i');
        set.add('u');
        set.add('e');
        set.add('o');
        for (int i = 0; i < words.length; i++) {
            if (set.contains(words[i].charAt(0)) && set.contains(words[i].charAt(words[i].length() - 1))) {
                prefixSums[i + 1] = prefixSums[i] + 1;
            } else {
                prefixSums[i + 1] = prefixSums[i];
            }
        }

        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            res[i] = prefixSums[queries[i][1] + 1] - prefixSums[queries[i][0]];
        }

        return res;
    }
}
