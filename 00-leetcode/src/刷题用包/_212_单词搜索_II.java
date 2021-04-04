package 刷题用包;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 前缀树节点
class TrieNode {
    String word;
    Map<Character, TrieNode> links;
    public TrieNode() {
        links = new HashMap<>();
    }
}
/**
 * https://leetcode-cn.com/problems/word-search-ii/
 */
public class _212_单词搜索_II {

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = new TrieNode();
        // 将words加入前缀树
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (!node.links.containsKey(c)) {
                    node.links.put(c, new TrieNode());
                }
                node = node.links.get(c);
            }
            node.word = word;
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.links.containsKey(board[i][j])) {
                    dfs(root, i, j, ans, board);
                }
            }
        }
        return ans;
    }

    private void dfs(TrieNode parent, int i, int j, List<String> ans, char[][] board) {
        char letter = board[i][j];
        TrieNode node = parent.links.get(letter);
        if (node.word != null) {
            ans.add(node.word);
            node.word = null;
        }

        board[i][j] = '#';
        // 向上进行dfs
        if (inArea(board, i - 1, j) && node.links.containsKey(board[i - 1][j])) {
            dfs(node, i - 1, j, ans, board);
        }
        // 向下进行dfs
        if (inArea(board, i + 1, j) && node.links.containsKey(board[i + 1][j])) {
            dfs(node, i + 1, j, ans, board);
        }
        // 向左进行dfs
        if (inArea(board, i, j - 1) && node.links.containsKey(board[i][j - 1])) {
            dfs(node, i, j - 1, ans, board);
        }
        // 向右进行dfs
        if (inArea(board, i, j + 1) && node.links.containsKey(board[i][j + 1])) {
            dfs(node, i, j + 1, ans, board);
        }
        board[i][j] = letter;

        // 剪掉叶子节点
        if (node.links.isEmpty()) {
            parent.links.remove(letter);
        }

    }

    private boolean inArea(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
    }
}
