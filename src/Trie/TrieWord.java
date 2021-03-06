package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


class TrieNode {
    //map has different function like search contains....
    HashMap<Character, TrieNode> map ;
    //for we need to output the word, so instead of boolean we can easily use string
    String word = null;
    public TrieNode(){
        map =new HashMap<>();
    }
}

public class TrieWord {
    /* consists of a loop over each cell in the board and a recursive function call starting from the cell.
1.We build a Trie.Trie out of the words in the dictionary, which would be used for the matching process later.

2.Starting from each cell, we start the backtracking exploration (i.e. backtracking(cell)), if there exists any word in the dictionary that starts with the letter in the cell.

3.During the recursive function call backtracking(cell), we explore the neighbor cells (i.e. neighborCell) around the current cell for the next recursive call backtracking(neighborCell). At each call, we check if the sequence of letters that we traverse so far matches any word in the dictionary, with the help of the Trie.Trie data structure that we built at the beginning.
*/
    private List<String> res = new ArrayList<>();

    public List<String> findWords(char[][] board, String[] words) {
        if(board.length==0 || words.length==0) return null;


        // todo: Step 1). Construct the Trie.Trie
        TrieNode root = new TrieNode();
        for(String word :words){
            TrieNode node = root;
            for (Character ch : word.toCharArray()){
                if(node.map.containsKey(ch)){
                    node = node.map.get(ch);
                }else{
                    node.map.put(ch, new TrieNode());
                }
            }
            node.word = word; //todo: store words in Trie.Trie
        }

//        //todo: step 2 backtracking starting for each cell in the board
        for (int j = 0; j<board.length;j++) {
            for (int i = 0; i < board[0].length; i++) {
                if (root.map.containsKey(board[i][j])) backtracking(i, j, board, root);
            }
        }


        return res;
    }

    private void backtracking(int row, int col,char[][] board, TrieNode parent) {
        Character letter = board[row][col];
        TrieNode currNode = parent.map.get(letter);

        // check if there is any match
        if (currNode.word != null) {
            res.add(currNode.word);
            currNode.word = null;
        }

        // mark the current letter before the EXPLORATION
        board[row][col] = '#';

        // explore neighbor cells in around-clock directions: up, right, down, left
        int[] rowOffset = {-1, 0, 1, 0};
        int[] colOffset = {0, 1, 0, -1};
        for (int i = 0; i < 4; ++i) {
            int newRow = row + rowOffset[i];
            int newCol = col + colOffset[i];
            if (newRow < 0 || newRow >= board.length || newCol < 0
                    || newCol >= board[0].length) {
                continue;
            }
            if (currNode.map.containsKey(board[newRow][newCol])) {
                backtracking(newRow, newCol, board,currNode);
            }
        }

        // End of EXPLORATION, restore the original letter in the board.
        board[row][col] = letter;

        // Optimization: incrementally remove the leaf nodes
        if (currNode.map.isEmpty()) {
            parent.map.remove(letter);
        }
    }

//    public void backTrack(int i, int j, char[][] board, TrieNode root){
//        for ()
//        if (root.map.containsKey(board[i][j])){
//            return backTrack();
//        }
//    }


}


