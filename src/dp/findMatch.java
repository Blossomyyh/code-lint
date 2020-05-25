package dp;

public class findMatch {
    public static int firstOccurrence(String s, String x) {
        // Write your code here
        int lens = s.length();
        int lenx = x.length();
        // base cases
        if (x.equals(s) || x.equals("*")&&s.length()==1) return 0;
        if (x.isEmpty() || s.isEmpty()) return -1;

        int[][] dp = new int[lenx+1][lens+1];

        for(int i = 1;i<lenx+1;i++){
            for(int j = 1;j<lens+1;j++){
                //int max = Math.max(dp[i-1][j-1], Math.max(dp[i-1][j], dp[i][j-1]));
                int max= dp[i-1][j-1];
                if((s.charAt(j-1)==x.charAt(i-1))||x.charAt(i-1)=='*'){
                    dp[i][j] = max+1;
                    if(dp[i][j]==lenx){
                        return j-lenx;
                    }
                }else{
                    dp[i][j]= max;
                }
            }
        }
        return -1;

    }
    public static void main(String args[]){
        firstOccurrence("asaanthantjulia", "ant");
    }
}
