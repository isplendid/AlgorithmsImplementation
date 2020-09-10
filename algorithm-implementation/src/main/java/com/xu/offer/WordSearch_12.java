package com.xu.offer;

/**
 * Created by sop on 2020/09/2020/9/8 11:39
 * <p>
 * [['a','b','c','e'],
 * ['s','f','c','s'],
 * ['a','d','e','e']]
 * <p>
 * 'abfb' : false
 * 'bfce' ：false
 * 单词搜索
 *
 * @Description:
 */
public class WordSearch_12 {


    //private boolean[][] visited;

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        char[] wds = word.toCharArray();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, i, j, wds, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int r, int c, char[] wds, int i) {
        if (r >= board.length || r < 0 || c < 0 || c >= board[0].length || board[r][c] != wds[i]) {
            return false;
        }
        if (i == wds.length - 1) return true;
        char temp = board[r][c];
        board[r][c] = '/';
        //注意，这块需要短路操作，否则 超时
        boolean res = dfs(board, r - 1, c, wds, i + 1) || dfs(board, r + 1, c, wds, i + 1) ||
                dfs(board, r, c + 1, wds, i + 1) || dfs(board, r, c - 1, wds, i + 1);
        board[r][c] = temp;
        return res;
    }


    public boolean exist2(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        if (k == word.length - 1) return true;
        char tmp = board[i][j];
        board[i][j] = '/';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        board[i][j] = tmp;
        return res;
    }


    public static void main(String[] args) {
        char[][] arr = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";
//        char[][] arr = new char[][]{{'a', 'b'},{'c','d'}};
//        String word = "cdba";
        WordSearch_12 wd = new WordSearch_12();


        System.out.println(wd.exist(arr, word));
    }
}
