package 字符串;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/destination-city/
 */
public class _1436_旅行终点站 {
    public String destCity(List<List<String>> paths) {
        Set<String> set = new HashSet<>();
        for (List<String> path : paths) {
            set.add(path.get(0));
        }

        for (List<String> path : paths) {
            if (!set.contains(path.get(1))) return path.get(1);
        }

        return null;
    }

    
}
