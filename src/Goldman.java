import java.util.*;

public class Goldman {
    //todo: comparator!!!!
    //1. mapping后真实数字开头一堆0，所以给的不同数字会出现相等的情况
    //2. 两个input的都是string list
    //3. 给定的那组数字，每个数字长度是0～100（没错，我就是没看到这个），所以不能parseInt
    //Q1 Strange Sorting
//    public static String[] strangeSorting(int[] m, String[] nums){
//        Map<Integer,Integer> map = new HashMap<>();
//        for(int i = 0; i < m.length; i++)
//            map.put(m[i],i);
//        Arrays.sort(nums, new Comparator<String>() {
//            @Override
//            public int compare(String o1, String o2) {
//                StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
//                Boolean record = false;
//                for(char c:o1.toCharArray()){
//                    // how to make string Integer to become int -> '-'0''
//                    if(!record && map.get(c-'0')!= 0) record = true;
//                    if(record) sb1.append(map.get(c-'0'));
//                }
//                record = false;
//                for(char c:o2.toCharArray()){
//                    if(!record && map.get(c-'0')!= 0) record = true;
//                    if(record) sb2.append(map.get(c-'0'));
//                }
//                if(sb1.length()!= sb2.length()) return sb1.length()>sb2.length()? 1:-1;
//                else return sb1.toString().compareTo(sb2.toString());
//            }
//        });
//        return nums;
//    }

    //todo: 1.Find the rank
    //这题狠狠被坑了一把，一开始楼主用的暴力解法(sort全部)
    //只能过4个test case，想了好久才意识到可能有memory和time的限制，
    //于是改成用size为K的priority_queue把时间复杂度从NlogN降到NlogK
    //(处理tie的时候要小心)，然而还是有5个test case过不了，后来一想好像没考虑K>N的情况。

    // Q2 Find the Rank
    public static int findRank(int[][] performance, int rank){
        int n = performance.length, k = performance[0].length;
        int[][] grade = new int[n][2];
        for(int i = 0; i < n; i++){
            int g = 0;
            for(int j = 0; j < k; j++)
                g += performance[i][j];
            grade[i][0] = g;
            grade[i][1] = i;
        }
        Arrays.sort(grade,(a,b)->b[0]-a[0]);
        for(int i = 0; i< n; i++){
            System.out.println("Grade is "+grade[i][0]+" ID is "+grade[i][1]);
        }
        return grade[rank-1][1];
    }

    //题目是matrix game
    //意思就是两个人在一个矩阵中选数字，每个人都optimal地选，被选过的coloum就不能再被选了，问最后两个人的分数差
    //我是用heap做的，把所有数字都存在heap里面，过了所有test case
    // Q3 Matrix Game
    public static int matrixGame(int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for(int j = 0; j < m; j++){
            int colMax = Integer.MIN_VALUE;
            for(int i = 0; i < n; i++){
                colMax = Math.max(colMax, matrix[i][j]);
            }
            pq.offer(colMax);
        }
        int Tom = 0, Jerry = 0;
        Boolean tomTurn = true;
        while(!pq.isEmpty()){
            if(tomTurn) Tom += pq.poll();
            else Jerry += pq.poll();
            tomTurn = !tomTurn;
        }
        return Tom-Jerry;
    }

    // Q4 Spiral Matrix
    public static int maxInteger = 1000000;
    public static List<Integer> spiralMatrix(List<List<Integer>> matrix){
        List<Integer> list = new ArrayList<>();
        if(matrix == null || matrix.size() == 0) return list;
        //Prime table
        boolean[] prime = new boolean[maxInteger];
        Arrays.fill(prime,true);
        prime[0] = false; prime[1] = false;
        for(int i = 2; i < (int)Math.sqrt(maxInteger)+1; i++){
            if(prime[i]){
                for(int j = i*i; j < maxInteger; j+=i)
                    prime[j] = false;
            }
        }
        //Iterate Spiral Matrix
        int m = matrix.size(), n = matrix.get(0).size();
        boolean[][] vis = new boolean[m][n];
        int[][] dir = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
        int i = 0, j = 0, d = 0;
        while(!vis[i][j]){
            vis[i][j] = true;
            int element = matrix.get(i).get(j);
            if(prime[element]) list.add(element);
            int nexti = i+dir[d][0], nextj = j+dir[d][1];
            if(nexti == m || nextj == n ||nexti <0 || nextj < 0 || vis[nexti][nextj]) d = (d+1)%4;
            //todo: how to change d --> make it %4!!
            i = i+dir[d][0]; j = j+dir[d][1];
            if(i<0 || i== m || j < 0 || j==n) break; //for special cases like [[1]]
        }
        return list;
    }

    //Q5 Weekly Stock Price

