import java.util.*;

public class amazon {
    //1. todo: most common word
    public static String mostCommonWord(String paragraph, String[] banned) {
        String res = "";
        HashMap<String, Integer> map = new HashMap<>();
//        paragraph.trim();
//        paragraph = paragraph.replaceAll("\\!|\\?|\\'|\\,|\\;|\\.", " ");
//        paragraph = paragraph.trim();  // should be put after all those replace()
        paragraph = paragraph.trim().toLowerCase();
        String[] words = paragraph.split("\\W+",2);
        for(String word : words){
            if(word.length()!=0){

                /**todo: update map!!!
                 * map.put(finalword, map.getOrDefault(finalword, 0) + 1);

                 */
                if(map.containsKey(word)){
                    int  m= map.get(word);
                    m++;
                    map.put(word, m);
                }else{
                    map.put(word, 1);
                }
            }

        }
        for (String ban : banned){
            if(map.containsKey(ban)){
                map.remove(ban);
            }
        }
        int max = 0;
        for(String s: map.keySet()){
            System.out.print(s+map.get(s)+" ");
            if(map.get(s)>max){
                max = map.get(s);
                res = s;
            }
        }
        return res;
    }




    public static String commonWord(String paragraph, String[] banned) {
        paragraph += ".";

        Set<String> banset = new HashSet();
        for (String word: banned) banset.add(word);
        Map<String, Integer> count = new HashMap();

        String ans = "";
        int ansfreq = 0;

        StringBuilder word = new StringBuilder();
        for (char c: paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String finalword = word.toString();
                if (!banset.contains(finalword)) {
                    count.put(finalword, count.getOrDefault(finalword, 0) + 1);
                    if (count.get(finalword) > ansfreq) {
                        ans = finalword;
                        ansfreq = count.get(finalword);
                    }
                }
                word = new StringBuilder();
            }
        }

