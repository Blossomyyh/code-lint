public class Palindrome {
    


    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private static int expandAroundCenter(String s, int left, int right){
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }

    /**
     * Time complexity :
     O(n
     2
     ). Since expanding a palindrome around its center could take
     O(n) time, the overall complexity isO(n2).

     Space complexity :s
     O(1).
     * @param s
     * @return
     *
     * first need to consider the border case!!!
     */
    public static String palindrome (String s){
        if(s=="") return "";
        if (s.length() == 1) return s;
        int start =0, len =0;
        for(int i = 1; i<s.length() -1; i++){
            int j = 1;
            // symmetric
            if(s.charAt(i)==s.charAt(i - j)){
                while (i+j-1 <s.length() && i - j>= 0 && s.charAt(i+j-1)==s.charAt(i-j)){
                    int m = 2*j;
                    if (len< m){
                        len = 2*j;
                        start = i-j;
                    }
                    j++;
                }
            }
            j = 0;
            if (s.charAt(i-j)==s.charAt(i+j)){
                while(i-j>=0 &&i+j<s.length() && s.charAt(i-j)==s.charAt(i+j)){
                    if (len< 2*j +1){
                        len = 2*j +1;
                        start = i-j;
                    }
                    j++;
                }

            }
        }

        return s.substring(start, start+len);
    }

    public static void main (String args[]){
        String m = longestPalindrome("aab");
        System.out.print(m);
    }
}