    public static List<String> weeklyStockPrice(int[] dailyPrice){
        List<String> list = new ArrayList<>();
        if(dailyPrice.length<7) return list;
        int len = dailyPrice.length, prefixSum[] = new int[len+1];
        for(int i = 1; i <= len; i++){
            prefixSum[i] = prefixSum[i-1] + dailyPrice[i-1];
        }
        for(int i = 7; i < prefixSum.length; i++){
            double avg = (double)(prefixSum[i]-prefixSum[i-7])/7;
            String s = String.format("%.2f",avg);
            list.add(s);
        }
        return list;
    }

    //Q6 Rotate the String
    public static String rotateTheString(String s, int[] dir, int[] amount){
        int len = s.length();
        int left = 0, right = 0;
        for(int i = 0; i < dir.length; i++){
            if(dir[i] == 0) {
                left += amount[i]%len;
                left %= len;
            }
            else {
                right += amount[i]%len;
                right %= len;
            }
        }
        if(left == right) return s;
        else if(left > right){
            left = left - right;
            s += s.substring(0,left);
            return s.substring(left);
        }
        else {
            right = right - left;
            s = s.substring(len-right) + s;
            return s.substring(0,len);
        }
    }

    //Q7 Maximum cut commonality
    public static int maxCutCommon(String s){
        int max = 0,cur = 0;
        if(s.length()==1) return 0;
        Map<Character, Integer> map = new HashMap<>();
        for(char c:s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }
        boolean[] common  = new boolean[26];
        for(int i = 0; i < s.length()-1; i++){
            char c = s.charAt(i);
            int t = map.get(c);
            if(t == 1 && common[c-'a']) cur--;
            else if(t > 1 && !common[c-'a']){
                common[c-'a'] = true;
                cur++;
            }
            map.put(c,t-1);
            max = Math.max(max, cur);
        }
        return max;
    }

