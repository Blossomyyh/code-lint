public class validparenthesis {

    /**
     * Let lo, hi respectively be the smallest and largest possible number of open left brackets after processing the current character in the string.

     If we encounter a left bracket (c == '('),
     then lo++, otherwise we could write a right bracket, so lo--.
     If we encounter what can be a left bracket (c != ')'), then hi++,
     otherwise we must write a right bracket, so hi--.
     If hi < 0, then the current prefix can't be made valid no matter what our choices are.
     Also, we can never have less than 0 open left brackets.
     At the end, we should check that we can have exactly 0 open left brackets.
     * @param s
     * @return
     */

    public boolean checkValidString(String s) {
        int low=0,high=0;
        for(int i=0;i<s.length();++i) {
            if(s.charAt(i)=='('){
                ++low;
                ++high;
            }
            else if(s.charAt(i) == '*') {
                --low;
                ++high;
            }
            else {
                --low;
                --high;
                if(high<0) break;
            }
            if(low<0) low=0;
        }
        return low==0;
    }


    /**
     * Let dp[i][j] be true if and only if the interval s[i], s[i+1], ..., s[j] can be made valid. Then dp[i][j] is true only if:

     s[i] is '*', and the interval s[i+1], s[i+2], ..., s[j] can be made valid;

     or, s[i] can be made to be '(', and there is some k in [i+1, j] such that s[k] can be made to be ')',
     plus the two intervals cut by s[k] (s[i+1: k] and s[k+1: j+1]) can be made valid;
     *
     * @param s
     * @return
     */
    public boolean checkdpValidString(String s) {
        int n = s.length();
        if (n == 0) return true;
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '*') dp[i][i] = true;
            if (i < n-1 &&
                    (s.charAt(i) == '(' || s.charAt(i) == '*') &&
                    (s.charAt(i+1) == ')' || s.charAt(i+1) == '*')) {
                dp[i][i+1] = true;
            }
        }

        for (int size = 2; size < n; size++) {
            for (int i = 0; i + size < n; i++) {
                if (s.charAt(i) == '*' && dp[i+1][i+size] == true) {
                    dp[i][i+size] = true;
                } else if (s.charAt(i) == '(' || s.charAt(i) == '*') {
                    for (int k = i+1; k <= i+size; k++) {
                        if ((s.charAt(k) == ')' || s.charAt(k) == '*') &&
                                (k == i+1 || dp[i+1][k-1]) &&
                                (k == i+size || dp[k+1][i+size])) {
                            dp[i][i+size] = true;
                        }
                    }
                }
            }
        }
        return dp[0][n-1];
    }
}
