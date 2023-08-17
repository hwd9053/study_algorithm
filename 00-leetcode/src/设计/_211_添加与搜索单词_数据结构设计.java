package 设计;

/**
 * https://leetcode-cn.com/problems/design-add-and-search-words-data-structure/
 */
public class _211_添加与搜索单词_数据结构设计 {
    class WordDictionary {
        Node root;

        public WordDictionary() {
            root = new Node();
        }

        public void addWord(String word) {
            Node node = root;
            char[] cs = word.toCharArray();
            for (char c : cs) {
                int idx = c - 'a';
                if (node.links[idx] == null) {
                    node.links[idx] = new Node();
                }
                node = node.links[idx];
            }

            node.word = true;
        }

        public boolean search(String word) {
            char[] cs = word.toCharArray();
            return search(cs, 0, root);
        }

        private boolean search(char[] cs, int start, Node node) {
            if (start == cs.length) return node.word;

            if (cs[start] == '.') {
                for (Node link : node.links) {
                    if (link != null && search(cs, start + 1, link)) {
                        return true;
                    }
                }
            } else {
                node = node.links[cs[start] - 'a'];
                if (node != null && search(cs, start + 1, node)) {
                    return true;
                }
            }

            return false;
        }

    }

    private static class Node {
        Node[] links;
        boolean word;

        public Node() {
            links = new Node[26];
        }
    }
}
