package 字符串;

import java.util.HashMap;
import java.util.Map;

public class _205_同构字符串 {
    public boolean isIsomorphic(String s, String t) {
        char[] cs = s.toCharArray();
        char[] ct = t.toCharArray();

        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < cs.length; i++) {
            if ((map1.containsKey(cs[i]) && map1.get(cs[i]) != ct[i])) return false;
            if ((map2.containsKey(ct[i]) && map2.get(ct[i]) != cs[i])) return false;
            map1.put(cs[i], ct[i]);
            map2.put(ct[i], cs[i]);
        }
        return true;
    }
}
