package sword._12;

class Solution {
    /**
     * 记录某个点是否访问过
     */
    boolean[][] table;
    char[][] board;
    int rowNum;
    int columnNum;

    public boolean exist(char[][] board, String word) {
        // 边界条件
        if (board.length == 0 || board[0].length == 0) return false;

        // 初始化
        this.rowNum = board.length;
        this.columnNum = board[0].length;
        this.table = new boolean[rowNum][columnNum];

        this.board = board;
        char[] words = new char[word.length()];
        for (int i = 0; i < word.length(); ++i) {
            words[i] = word.charAt(i);
        }

        // 递归开始
        for (int i = 0; i < rowNum; ++i) {
            for (int j = 0; j < columnNum; ++j) {
                if (board[i][j] == words[0]) {
                    table[i][j] = true;
                    boolean res = helper(words, 1, i, j);
                    if (res == true) return true;
                    else table[i][j] = false;
                }
            }
        }
        return false;
    }

    /**
     *
     * @param words 目标words序列
     * @param index 当前应该访问的字母位置。使用int类型，使用值拷贝，在递归过程中可以自动进行变化。
     * @param row 起始点行号
     * @param column 起始点列号
     * @return 从当前点开始是否成功抵达words末尾？
     */
    public boolean helper(char[] words, int index, int row, int column) {
        if (words.length == 0) return true;
        if (index == words.length) return true;

        // 上
        if (row - 1 >= 0 && table[row - 1][column] == false && board[row - 1][column] == words[index]) {
            table[row - 1][column] = true;
            boolean res = helper(words, index + 1, row - 1, column);
            if (res == false) {
                table[row - 1][column] = false;
            } else {
                return true;
            }
        }
        // 下
        if (row + 1 < rowNum && table[row + 1][column] == false && board[row + 1][column] == words[index]) {
            table[row + 1][column] = true;
            boolean res = helper(words, index + 1, row + 1, column);
            if (res == false) {
                table[row + 1][column] = false;
            } else {
                return true;
            }
        }
        // 左
        if (column - 1 >= 0 && table[row][column - 1] == false && board[row][column - 1] == words[index]) {
            table[row][column - 1] = true;
            boolean res = helper(words, index + 1, row, column - 1);
            if (res == false) {
                table[row][column - 1] = false;
            } else {
                return true;
            }
        }
        // 右
        if (column + 1 < columnNum && table[row][column + 1] == false && board[row][column + 1] == words[index]) {
            table[row][column + 1] = true;
            boolean res = helper(words, index + 1, row, column + 1);
            if (res == false) {
                table[row][column + 1] = false;
            } else {
                return true;
            }
        }

        return false;

    }


}

