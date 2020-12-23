package 字符串;

import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/first-unique-character-in-a-string/
 */
public class _387_字符串中的第一个唯一字符 {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Integer count = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count = map.get(c);
            if (map.get(c) != null) {
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }

    public int firstUniqChar2(String s) {
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            Integer count = map.get(c);
            if (map.get(c) != null) {
                map.put(c, ++count);
            } else {
                map.put(c, 1);
            }
        }



        return -1;
    }
}
