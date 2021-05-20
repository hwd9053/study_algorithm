package 堆;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-elements/
 */
public class _347_前K个高频元素 {
    // 笨办法，统计次数，然后排序，取前k个元素
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }

        Map.Entry<Integer, Integer>[] entries = new Map.Entry[map.size()];
        map.entrySet().toArray(entries);

        Arrays.sort(entries, (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> {
            return e2.getValue() - e1.getValue();
        });

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = entries[i].getKey();
        }

        return ans;
    }

    // 用堆来优化
    public int[] topKFrequent2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }

        // 利用小顶堆来解决TopK问题
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(
                (Map.Entry<Integer, Integer> e1, Map.Entry<Integer, Integer> e2) -> {
            return e1.getValue() - e2.getValue();
        });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else {
                if (entry.getValue() > queue.peek().getValue()) {
                    queue.poll();
                    queue.offer(entry);
                }
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll().getKey();
        }

        return ans;
    }

    // 再优化，优先队列里面不去放entry直接放key了
    public int[] topKFrequent3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            map.put(num, ++count);
        }

        // 利用小顶堆来解决TopK问题
        PriorityQueue<Integer> queue = new PriorityQueue<>(
                (Integer i1, Integer i2) -> {
                    return map.get(i1) - map.get(i2);
                });

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry.getKey());
            } else {
                if (entry.getValue() > map.get(queue.peek())) {
                    queue.poll();
                    queue.offer(entry.getKey());
                }
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = queue.poll();
        }

        return ans;
    }
}
