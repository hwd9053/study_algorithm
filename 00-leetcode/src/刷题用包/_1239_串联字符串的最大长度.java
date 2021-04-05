package 刷题用包;

import java.util.List;

public class _1239_串联字符串的最大长度 {
    int maxLen = 0;
    public int maxLength(List<String> arr) {
        dfs(arr, 0, 0, 0);
        return maxLen;
    }

    private void dfs(List<String> arr, int idx, int bitmask, int len) {
        if (idx == arr.size()) {
            maxLen = Math.max(len, maxLen);
            return;
        }
        String str = arr.get(idx);
        int bit = isUnique(str, bitmask);
        if (bit != -1) dfs(arr, idx + 1, bit, len + str.length());
        dfs(arr, idx + 1, bitmask, len);
    }

    private int isUnique(String str, int bitmask) {
        for (char c : str.toCharArray()) {
            if ((bitmask & (1 << (c - 'a'))) != 0) {
                return -1;
            }
            bitmask |= (1 << (c - 'a'));
        }
        return bitmask;
    }
}
