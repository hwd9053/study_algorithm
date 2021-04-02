package 刷题用包;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 */
public class _17_电话号码的字母组合 {
    private char[][] lettersArray = {
            {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'},
            {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
    };
    public List<String> letterCombinations(String digits) {
        char[] cd = digits.toCharArray();
        List<String> res = new ArrayList<>();
        if (cd.length == 0) return res;
        char[] string = new char[cd.length];

        dfs(0, cd, res, string);

        return res;
    }

    private void dfs(int idx, char[] cd, List<String> res, char[] string) {
        if (idx == cd.length) {
            res.add(new String(string));
            return;
        }

        char digit = cd[idx];

        for (char letter : lettersArray[digit - '2']) {
            string[idx] = letter;
            dfs(idx + 1, cd, res, string);
        }
    }
}