        return ans;
    }


    /**
     * 2.Substrings of size K with K distinct chars
     *Given a string s and an int k, return all unique substrings of s of size k with k distinct characters
     *
     * The input string consists of only lowercase English letters [a-z]
     0 ≤ k ≤ 26
     Input: s = "abcabc", k = 3
     Output: ["abc", "bca", "cab"]
     */
    public static List<String> substringk(int k, String s){
        HashSet<String> set = new HashSet<>();
        ArrayList<String> res = new ArrayList<>();
        if (s.length()<k) return res;
        else {
            for (int i = 0;i<=s.length()-k;i++){
                String sub = s.substring(i, i+ k);
                if (!set.contains(sub) && isDistinct(sub)) set.add(sub);
            }
        }
        for(String m: set){
            res.add(m);
        }
        return res;
    }

    public static boolean isDistinct(String s){
        if (s.length()==0) return false;
        else {
            HashSet<Character> set = new HashSet<>();
            for (int i = 0;i<s.length();i++){
                set.add(s.charAt(i));
            }
            if (set.size()!=s.length()) return false;
            else return true;
        }
    }

    //todo solution 2 sliding window
    public List<String> CountSub(String S,int k){
        int distinct=0,i=0;
        int [] memo=new int[26];
        Set<String> set=new HashSet<>();
//        for (;i<k;i++){
//            if (memo[S.charAt(i)-'a']==0)
//                distinct+=1;
//            memo[S.charAt(i)-'a']+=1;
//        }
//        if (distinct==k) {
//            set.add(S.substring(i-k,i));
//        }
        while (i<S.length()){
            if (memo[S.charAt(i)-'a']==0)
                distinct+=1;
            memo[S.charAt(i)-'a']+=1;
            memo[S.charAt(i-k)-'a']-=1;
            if (memo[S.charAt(i-k)-'a']==0)
                distinct-=1;
            if (distinct==k)
                set.add(S.substring(i-k+1,i+1));
            i+=1;
        }

        return new ArrayList<>(set);
    }


    public static String longestPalindrome(String s) {
        if(s.length()==0) return "";
        if(s.length()==1) return s;
        int st = 0, len=0;
        for(int n = 1;n<s.length();n++){
            int i = n;
            int j = n;
            //odd
            if(s.charAt(i-1)==s.charAt(j+1)) {
                int m = check(i-1,j+1,s);
                if(2*m+1>len){
                    len =2*m+1 ;
                    st = n-m;
                }
            }
            //even
            if(s.charAt(i-1)==s.charAt(j)){
                int m = check(i-1,j,s);
                if(2*m>len){
                    len = m;
                    st = n-m;
                }
            }
        }
        return s.substring(st,st+len);
    }
    public static int check(int i,int j, String s){
        int temp = 0;
        while(i>=0 && j<s.length() && s.charAt(i)==s.charAt(j)){
            temp++;
            i--;
            j++;
        }
        return temp;
    }


    public static int subarraysWithKDistinct(int[] A, int K) {
        int i = 0,j = i+K-1;
        int res=0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int m = 0;m<K;m++){
            map.put(A[m], map.getOrDefault(A[m],0) +1);
        }
        while(i<=j &&j<A.length){
            if(map.keySet().size() <K){
                j++;
                if(j<A.length) map.put(A[j], map.getOrDefault(A[j],0) +1);
            }else if(map.keySet().size() ==K){
                res++;
                j++;
                if(j<A.length) map.put(A[j], map.getOrDefault(A[j],0) +1);
            }else if(map.keySet().size()>K){
                map.put(A[i], map.get(A[i]) -1);
                if(map.get(A[i])==0) map.remove(A[i]);
                i++;
            }
        }
        return res;
    }


    public int subarrayWithKDistinct(int[] A, int K) {
        int size = A.length;
        int count = 0 ;
        Map<Integer, Integer> m = new HashMap<>();

        int l=0, r=0;
        while(true) {
            while(r<size && m.size()< K) {
                add(m, A[r]);
                r++;
            }

            // return answer if we run out of elements
            if(m.size()!=K) return count;

            // At this point, r is one pointer ahead of p & we have K elements in the window [l, p]
            int temp = r-1;
            // Start from p and count for all indexes for which window [l, temp] has K elements. These are the possible ends of the sub array starting at l.
            while(temp<size && has(m, A[temp])) {
                count++;
                temp++;
            }

            // since all the end pointers have been counted for subarray starting at l, we can move to next element as starting point of subarray
            remove(m, A[l]);
            l++;
        }
    }
    public void add(Map<Integer, Integer> m, int i) {
        m.put(i, m.getOrDefault(i, 0)+1);
    }

    public boolean has(Map<Integer, Integer> m, int i){
        return m.getOrDefault(i, 0)!=0;
    }

    public void remove(Map<Integer, Integer> m, int i) {
        int count = m.getOrDefault(i, 0);
        if(count<2) m.remove(i);
        else m.put(i, count - 1);
    }




    public Map<Integer, Double> highFive(Record[] results) {
        // Write your code here

        Map<Integer, Double> result = new HashMap<Integer, Double>();
        HashMap<Integer, PriorityQueue<Record>> map = new HashMap<Integer, PriorityQueue<Record>>();

        int k = 5;
        for (Record r : results) {
            if (!map.containsKey(r.id)) {
                PriorityQueue<Record> pq = new PriorityQueue<Record>(k, new Comparator<Record>() {
                    public int compare(Record a, Record b) {
                        return a.score - b.score; // min-heap
                    }
                });
                map.put(r.id, pq);
            }

            map.get(r.id).add(r);
            if (map.get(r.id).size() > k) {
                map.get(r.id).poll();
            }
        }

        for (Map.Entry<Integer, PriorityQueue<Record>> entry : map.entrySet()) {
            int id = entry.getKey();
            PriorityQueue<Record> pq = entry.getValue();
            double average = 0;
            int num = pq.size();
            while (!pq.isEmpty()) {
                average += pq.poll().score;
            }
            average /= num;
            result.put(id, average);
        }

        return result;
    }


    public static void main(String args[]){
//        1.mostcommon words
//        String m = commonWord("a, AAA, ? ! &% $ # &((a, a, b,b,b,c, c", new String[]{"b"});
//        2. Substrings of size K
//        List<String> s = substringk(4,"awaglknagawunagwkwagl");

        /**
         * limit > 0 : If this is the case then the pattern will be
         applied at most limit-1 times, the resulting
         array’s length will not be more than n, and
         the resulting array’s last entry will contain
         all input beyond the last matched pattern.

         limit < 0 : In this case, the pattern will be applied as
         many times as possible, and the resulting
         array can be of any size.

         limit = 0 : In this case, the pattern will be applied as
         many times as possible, the resulting array can
         be of any size, and trailing empty strings will
         be discarded.

         Regex       Limit             Result
         @           2         {“geekss”, ”for@geekss”}    // only apply 1 time
         @           5         {“geekss”, ”for”, ”geekss”}
         @           -2       {“geekss”, ”for”, ”geekss”}
         s           5        {“geek”, ”“, “@for@geek”, “”, “”}
         s           -2       {“geek”, ” “, “@for@geek”, “”, “”}
         s           0        {“geek”, ””, ”@for@geek”}

         */


//
//        /*
//        longest palindrome
//         */
//        String m = longestPalindrome("bb");
//        System.out.print(m);

//        subKDistinct(new int[]{1,2,1,2,3},2);



    }

}

class Record {
    public int id, score;
    public Record(int id, int score){
        this.id = id;
        this.score = score;
    }
}
