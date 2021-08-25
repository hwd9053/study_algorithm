package 字符串;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
 */
public class _345_反转字符串中的元音字母 {

    public String reverseVowels(String s) {
        char[] cs = s.toCharArray();
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('A');
        set.add('e');
        set.add('E');
        set.add('i');
        set.add('I');
        set.add('o');
        set.add('O');
        set.add('u');
        set.add('U');

        int li = 0, ri = cs.length - 1;
        while (li < ri) {
            while (li < ri) {
                if (!set.contains(cs[li])) {
                    li++;
                } else {
                    break;
                }
            }
            while (li < ri) {
                if (!set.contains(cs[ri])) {
                    ri--;
                } else {
                    break;
                }
            }
            swap(cs, li, ri);
            li++;
            ri--;
        }

        return new String(cs);
    }

    private void swap(char[] cs, int li, int ri) {
        char temp = cs[li];
        cs[li] = cs[ri];
        cs[ri] = temp;
    }



    public String reverseVowels2(String s) {
        boolean[] hash = new boolean[128];
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};

        for (char c : vowels) {
            hash[c] = hash[Character.toUpperCase(c)] = true;
        }

        char[] cs = s.toCharArray();

        int li = 0, ri = cs.length - 1;

        while (li < ri) {
            // 只有当左右两边的字符都是元音时，才交换
            if (hash[cs[li]] && hash[cs[ri]]) {
                swap(cs, li++, ri--);
            } else {
                if (!hash[cs[li]]) li++;
                if (!hash[cs[ri]]) ri--;
            }
        }

        return new String(cs);
    }

}
