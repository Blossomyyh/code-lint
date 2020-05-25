public class backspace {
    public boolean backspaceCompare(String S, String T) {
        int indexs = S.indexOf('#');
        int indext = T.indexOf('#');
        while (indexs != -1){
            S = indexs==0?S.substring(indexs + 1) : S.substring(0, indexs - 1) + S.substring(indexs+1);
            S.indexOf('#');
        }
        while (indext!=-1){
            S = indexs==0? S.substring(indexs+1) : T.substring(0,indext-1) +T.substring(indext+1);
            S.indexOf('#');

        }
        return T.compareTo(S)==0;
    }
}
