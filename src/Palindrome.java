import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

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



    public int numSubarrayProductLessThanK(int[] nums, int k) {
        if (k <= 1) return 0;
        int prod = 1, ans = 0, left = 0;
        for (int right = 0; right < nums.length; right++) {
            prod *= nums[right];
            while (prod >= k) prod /= nums[left++];
            ans += right - left + 1;
        }
        return ans;
    }

    public int mynumSubarrayProductLessThanK(int[] nums, int k) {
        int i = 0,j = 0,sum =0,len = 0;
        while(i<=j && j<nums.length){
            sum =nums[j];
            if(sum<=k){
                j++;
                if(j>=nums.length) break;
                len = Math.max(len, j-i);
            }else{
                while(i<=j && sum>=k){
                    sum -=nums[i];
                    i++;
                }
                if((i==j+1) && (sum==0)){
                    j++;
                }
            }
        }
        return len;
    }
    /**
     * // This is the interface that allows for creating nested lists.
     * // You should not implement it, or speculate about its implementation/
     public interface NestedInteger {
     *     // Constructor initializes an empty nested list.
     *     public NestedInteger();
     *
     *     // Constructor initializes a single integer.
     *     public NestedInteger(int value);
     *
     *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     *     public boolean isInteger();
     *
     *     // @return the single integer that this NestedInteger holds, if it holds a single integer
     *     // Return null if this NestedInteger holds a nested list
     *     public Integer getInteger();
     *
     *     // Set this NestedInteger to hold a single integer.
     *     public void setInteger(int value);
     *
     *     // Set this NestedInteger to hold a nested list and adds a nested integer to it.
     *     public void add(NestedInteger ni);
     *
     *     // @return the nested list that this NestedInteger holds, if it holds a nested list
     *     // Return null if this NestedInteger holds a single integer
     *     public List<NestedInteger> getList();
     * }
     */
