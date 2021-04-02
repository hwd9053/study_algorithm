package 刷题用包;

public class _151_翻转字符串里的单词 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        char[] cs = s.toCharArray();

        boolean space = true;

        int cur = 0;
        for (int i = 0; i < cs.length; i++) {
            if (cs[i] != ' ') {
                cs[cur++] = cs[i];
                space = false;
            } else if (!space) {
                cs[cur++] = cs[i];
                space = true;
            }
        }

        int len = space ? cur - 1 : cur;

        reverse(cs, 0, len);

        int prevSpace = -1;
        for (int i = 0; i < len; i++) {
            if (cs[i] != ' ') continue;
            reverse(cs, prevSpace + 1, i);
            prevSpace = i;
        }

        reverse(cs, prevSpace + 1, len);

        return new String(cs, 0, len);
    }

    private void reverse(char[] cs, int start, int end) {
        end--;

        while (start < end) {
            char tmp = cs[start];
            cs[start] = cs[end];
            cs[end] = tmp;
            start++;
            end--;
        }
    }
}
