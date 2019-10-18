public class TrieNode {
    //R links to node children
    private TrieNode[] links;
    private final int R = 26; //only 26 characters
    private boolean isEnd;

    public TrieNode(){
        links = new TrieNode[R];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] !=null;
    }
    public TrieNode get(char ch){
        return links[ch - 'a'];
    }
    public void put(TrieNode node, char ch){
        links[ch - 'a'] = node;
    }
    public void setEnd(){
        isEnd = true;
    }
    public boolean isEnd(){
        return isEnd;
    }

}