    //Q8 Grid Game
    public static int[][] gridGame(int[][] grid, int k, String[] rules) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int cnt = findNeighbor(grid, i, j);
                if (rules[cnt].equals("alive")) res[i][j] = 1;
            }
        }
        return k == 1 ? res : gridGame(res, k - 1, rules);
    }

    public static int findNeighbor(int[][] grid, int row,int col){
        int[][] dir = new int[][]{{-1,1},{-1,0},{-1,-1},{0,-1},{0,1},{1,-1},{1,0},{1,1}};
        int cnt = 0;
        for(int i = 0; i < 8; i++){
            int x = row + dir[i][0], y = col + dir[i][1];
            if(x >= 0 && x < grid.length && y>= 0 && y < grid[0].length && grid[x][y] == 1)
                cnt++;
        }
        return cnt;
    }

    //Q9 Share Purchases
    public static long sharePurchases(String s){
        int[] map = new int[128];
        map['A'] = 1;
        map['B'] = 1;
        map['C'] = 1;
        long cnt = 0;
        int l = 0, r = 0, counter = 3;
        while(r < s.length()){
            if(map[s.charAt(r++)]-->0) counter--;
            while(counter == 0){
                System.out.println(s.substring(l,r));
                cnt += s.length()-r + 1;
                if(map[s.charAt(l++)]++==0) counter++;
            }
        }
        return cnt;
    }


    public static String rotateString(String originalString, List<Integer> direction, List<Integer> amount) {
        // Write your code here
        if(amount.size()!=direction.size() || originalString.length()== 0) return "";
        //rotate equal to add string in front of/at the end of the original string
        String res= originalString;
        int len = originalString.length();
        for(int i = 0; i<direction.size(); i++){
            int rot = amount.get(i);
            if(direction.get(i)==0){
                //add len of original string in front of res and choose substring from 0-len
                if(rot<=res.length()){
                    res = res.substring(len-rot, len) + res;
                }
                else{
                    int time = rot/len;
                    String add = "";
                    for(int t = 0; i<time; i++) add=add + res;
                    //res = res.substring(let - rot%len, len) + add +res;
                }
                res = res.substring(0, len);
            }else if(direction.get(i)==1){
                //add len of original string at the end of res and choose substring from 0-len
                if(rot<=res.length()){
                    res = res + res.substring(0,rot);
                }else{
                    int time = rot/len;
                    String add = "";
                    for(int t = 0; i<time; i++) add=add + res;
                    res =res + add +res.substring(0, rot%len);
                }

                res = res.substring(rot);
            }
        }
        return res;
    }


    public static List<List<Integer>> agridGame(List<List<Integer>> grid, int k, List<String> rules) {
        // Write your code here
        int n = grid.size();
        int m = grid.get(0).size();
        List<List<Integer>> out = new ArrayList<>();
        for(int i = 0; i<n; i++){
            List<Integer> line = new ArrayList<>();
            for(int j = 0; j<m; j++){
                if(rules.get(check(grid, i,j,m,n)).equals("alive")){
                    line.add(1);
                }else{
                    line.add(0);
                }
            }
            out.add(line);
        }
        return k==1? out:agridGame(grid, k-1, rules);
    }

    public static int check (List<List<Integer>> grid, int i, int j, int m, int n){
        int res = 0;
        int[][] dir = {{0,1},{0,-1},{1,0}, {-1,0}, {1,1}, {1,-1}, {-1,1}, {-1,-1}};
        for(int k = 0; k<8; k++){
            int x = i+dir[k][0];
            int y = j+dir[k][1];
            if(x<m && y<n && x>=0 && y>=0 && grid.get(x).get(y)==1){
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> a = new ArrayList<Integer>();
        a.add(0);
        a.add(1);
        a.add(0);
        a.add(0);
        List<Integer> b = new ArrayList<Integer>();
        b.add(0);
        b.add(0);
        b.add(0);
        b.add(0);
        List<List<Integer>> m = new ArrayList<>();
        m.add(a);
        m.add(b);
        List<String> s = new ArrayList<>();
        s.add("dead");
        s.add("alive");
        s.add("dead");
        s.add("dead");
        s.add("dead");
        s.add("dead");
        s.add("dead");
        s.add("dead");

        agridGame(m, 1,s);
        //rotateaString("ephjos", a,b);
        //Q1
        //Testcase 1
//        int mapping[] = new int[]{3,5,4,6,2,7,9,8,0,1};
//        String nums[] = new String[]{"990","332","32"};
        //Testcase 2
//        int mapping[] = new int[]{2,1,4,8,6,3,0,9,7,5};
//        String nums[] = new String[]{"12","02","4","023","65","83","224","50"};
        //TestCase 3
//        int mapping[] = new int[]{0,1,2,3,4,5,6,7,8,9};
//        String nums[] = new String[]{"180","84","99","003","53","28","60","070","1"};
//        System.out.println(Arrays.asList(strangeSorting(mapping,nums)));
        //Q2
//        int[][] performance = new int[][]{{79,89,15},{85,89,92},{71,96,88},{71,96,88}};
//        int rank = 2;
//        System.out.println(findRank(performance,rank));
        //Q3
        //Testcase1
//        int[][] matrix = new int[][]{
//                {3,7,5,3,4,5},
//                {4,5,2,6,6,4},
//                {7,4,9,7,8,3}
//        };
        //Testcase2
//        int[][] matrix = new int[][]{
//                {5,7,6,2,8,4,4,8},
//                {2,5,4,5,9,8,4,2},
//                {5,4,3,9,8,3,3,4},
//                {4,9,3,4,6,7,4,9},
//                {2,4,6,2,9,2,4,2}
//        };
//
//        System.out.println(matrixGame(matrix));
        //Q4. Spiral matrix
//        int[][] m = new int[][]{
//                {104723,7,3,200040,104549},
//                {13,5,104707,5,2},
//                {9,2,104712,3,9},
//                {6,12,0,11,104729}
//        };
//        List<List<Integer>> matrix = new ArrayList<>();
//        for(int i = 0; i < m.length; i++){
//            List<Integer> tmp = new ArrayList<>();
//            for(int j = 0; j< m[0].length;j++){
//                tmp.add((m[i][j]));
//            }
//            matrix.add(tmp);
//        }
//        long startTime = System.nanoTime();
//        System.out.println(spiralMatrix(matrix));
//        long endTime   = System.nanoTime();
//        long totalTime = endTime - startTime;
//        System.out.println(totalTime);
        // 104549 104551 104561 104579 104593 104597 104623 104639 104651 104659
        // 104677 104681 104683 104693 104701 104707 104711 104717 104723 104729

        //Q5 Weekly Stock Price
        //T1
//        int dailyPrice[] = new int[]{1,1,1,1,1,1,1,7,7,7,7,7,7,7};
        //T2
//        int dailyPrice[] = new int[]{5,5,5,5,5,5,5,6,6};
        //T3
//        int dailyPrice[] = new int[]{7,8,8,11,9,7,5,6};
//        System.out.println(weeklyStockPrice(dailyPrice));

        //Q6 Rotate the String
//        String s = "huart";
//        int dir[] = new int[]{1,0,1,0,1};
//        int amount[] = new int[]{10, 10, 10, 12, 0};
//        System.out.println(rotateTheString(s,dir,amount));

        //Q7 Maximum common cut
//        String s = "aaaaaaaabcac";
//        System.out.println(maxCutCommon(s));

        // Q8 grid game
//        int[][] grid = new int[][]{
//                {0,1,0,0},
//                {0,0,0,0}
//        };
//        int k = 1;
//        String[] rules = new String[]{"dead","alive","dead","dead","dead","dead","dead","dead"};
//        int[][] res = gridGame(grid,k,rules);
//        for(int i = 0; i < grid.length; i++){
//            for(int j = 0; j < grid[0].length; j++){
//                System.out.print(res[i][j]+" ");
//            }
//            System.out.println();
//        }
        //Q9 Share Purchase
//        String s = "ABhdCAPBAC";
//        System.out.println(sharePurchases(s));
    }
}
