package Trie;

public class Trie {
    //R links to node children
    //private Trie.Trie
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
//    public void insert(String word) {
//        TrieNode node = root;
//        for(int i = 0; i<word.length(); i++){
//            //A link does not exist.
//            if(!node.containsKey(word.charAt(i))){
//                node.put( new TrieNode(),word.charAt(i));
//            }
//            //A link exists.
//            node = node.get(word.charAt(i));
//        }
//        node.setEnd();
//        //O(m) time, O(m) space, m==length of key
//    }
//    //Each key is represented in the trie as a path from the root to the internal node or leaf. We start from the root with the first key character.
//
//
//    /** Returns if the word is in the trie. */
//
//    // search a prefix or whole key in trie and
//    // returns the node where search ends
//    public TrieNode searchPrefix(String word){
//        TrieNode node = root;
//        for (int i = 0; i < word.length(); i++) {
//            char cur = word.charAt(i);
//            if (node.containsKey(cur)) {
//                node = node.get(cur);
//            } else {
//                return null;
//            }
//        }
//        return node;
//    }
//
//    public boolean search(String word) {
//        TrieNode node = searchPrefix(word);
//        return node!=null && node.isEnd();
//    }

//    /** Returns if there is any word in the trie that starts with the given prefix. */
//    public boolean startsWith(String prefix) {
//        TrieNode node = searchPrefix(prefix);
//        return node!= null;
//    }

    //search/startsWith -- O(m) time, O(1) space
}
/**
 * Your Trie.Trie object will be instantiated and called as such:
 * Trie.Trie obj = new Trie.Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */