package 图;

import java.util.*;

/**
 * https://leetcode-cn.com/problems/word-ladder/
 * https://leetcode-cn.com/problems/word-ladder/solution/bfsjie-jue-yi-quan-yi-quan-wang-wai-kuo-san-by-sdw/
 */
public class _127_单词接龙 {
    // BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictSet = new HashSet<>(wordList);
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int minLen = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();
                // 这里遍历每一个节点的单词，然后修改其中一个字符，让他成为一个新的单词，
                // 并查看这个新的单词在字典中是否存在，如果存在并且没有被访问过，就加入到队列中
                for (int j = 0; j < word.length(); j++) {
                    char[] cs = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (cs[j] == c) continue;
                        cs[j] = c;
                        String newWord = new String(cs);
                        if (dictSet.contains(newWord) && visited.add(newWord)) {
                            if (newWord.equals(endWord)) {
                                return minLen + 1;
                            }
                            queue.offer(newWord);
                        }
                    }
                }
            }
            minLen++;
        }
        return 0;
    }

    // BFS 舍去一个set
    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> dictSet = new HashSet<>(wordList);

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int minLen = 1;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                String word = queue.poll();
                // 这里遍历每一个节点的单词，然后修改其中一个字符，让他成为一个新的单词，
                // 并查看这个新的单词在字典中是否存在，如果存在并且没有被访问过，就加入到队列中
                for (int j = 0; j < word.length(); j++) {
                    char[] cs = word.toCharArray();
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (cs[j] == c) continue;
                        cs[j] = c;
                        String newWord = new String(cs);
                        if (dictSet.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return minLen + 1;
                            }
                            queue.offer(newWord);
                            dictSet.remove(newWord);
                        }
                    }
                }
            }
            minLen++;
        }
        return 0;
    }

    public static void main(String[] args) {
        _127_单词接龙 test = new _127_单词接龙();
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");
        System.out.println(test.ladderLength("hit", "cog", list));
    }
}
