package Trie;

public class MTrieNode {
    //R links to node children
    private MTrieNode[] links;
    private final int R = 26; //only 26 characters
    private boolean isEnd;

    public MTrieNode(){
        links = new MTrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] !=null;
    }
    public MTrieNode get(char ch){
        return links[ch - 'a'];
    }
    public void put(MTrieNode node, char ch){
        links[ch - 'a'] = node;
    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }

}
