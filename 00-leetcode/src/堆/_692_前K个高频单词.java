package 堆;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/top-k-frequent-words/
 */
public class _692_前K个高频单词 {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            Integer count = counts.getOrDefault(word, 0);
            counts.put(word, ++count);
        }

        PriorityQueue<Map.Entry<String, Integer>> queue = new PriorityQueue<>(
                (Map.Entry<String, Integer> e1, Map.Entry<String, Integer> e2) -> {
                    if (e1.getValue().equals(e2.getValue())) {
                        // 注意，按照字母排序是倒序。为啥，自己模拟下就知道了
                        return e2.getKey().compareTo(e1.getKey());
                    } else {
                        return e1.getValue() - e2.getValue();
                    }
                });

        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (queue.size() < k) {
                queue.offer(entry);
            } else {
                Integer top = queue.peek().getValue();
                Integer value = entry.getValue();
                if (value > top) {
                    queue.poll();
                    queue.offer(entry);
                } else if (value.equals(top)) {
                    if (entry.getKey().compareTo(queue.peek().getKey()) < 0) {
                        queue.poll();
                        queue.offer(entry);
                    }
                }
            }
        }

        List<String> ans = new LinkedList<>();
        while (!queue.isEmpty()) {
            ans.add(0, queue.poll().getKey());
        }

        return ans;
    }
}