//    public int depthSum(List<NestedInteger> nestedList) {
//        return getSumDepth(nestedList, 1);
//
//    }
//
//    public int getSumDepth(List<NestedInteger> node, int depth){
//        int sum = 0;
//        for (NestedInteger n : node) {
//            if (n.isInteger()) {
//                sum += n.getInteger()*depth;
//            }else {
//                sum +=getSumDepth(n.getList(), depth+1);
//            }
//        }
//        return sum;
//    }
//    public int depthSumInverse(List<NestedInteger> nestedList) {
//        int maxDepth = calculateMaxDepth(nestedList,1);
//        // System.out.print(maxDepth+"\n")
//        return depth1(nestedList,maxDepth);
//    }
//    public int depth1(List<NestedInteger> nestedList,int depth){
//        int ans = 0;
//        for(NestedInteger n:nestedList){
//            if(n.isInteger()){
//                ans += n.getInteger() * depth;
//            }else{
//                ans += depth1(n.getList(),depth-1);
//            }
//        }
//        return ans;
//    }
//    public int calculateMaxDepth(List<NestedInteger> nest,int depth){
//        int ans = depth;
//        for(NestedInteger n:nest){
//            if(!n.isInteger()){
//                ans = Math.max(ans,calculateMaxDepth(n.getList(),depth+1));
//            }
//        }
//        return ans;
//    }

    static ArrayList<String> res = new ArrayList<>();

    //todo output all palindrom in string
    //time complexity O(n^2)
    public static ArrayList<String> findall(String s){
        if(s==null ||s.length()==0) return res;
        for(int i = 0;i<s.length();i++){
            //even
            int len1= check(i,i+1,s);
            if (len1>0){

                res.add(s.substring(i-len1+1,i+len1+1));
            }
            //odd
            int len2 = check(i,i,s);
            if(len2>0){
                if(len2==1) res.add(s.substring(i,i+1));
                //todo add substring need to +1 or it will less than
                else res.add(s.substring(i-len2+1,i+len2));
            }

        }
        return res;
    }
    public static int check(int i,int j, String s){
        int len = 0;
        while ( i>=0 && j<s.length() && i<=j && s.charAt(i)==s.charAt(j)){
            len++;
            i--;
            j++;
        }
        return len;
    }



    //todo:  solution2!!!
    public static String countMiddle (String s){
//        ArrayList<String> res = new ArrayList<>();
        String res = "";
        if(s.length()==0 ||s==null) return res;
        //todo: middle should be 2n-1 times
        int n = s.length();
        for (int m = 0;m<2*n-1;m++){
            int i = m/2;
            int j = (m+1)/2;
            int len = 0;
            while (i>=0 && j<n && i<=j && s.charAt(i)==s.charAt(j)){
                len++;
                //res.add(s.substring(i,j+1));
                if(res.length()<(j-i+1)) res = s.substring(i,j+1);

                i--;
                j++;
            }
        }
        return res;
    }


    /**
     * permutation of string to become palindrome
     * array hashmap
     * \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
     * use count to collect all remains for 2
     * \\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\
     * @param s
     * @return
     *
     * time O(n) space O(n)
     */
    public boolean PermutePalindrome(String s) {
        HashMap < Character, Integer > map = new HashMap < > ();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        int count = 0;
        for (char key: map.keySet()) {
            // todo only allow one of count +1
            count += map.get(key) % 2;
        }
        return count <= 1;
    }

    public boolean canPermutePalindrome(String s) {
        //todo permutation should use %2 --- may have character 3/5/4/6 times
        //permutation means one way of permute
        HashMap<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        int m1=0;
        for(char c: map.keySet()){
            if(map.get(c)%2==0) continue;
            else if(map.get(c)%2==1){
                if(m1==1) return false;
                else{
                    m1++;
                }
            }else{
                return false;
            }
        }
        return true;
    }







    //TODO Manchester
    static void findLongestPalindromicString(String text)
    {
        int N = text.length();
        if (N == 0)
            return;
        N = 2 * N + 1; // Position count
        int[] L = new int[N + 1]; // LPS Length Array
        L[0] = 0;
        L[1] = 1;
        int C = 1; // centerPosition
        int R = 2; // centerRightPosition
        int i = 0; // currentRightPosition
        int iMirror; // currentLeftPosition
        int maxLPSLength = 0;
        int maxLPSCenterPosition = 0;
        int start = -1;
        int end = -1;
        int diff = -1;

        // Uncomment it to print LPS Length array
        // printf("%d %d ", L[0], L[1]);
        for (i = 2; i < N; i++)
        {

            // get currentLeftPosition iMirror
            // for currentRightPosition i
            iMirror = 2 * C - i;
            L[i] = 0;
            diff = R - i;

            // If currentRightPosition i is within
            // centerRightPosition R
            if (diff > 0)
                L[i] = Math.min(L[iMirror], diff);

            // Attempt to expand palindrome centered at
            // currentRightPosition i. Here for odd positions,
            // we compare characters and if matchWildCard then
            // increment LPS Length by ONE. If even position,
            // we just increment LPS by ONE without
            // any character comparison
            while (((i + L[i]) + 1 < N && (i - L[i]) > 0) &&
                    (((i + L[i] + 1) % 2 == 0) ||
                            (text.charAt((i + L[i] + 1) / 2) ==
                                    text.charAt((i - L[i] - 1) / 2))))
            {
                L[i]++;
            }

            if (L[i] > maxLPSLength) // Track maxLPSLength
            {
                maxLPSLength = L[i];
                maxLPSCenterPosition = i;
            }

            // If palindrome centered at currentRightPosition i
            // expand beyond centerRightPosition R,
            // adjust centerPosition C based on expanded palindrome.
            if (i + L[i] > R)
            {
                C = i;
                R = i + L[i];
            }

            // Uncomment it to print LPS Length array
            // printf("%d ", L[i]);
        }

        start = (maxLPSCenterPosition - maxLPSLength) / 2;
        end = start + maxLPSLength - 1;
        System.out.printf("LPS of string is %s : ", text);
        for (i = start; i <= end; i++)
            System.out.print(text.charAt(i));
        System.out.println();
    }



    public static List<List<Integer>> palindromePairs(String[] words) {
        ArrayList<List<Integer>> list = new ArrayList<>();
        ArrayList<Integer> item = new ArrayList<>();
        for(int i = 0;i<words.length;i++){
            for(int j = i+1;j<words.length;j++){
                String concat1 = words[i]+ words[j];
                if(check(concat1)){
                    System.out.print(i +"!" + j);
                    item.add(i);
                    item.add(j);
                    list.add(item);
                    item.clear();
                }
                String concat2 = words[j] + words[i];
                if(check(concat2)){
                    System.out.print(j +"!" + i);
                    item.add(j);
                    item.add(i);
                    list.add(item);
                    item.clear();
                }
            }
        }
        return list;
    }

    //todo: use reverse in StringBuffer to check
    public static boolean check(String s){
        //use reverse
        String reverse = new StringBuilder(s).reverse().toString();
        return s.equals(reverse);
    }


    /**
     * int palindrome?
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        if(x<0) return false;
        boolean a  = true;
        String s = Integer.toString(x);
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i)-s.charAt(s.length()-i-1)!=0) a = false;
        }
        return a;
    }

    public static boolean IsPalindrome(int x) {
        //todo run time O(log_10ˆn)
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while(x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of it.
        return x == revertedNumber || x == revertedNumber/10;
    }

    public static void main (String args[]){
        IsPalindrome(12321);

        palindromePairs(new String[]{"abcd","dcba","lls","s","sssll"});
        String text = "babcbabcbaccba";
        findLongestPalindromicString(text);
        countMiddle("abbc");
        findall("aaa");
        String m = longestPalindrome("aab");
        System.out.print(m);
    }
}
