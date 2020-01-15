import java.util.ArrayList;
import java.util.List;

public class parenthesis {
    public static List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList();
        if(n==0){
            ans.add("");
            return ans;
        }else{
            backtrack(0,0,n,ans,"");
        }
        return ans;
    }


    public static void backtrack(int left, int right, int n, List<String> ans, String s ){
        if(s.length()==n*2){
            ans.add(s);
            return;
        }else{
            if(left<n){
                backtrack(left+1,right, n,ans, s+"(");
            }
            if(right<left){
                backtrack(left,right+1, n,ans, s+")");
            }
        }
    }
    public static void main(String args[]){
        generateParenthesis(2);
    }
}
