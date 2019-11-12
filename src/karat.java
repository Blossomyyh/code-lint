import java.util.*;

public class karat {

    public boolean existgood(char[][] board, String word) {
        char[] charedWord = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (hasPath(i, j, board, 0, charedWord)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean hasPath(int i, int j, char[][] board, int curr, char[] word) {
        if (isNotAMatch(i, j, board, curr, word)) {
            return false;
        }

        if (curr == word.length - 1) {
            return true;
        }

        char originalChar = board[i][j];
        board[i][j] = 0;

        boolean isMatch = hasPath(i + 1, j, board, curr + 1, word) ||
                hasPath(i, j + 1, board, curr + 1, word) ||
                hasPath(i - 1, j, board, curr + 1, word) ||
                hasPath(i, j - 1, board, curr + 1, word) ;

        board[i][j] = originalChar;

        return isMatch;
    }

    private boolean isNotAMatch(int i, int j, char[][] board, int curr, char[] word) {
        return (i < 0) || (i >= board.length)    ||
                (j < 0) || (j >= board[i].length) ||
                (board[i][j] != word[curr]);
    }


    /**
     * go through target
     */

    Set<Integer> seen = new HashSet();
    int MAX_EDGE_VAL = 1000;


    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<Integer>[] graph = new ArrayList[MAX_EDGE_VAL + 1];
        for (int i = 0; i <= MAX_EDGE_VAL; i++) {
            graph[i] = new ArrayList();
        }

        for (int[] edge: edges) {
            //for each edge to go keep track , dfs to see whether those 2 can be connected
            seen.clear();
            if (!graph[edge[0]].isEmpty() && !graph[edge[1]].isEmpty() &&
                    dfs(graph, edge[0], edge[1])) {
                return edge;
            }
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        throw new AssertionError();
    }
    public boolean dfs(ArrayList<Integer>[] graph, int source, int target) {
        if (!seen.contains(source)) {
            seen.add(source);
            if (source == target) return true;
            for (int nei: graph[source]) {
                if (dfs(graph, nei, target)) return true;
            }
        }
        return false;
    }

    //O(n^2)




    public static int findLength(int[] A, int[] B) {
        int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        int[] res = new int[A.length];
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }
        return ans;
    }

    /**
     * domain record
     * @param input
     * @return
     */

    public static List<List<String>> domain (List<List<String>> input){
        HashMap<String,Integer> map  = new HashMap<>();
        for (List<String> item : input){
            String dom = item.get(0);
            String[] slist = dom.split("\\.");
            int time = Integer.parseInt(item.get(1));
            StringBuffer s = new StringBuffer();
            for(int i=slist.length-1;i>=0; i--){
                //google.com
                if(i==slist.length-1) {
                    s = s.insert(0, slist[i]);
                }else {
                    s = s.insert(0, slist[i]+".");

                }
                map.put(s.toString(),map.getOrDefault(s.toString(),0)+time);
            }

        }
        return new ArrayList<List<String>>();

    }

    /**
     * dp !
     * find the most common list in 2 list
     * @param a
     * @param b
     * @return
     */

        public static String[] common(String[] a, String[] b){
        int r = a.length;
        int c = b.length;
        int[][] dp = new int[r][c];
        int time = 0;
        for(int i = r-1;i>=0;i--){
            for(int j = c-1; j>=0;j--){
                if (a[i]==b[j]){
                    time++;
                    dp[i][j]=time;
                }else {
                    time = 0;
                    dp[i][j]=time;
                }
            }
        }
        return new String[]{""};
    }


    /**
     * Intuit ⽹网上coding competition的⼀一道题给⼀一个矩阵，矩阵⾥里里的每个元素是1，
     * 但是其中分布着⼀一些⻓长 ⽅方形区域， 这些⻓长⽅方形区域中的元素为0.
     * 要求输出每个⻓长⽅方形的位置（⽤用⻓长⽅方形的左上⻆角元素坐标 和右下⻆角元素坐标表示）。
     */


//    int ans;
    int[][] grid;
    int tr, tc;
    int[] dr = new int[]{0, -1, 0, 1};
    int[] dc = new int[]{1, 0, -1, 0};
    int R, C;

    public int uniquePathsIII(int[][] grid) {
        this.grid = grid;
        R = grid.length;
        C = grid[0].length;

        int todo = 0;
        int sr = 0, sc = 0;
        for (int r = 0; r < R; ++r)
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] != -1) {
                    todo++;
                }

                if (grid[r][c] == 1) {
                    sr = r;
                    sc = c;
                } else if (grid[r][c] == 2) {
                    tr = r;
                    tc = c;
                }
            }

        ans = 0;
        dfs(sr, sc, todo);
        return ans;
    }

    public void dfs(int r, int c, int todo) {
        todo--;
        if (todo < 0) return;
        if (r == tr && c == tc) {
            if (todo == 0) ans++;
            return;
        }

        grid[r][c] = 3;
        for (int k = 0; k < 4; ++k) {
            int nr = r + dr[k];
            int nc = c + dc[k];
            if (0 <= nr && nr < R && 0 <= nc && nc < C) {
                if (grid[nr][nc] % 2 == 0)
                    dfs(nr, nc, todo);
            }
        }
        grid[r][c] = 0;
    }


    /**
     * LCA lowest common ancestor
     * O(n)
     */
    private TreeNode ans = null;

    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {

        // If reached the end of a branch, return false.
        if (currentNode == null) {
            return false;
        }

        // Left Recursion. If left recursion returns true, set left = 1 else 0
        int left = this.recurseTree(currentNode.left, p, q) ? 1 : 0;

        // Right Recursion
        int right = this.recurseTree(currentNode.right, p, q) ? 1 : 0;

        // If the current node is one of p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;


        // If any two of the flags left, right or mid become True
        if (mid + left + right >= 2) {
            this.ans = currentNode;
        }

        // Return true if any one of the three bool values is True.
        return (mid + left + right > 0);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // Traverse the tree
        this.recurseTree(root, p, q);
        return this.ans;
    }


    /**
     * meeting room
     */
    public boolean canAttendMeetings(int[][] intervals) {
        Comparator<int[]> c = (int[] a, int[] b) ->(a[0]-b[0]);
        Arrays.sort(intervals, c);
        for(int i=0; i<intervals.length-1; i++)
            if(intervals[i][1]>intervals[i+1][0]) return false;
        return true;
    }

    private class IntervalComparator implements Comparator<Interval> {
        @Override
        public int compare(Interval a, Interval b) {
            return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
        }
    }

    public List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, new IntervalComparator());

        LinkedList<Interval> merged = new LinkedList<Interval>();
        for (Interval interval : intervals) {
            // if the list of merged intervals is empty or if the current
            // interval does not overlap with the previous, simply append it.
            if (merged.isEmpty() || merged.getLast().end < interval.start) {
                merged.add(interval);
            }
            // otherwise, there is overlap, so we merge the current and previous
            // intervals.
            else {
                merged.getLast().end = Math.max(merged.getLast().end, interval.end);
            }
        }

        return merged;
    }

    /**O(nlogn)
     *
     *  if return common leisure time:
     *  print from 0-end traversal
     */


}

class Interval{
    int start=0;
    int end =0;
}





