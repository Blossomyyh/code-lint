package dfs;

import java.util.ArrayList;

public class WordSearch {
//    public static boolean exist(char[][] board, String word) {
//        //do not need to construct a trie for searched words
//        boolean res = false;
//        for(int i = 0;i<board.length; i++){
//            for(int j = 0;j<board[0].length;j++){
//                if(board[i][j] == word.charAt(0)){
//                    res= dfs(i,j, board,word, 1);
//                }
//            }
//        }
//        return res;
//    }
//
//    public static boolean dfs(int i, int j, char[][] board, String word, int n){
//        boolean dfsres = false;
//        board[i][j] = 0;
//        if(n==word.length()) return true;
//        int[] ix = {0,1,-1,0};
//        int[] iy = {1,0,0,-1};
//        for(int m = 0;m<4;m++){
//            if(i+ix[m] >=0 && i+ix[m] <board.length && j+iy[m]>=0 && j+iy[m]<board[0].length && board[i+ix[m]][j+iy[m]]==word.charAt(n)){
//
//                dfsres = dfs(i+ix[m], j+iy[m], board, word, n+1);
//
//
//            }
//        }
//        return dfsres;
//    }
//    /**
//     * paa 100
//     * @param
//     */
//    public static boolean existgood(char[][] board, String word) {
//        char[] charedWord = word.toCharArray();
//        for (int i = 0; i < board.length; i++) {
//            for (int j = 0; j < board[i].length; j++) {
//                if (hasPath(i, j, board, 0, charedWord)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    private static boolean hasPath(int i, int j, char[][] board, int curr, char[] word) {
//        if (isNotAMatch(i, j, board, curr, word)) {
//            return false;
//        }
//
//        if (curr == word.length - 1) {
//            board[i][j] = 0;
//            return true;
//        }
//
//        char originalChar = board[i][j];
//        board[i][j] = 0;
//
//        boolean isMatch = hasPath(i + 1, j, board, curr + 1, word) ||
//                hasPath(i, j + 1, board, curr + 1, word) ||
//                hasPath(i - 1, j, board, curr + 1, word) ||
//                hasPath(i, j - 1, board, curr + 1, word) ;
//
//        //board[i][j] = originalChar;
//
//        return isMatch;
//    }
//
//    private static boolean isNotAMatch(int i, int j, char[][] board, int curr, char[] word) {
//        return (i < 0) || (i >= board.length)    ||
//                (j < 0) || (j >= board[i].length) ||
//                (board[i][j] != word[curr]);
//    }

    public static void findWord(String word, String[][] grid) {
        // Your output here. Prints to standard output.
        for(int i =0;i<grid.length; i++){
            for(int j = 0;j<grid[0].length; j++){
                ArrayList<String> s = new ArrayList<String>();
                if(dfs(i,j,grid,word, 0, s)){
                    //print 0 in board
                    for(String m: s){
                        System.out.println(m);
                    }
                    return;
                }
            }
        }
        System.out.println("None");
    }

    public static boolean dfs(int i, int j, String[][] grid, String word,int n, ArrayList<String> s){
        if(notMatch(i,j,grid,word, n)){
            return false;
        }
        s.add(i+" "+ j);
        if(n == word.length()-1){
            return true;
        }
        String tem = grid[i][j];
        grid[i][j] = "0";
        boolean res = dfs(i+1,j,grid,word,n+1,s) ||dfs(i,j+1,grid, word,n+1,s);
        grid[i][j] = tem;
        return res;
    }

    public static boolean notMatch(int i, int j, String[][] grid, String word, int n){
        return  (i>=grid.length)||(i<0)||(j>=grid[0].length)||(j<0)||(grid[i][j].charAt(0)!=word.charAt(n));
    }


    public static void main(String arg[]){
//        char[][] board = {{'a','a'}};

        //String[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "ABCCED";
        //findWord(board, word);
        //System.out.print(board);
    }
}
