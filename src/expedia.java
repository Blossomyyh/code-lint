import java.util.*;

public class expedia {
    //todo dp Wildcard Matching
    public boolean isMatch(String s, String p) {
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[sl+1][pl+1];
        dp[sl][pl] = true;
        for (int i = sl; i >= 0; i--) {
            for (int j = pl-1; j >= 0; j--) {
                if (p.charAt(j) == '*') {
                    if (i < sl) {
                        dp[i][j] = dp[i+1][j+1] || dp[i][j+1] || dp[i+1][j];
                    } else {
                        dp[i][j] = dp[i][j+1];
                    }
                } else if (i < sl && (p.charAt(j) == '?' || s.charAt(i) == p.charAt(j))) {
                    dp[i][j] = dp[i+1][j+1];
                }
            }
        }
        return dp[0][0];
    }


    //todo union Accounts Merge
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        DSU dsu = new DSU();
        Map<String, String> emailToName = new HashMap();
        Map<String, Integer> emailToID = new HashMap();
        int id = 0;
        for (List<String> account: accounts) {
            String name = "";
            for (String email: account) {
                if (name == "") {
                    name = email;
                    continue;
                }
                emailToName.put(email, name);
                if (!emailToID.containsKey(email)) {
                    emailToID.put(email, id++);
                }
                dsu.union(emailToID.get(account.get(1)), emailToID.get(email));
            }
        }

        Map<Integer, List<String>> ans = new HashMap();
        for (String email: emailToName.keySet()) {
            int index = dsu.find(emailToID.get(email));
            ans.computeIfAbsent(index, x-> new ArrayList()).add(email);
        }
        for (List<String> component: ans.values()) {
            Collections.sort(component);
            component.add(0, emailToName.get(component.get(0)));
        }
        return new ArrayList(ans.values());
    }


    //todo sliding window
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int res = 0,i = 0, j = 0;

        while(i<=j &&j<s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                res = Math.max(res, j-i+1);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }

    //todo optimization sliding window
    public int LongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int res = 0;
        for(int i = 0, j = 0; j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                //todo confirm i max
                i = Math.max(i, map.get(s.charAt(j)));
            }
            //todo have to put next position
            map.put(s.charAt(j), j+1);

            res = Math.max(res, j-i+1);
        }

        return res;
    }

    //todo trap water
    //O(n
    public int trap(int[] height) {
        int h = height.length;
        if(height==null || h==0) return 0;


        int[] left = new int[h];
        int[] right = new int[h];
        int res = 0;
        left[0] = height[0];
        for(int i = 1;i<h;i++){
            left[i] = Math.max(left[i-1], height[i]);
        }
        right[h-1] = height[h-1];
        for(int i = h-2;i>=0 ;i--){
            right[i] = Math.max(right[i+1],height[i] );
        }
        for(int i = 1; i<h-1;i++){
            res += Math.min(left[i], right[i])-height[i];
        }
        return res;
    }


    //A PriorityQueue is used when the objects are supposed to
    // be processed based on the priority.
    //todo min heap
    // It is known that a queue follows First-In-First-Out algorithm,
    // but sometimes the elements of the queue are needed to be processed according to the priority,
    // that’s when the PriorityQueue comes into play.
    // The PriorityQueue is based on the priority heap.
    // The elements of the priority queue are ordered according to the natural ordering,
    // or by a Comparator provided at queue construction time,
    // depending on which constructor is used.

    public static List<String> topKFrequent(String[] words, int k) {
        HashMap<String, Integer> count = new HashMap<>();
        for(String word: words){
            count.put(word, count.getOrDefault(word, 0) +1);
        }

        ArrayList<String> res = new ArrayList<String>();

        //todo O(nlogk) heap
        PriorityQueue<String> q = new PriorityQueue<String>(
                (w1, w2) -> count.get(w1).equals(count.get(w2)) ?
                        w2.compareTo(w1) : count.get(w1) - count.get(w2) );//less is former
        for(String s: count.keySet()){
            q.offer(s);
            if(q.size()>k) q.poll();//poll the min
        }

        while (!q.isEmpty()){
            res.add(q.poll());
        }
        Collections.reverse(res);

        //todo:  sort -- O(nlogn)
        ArrayList<String> candidates = new ArrayList<String>(count.keySet());
        Collections.sort(candidates, (o1, o2) ->
                //bigger is former
                count.get(o1)==count.get(o2)? o1.compareTo(o2): count.get(o1)-count.get(o2));
        candidates.subList(0,k);

        return res;
    }


    public boolean rotateSString(String A, String B) {
        return A.length()==B.length() && (A+A).contains(B);
    }


    public static boolean rotateString(String A, String B) {
        int N = A.length();
        if (N != B.length()) return false;
        if (N == 0) return true;

        //Compute shift table
        int[] shifts = new int[N+1];
        Arrays.fill(shifts, 1);
        int left = -1;
        for (int right = 0; right < N; ++right) {
            while (left >= 0 && (B.charAt(left) != B.charAt(right)))
                left -= shifts[left];
            shifts[right + 1] = right - left++;
        }

        //Find match of B in A+A
        int matchLen = 0;
        for (char c: (A+A).toCharArray()) {
            while (matchLen >= 0 && B.charAt(matchLen) != c)
                matchLen -= shifts[matchLen];
            if (++matchLen == N) return true;
        }

        return false;
    }


    public static void main(String args[]){
        rotateString("abc", "cab");
        topKFrequent(new String[]{"i", "love", "leetcode", "i", "love", "coding"},2);
    }


}


class DSU {
    int[] parent;
    public DSU() {
        parent = new int[10001];
        for (int i = 0; i <= 10000; ++i)
            parent[i] = i;
    }
    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }
    public void union(int x, int y) {
        parent[find(x)] = find(y);
    }


    //todo sliding window

}
