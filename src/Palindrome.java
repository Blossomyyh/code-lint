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



    public static void main (String args[]){
        String m = longestPalindrome("aab");
        System.out.print(m);
    }
}
