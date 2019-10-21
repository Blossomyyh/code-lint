import org.omg.PortableInterceptor.INACTIVE;

import java.lang.reflect.Array;
import java.util.*;

public class quora {

    /**
     * 输入一组 words 和一组 valid letters，判断有多少个 words 是 valid。判断条件是 words

     里的所有 upper and lower letter 必须在 valid letters 里面。如果 word 里面有 special

     character 不用管。注意 valid letter 只有小写，但是 words 里面有大写的也算 valid。比如 words

     = [hEllo##, This^^], valid letter = [h, e, l, 0, t, h, s]; "hello##" 就是 valid，因为 h，e，l，o

     都在 valid letter 里面， “This^^” 不 valid, 因为 i 不在 valid letter 里面


     题目是键盘坏了，只剩下 b 中的字母按键和所有的数字和符号案件能用，同时 shift 键是好

     的，所以可以切换大小写。问 a 中的单词有几个可以用当前坏掉的键盘打出来。
     */

    public static int brokenKey(String s, char[] letter){
        if (letter.length==0 || s.length()==0) return 0;
        int res =0;
        HashSet<Character> set = new HashSet<Character>();
        for (char l : letter){
            set.add(l);
        }

        String[] newList = s.split("\\W");
        for (String i: newList){
            if (i.length()!=0){
                i = i.toLowerCase();
                boolean ext = true;
                for (int j = 0;j<i.length();j++){
                    if (!set.contains(i.charAt(j))){
                        ext = false;
                        break;
                    }
                }
                if (ext) res++;
            }
        }

        return res;
    }

    /**
     * compare 两个 string，只有小写字母。
     * If two strings are close enough.

     Given two rules to define two strings are close enough.

     1. you can swap neighbor char any times. Ex. "abb" -> "bba"

     2. If two strings have the same character, then you can change the character into

     another.

     Ex. If both strings contain "a" and "b", you can change all "a"s in the first string or

     change all "b"s in the first string. same as the second string

     Ex.

     Input: S1 = "babzccc", S2 = "abbzczz"

     Output: True
     * @param
     */
    public static boolean compFreq (String a, String b){
        if (a.length() != b.length() || a.length() == 0) return false;
        boolean res = true;
        a = a.toLowerCase();
        b = b.toLowerCase();
        HashMap<Character,Integer> st1 = new HashMap<>();
        HashMap<Character,Integer> st2 = new HashMap<>();
        List<Integer> ma = new ArrayList<Integer>();
        List<Integer> mb = new ArrayList<Integer>();
        for (int i = 0; i<a.length();i++){
            st1.put(a.charAt(i), st1.getOrDefault(a.charAt(i),0)+1);
            st2.put(a.charAt(i), st2.getOrDefault(a.charAt(i), 0)+1);
        }

        if (!st1.keySet().equals(st2.keySet()))
            res = false;
        for (char h: st1.keySet()){
            ma.add(st1.get(h));
        }
        // todo: keyset is sorted one!!!   values() only return object!-use get()
        for (char h: st2.keySet()){
            mb.add(st2.get(h));
        }
        if (!ma.equals(mb))
            res = false;
        //System.out.print(st1.values());


        return res;
    }


    boolean replaceSameFrequency(String a, String b) {
        if (a.length() != b.length())
            return false;
        HashMap<Character, Integer> mapA = new HashMap();
        HashMap<Character, Integer> mapB = new HashMap();
        char[] aChar = a.toCharArray();
        char[] bChar = b.toCharArray();

        List<Integer> listA = new ArrayList();
        List<Integer> listB = new ArrayList();

        HashSet<Character> ha = new HashSet();
        HashSet<Character> hb = new HashSet();

        for (int i = 0; i < aChar.length; i++) {
            mapA.put(aChar[i], mapA.getOrDefault(aChar, 0) + 1);
            ha.add(aChar[i]);
            mapB.put(bChar[i], mapB.getOrDefault(bChar, 0) + 1);
            hb.add(bChar[i]);
        }
        if (!ha.equals(hb))
            return false;

        for (char ma : mapA.keySet()) {
            listA.add(mapA.get(ma));
        }
        for (char mb : mapB.keySet()) {
            listB.add(mapB.get(mb));
        }
        if (listA.equals(listB))
            return true;
        return false;
    }

    /**
     * Input:

     a = [1, 2, 3]

     b = [3, 4]

     query = [[1, 5], [1, 1 , 1], [1, 5]]

     Output:

     [2, 1]
     * @param
     */
    public static List<Integer> coolFeature (int[] a, int[] b, int[][] query){
        List<Integer> res = new ArrayList<>();
        //todo: when want find 2 object in 2 array--- set an array as hashset for search, hashmap for duplication!
        HashMap<Integer,Integer> mapA = new HashMap();
        // todo: aware that duplication in a!
        for (int m :a){
            mapA.put(m, mapA.getOrDefault(m,0)+1);
        }
        // traversal the query
        for (int[] mquery : query){
            if (mquery.length ==3){
                b[mquery[1]-1] = mquery[2];
            }else if(mquery.length == 2){
                int tar = mquery[1];
                int add = 0;
                for (int mb: b){
                    if (mapA.containsKey(tar - mb)) add += mapA.get(tar - mb);
                }
                res.add(add);
            }
        }

        return res;

    }


    /**
     * Find how many numbers have even digit in a list.

     Ex.Input: A = [12, 3, 5, 3456]

     Output: 2
     * @param
     */
    public static int findEven(int[] a){
        int res = 0;
        if (a.length == 0) return 0;
        for (int i = 0; i<a.length;i++){
            int m = a[i];
            while (m!= 0){
                int b = m%10;
                if (b%2==0)res++;
                m = m/10;
            }
        }
        return res;
    }

    /**
     * 6. Find the most common elements in a list.

     Ex.

     Input: A = [2, 2, 3, 3, 5]

     Output: [2, 3]

     // using hashmap and max count
     *
     */
//    public static int[] findMax(int[] a){
//
//    }

    /**
     * Maximum size of ribbon

     Given a list representing the length of ribbon, and the target number "k" parts of

     ribbon. we want to cut ribbon into k parts with the same size, at the same time we want

     the maximum size.

     Ex.

     Input: A = [1, 2, 3, 4, 9], k = 5

     Output: 3
     * @param
     */
    public static int ribbon(int[] a, int k){
        //Use binary search to find the size of the ribbon to reach the time limit.
        int res = 0;
        int len = 0, low = 0;
        for (int i :a){
            len = Math.max(i,len);
        }
        while (low<=len){
            res = 0;
            int mid = (low+len)/2;
            for (int i:a){
                res += i/mid;
            }
            if (res>=k){
                low = mid+1;
                res = Math.max(res,mid);
            }else if(res<k){
                len = mid-1;
            }
        }
        return res;
    }

    /**
     * 8.GoodTuples

     Give an array and find the count of a pair number and a single number combination

     in a row of this array. Target array is a[i - 1], a, a[i + 1]

     Example：

     Input: a = [1, 1, 2, 1, 5, 3, 2, 3]

     Output: 3

     Explain:

     [1, 1, 2] -> two 1 and one 2(O)

     [1, 2, 1] -> two 1 and one 2(O)

     [2, 1, 5] -> one 2, one 1 and one five(X)

     [1, 5, 3] -> (X)

     [5, 3, 2] -> (X)

     [3, 2, 3] -> (O)
     * @param
     */

    public static int goodTuple(int[] a){
        int res = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i =1; i<a.length -1; i++){
            //todo: use hashset
            set.add(a[i-1]);
            set.add(a[i]);
            set.add(a[i+1]);
            if (set.size() == 2)
                res++;
            set.remove(a[i-1]);
            set.remove(a[i]);
            set.remove(a[i+1]);
            //todo: use compare without Hashset
            //if((a[i-1]==a[i+1] && a[i]!= a[i+1]) || (a[i]==a[i+1] && a[i-1]!= a[i+1]) || (a[i-1]==a[i] && a[i]!= a[i+1]))
        }


        return res;
    }


    public static void rotateA(int[][] matrix, int count) {
        int n = matrix.length;
        for (int k = 0; k < count; k++) {
            for (int i = 0; i < (n + 1) / 2; i++) {
                for (int j = 0; j < n / 2; j++) {
                    if (i == j) {
                        continue;
                    }
                    int temp = matrix[n - j - 1][i];
                    matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                    matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                    matrix[j][n - i - 1] = matrix[i][j];
                    matrix[i][j] = temp;
                }
            }
            System.out.println(k);
            for (int i = 0; i<n ;i++){
                for (int j = 0;j<n;j++){
                    System.out.print(matrix[i][j]);
                }
                System.out.print('\n');
            }

        }

    }
    public static void rotate(int[][] matrix, int count) {
        int n = matrix.length;
        for (int k = 0; k < count%4; k++) {
            int[][]  oldM= matrix;
            for (int i = 0; i<n ;i++){
                for (int j = 0;j<n;j++){
                    System.out.print(oldM[i][j]);
                }
                System.out.print('\n');
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <n; j++) {
                    if (i == j || (i+j== n-1)) {
                        continue;
                    }
                    matrix[i][j] = oldM[n-j-1][i];
                }
            }
            System.out.println(k);

            System.out.println(k);
            for (int i = 0; i<n ;i++){
                for (int j = 0;j<n;j++){
                    System.out.print(matrix[i][j]);
                }
                System.out.print('\n');
            }

        }

    }

    /**
     * maxArithmeticLength

     Suppose we have array a and b (no duplicates & sorted)

     a = [0,4,8,20]

     b = [5,7,12,16,22]

     Suppose u can pick any number of element from b (could be 0), and u want to insert

     them into array a such that all elements in a are increasing by certain number,

     so in this example u can pick "12, 16" from b and append into a such that a =

     [0,4,8,12,16,20], which increase by 4 for each element

     write a function to return the maximum number of element in a after appending

     elements from b (in the exmaple above the result is 6), if there is no such case, return

     -1
     * @param
     */
    public static int maxArithmeticLength(int[] a, int[] b){
        Set<Integer> gap = new HashSet<>();
        int max = -1;
        if (a.length ==1){
            gap.add(a[0]);
        }else {
            int g = a[1]- a[0];
            for (int i=1;i<= g;i++){
                gap.add(i);
            }
        }

        // todo； use pointer to add a, b values to array

        for (int g: gap){
            ArrayList<Integer> list = new ArrayList<>();
            int ap = 1;
            int bp = 0;
            int cur = a[0];
            list.add(cur);
            while (ap<a.length && bp<b.length){
                //add a[] into list
                if((a[ap]-g)==cur ){
                    list.add(a[ap]);
                    cur = a[ap];
                    ap++;
                }else if (cur==b[bp] -g){
                    list.add(b[bp]);
                    cur = b[bp];
                    bp++;
                }else bp++;

            }

            while (ap<a.length){
                if (cur == a[ap]- g){
                    list.add(a[ap]);
                    cur = a[ap];
                    ap++;
                }else break;
            }
            while (bp<b.length){
                if (cur == b[bp] -g){
                    list.add(b[bp]);
                    cur = b[bp];
                }
                bp++;
            }

            //add element in front of a[0]
            // add_rev_element - my first element is always A[0], so any number less than
            // that to be searched in B
            Set<Integer> bset = new HashSet<>();
            for (int b_ele : b){
                if (b_ele<a[0]){
                    bset.add(b_ele);
                }
            }
            int add  = a[0]-g;
            while (add> 0) {
                if (bset.contains(add)) {
                    list.add(add);
                    bset.remove(add);
                    add -=g;
                } else {
                    break;
                }
            }
            if (ap<a.length){
                max = Math.max(max, -1);
            }else {
                max = Math.max(max, list.size());
            }
        }
        return max;
    }

    public static int axArithmeticLength(int[] a, int[] b) {
        Set<Integer> ap = new HashSet<>();
        int max_count = -1;

        // checking which difference have to be checked for AP
        if (a.length == 1) {
            ap.add(a[0]);
        } else {
            int diff = a[1] - a[0]; // TLE
            for (int i = 1; i <= diff; i++) {
                ap.add(i);
            }
        }

        for (int ap_val : ap) {
            List<Integer> answer = new ArrayList<>();
            int a_pointer = 1;
            int b_pointer = 0;
            int current_value = a[0];
            answer.add(current_value);

            while (a_pointer < a.length && b_pointer < b.length) {
                if (a[a_pointer] - current_value == ap_val) {
                    answer.add(a[a_pointer]);
                    current_value = a[a_pointer];
                    a_pointer++;
                } else if (b[b_pointer] - current_value == ap_val) {
                    answer.add(b[b_pointer]);
                    current_value = b[b_pointer];
                    b_pointer++;
                } else {
                    b_pointer++;
                }
            }

            // if elements of a are left
            while (a_pointer < a.length) {
                if (a[a_pointer] - current_value == ap_val) {
                    answer.add(a[a_pointer]);
                    current_value = a[a_pointer];
                    a_pointer++;
                } else {
                    break;
                }
            }

            // if elements of b are left
            while (b_pointer < b.length) {
                if (b[b_pointer] - current_value == ap_val) {
                    answer.add(b[b_pointer]);
                    current_value = b[b_pointer];
                }
                b_pointer++;
            }

            // add_rev_element - my first element is always A[0], so any number less than
            // that to be searched in B
            int pointer = a[0];
            Set<Integer> bset = new HashSet<>();
            for (int b_ele : b)
                bset.add(b_ele);
            while (pointer - ap_val > 0) {
                int neg_sum = pointer - ap_val;

                if (bset.contains(neg_sum)) {
                    answer.add(neg_sum);
                    pointer = neg_sum;
                } else {
                    break;
                }
            }

            if (a_pointer < a.length) {
                max_count = Math.max(max_count, -1);
            } else {
                max_count = Math.max(max_count, answer.size());
            }
        }

        return max_count;
    }

    /**
     * divisorSubstrings

     Give a number
     and digit number
     find all serial substring is able to divisible n.
     Input: n = 120, k = 2
     Output: 2
     * @param
     */
    public static int divisor(int n, int k){
        int res = 0;
        int a = n;
        StringBuffer s = new StringBuffer("");
        int i = 1;
        while(a>0){
            i *=10;
            s.insert(0,a%i);
            a = a/i;
        }
        for (int j =0 ;j< s.length()-k+1;j++){
            int div = 0;
            for (int m =0;m<k; m++){
                div = div *10 +(s.charAt(m+j)-'0');
            }
            if (n%div==0) res++;
        }
        return res;

    }

    //sum of string
    public static int sumup(String a, String b){
        StringBuffer res = new StringBuffer("");
        int alen = a.length()-1;
        int blen = b.length()-1;
        while (alen>=0 && blen>=0){
            int out = (a.charAt(alen)-'0') +(b.charAt(blen)- '0');
            res.insert(0,out);
            alen--;
            blen--;
            if (blen<0 || alen<0){
                 res.insert(0, (blen<0)? a.charAt(alen)-'0':b.charAt(blen)-'0');
            }
        }
        return Integer.parseInt(res.toString());
    }


    /**13
     * 给一个 array 和一个 matrix。

     matrix 里面每一个 vector<int>的形式必定是[l,r,target]，固定只有 3 个数。

     然后要求统计 array 里 index 从 l 到 r 这个区间出现了多少次 target 这个数。

     比如：array = [1,1,2,3,2]
     matrix = [[1,2,1],
     [2,4,2],
     [0,3,1]]
     output : 5
     * @param
     */
    public static int searchIndex(List<Integer> array, List<List<Integer>> matrix){
        int res = 0;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i =0 ;i<array.size();i++){
            if (map.containsKey(array.get(i))){
                map.get(array.get(i)).add(i);
            }else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(array.get(i), list);
            }
        }

        for (List<Integer> query: matrix){
            if (map.containsKey(query.get(2))){
                List<Integer> m = map.get(query.get(2));
                for (int s: m){
                    if (s<=query.get(1) && s>=query.get(0)){
                        res++;
                    }
                }
            }
        }

        return res;
    }

    /**
     * 给 2D array, 斜的(方向从左上到右下)为一列做 sorted

     ex :

     4, 5, 3

     2, 1, 3

     3, 2, 1

     =>

     1, 3, 5

     2, 1, 3

     2, 3, 4

     ex:

     1, 3, 9, 4

     1, 3, 7, 4

     9, 5, 7, 7

     =>

     2, 2, 7, 9
     * @param m
     * @return
     */
    static int[][] sortDiagonal(int[][] m) {
        int ROW = m.length;
        int COL = m[0].length;

        for (int line = 1; line <= (ROW + COL - 1); line++) {
            int start_col = Math.max(0, COL - line);
            int count = line < ROW ? line : ROW + COL - line;

            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for (int j = 0; j < count; j++) {
                pq.offer(m[Math.max(0, line - ROW) + j][start_col + j]);
            }
            for (int j = 0; j < count; j++) {
                m[Math.max(0, line - ROW) + j][start_col + j] = pq.poll();
            }
        }
        return m;
    }


    // Returns largest subarray with equal number of 0s and 1s
    int maxLen(int arr[], int n) {
        // Creates an empty hashMap hM
        HashMap<Integer, Integer> hM = new HashMap<Integer, Integer>();
        int sum = 0;     // Initialize sum of elements
        int max_len = 0; // Initialize result
        int ending_index = -1;
        int start_index = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == 0) ? -1 : 1;
        }

        // Traverse through the given array
        for (int i = 0; i < n; i++) {
            // Add current element to sum
            sum += arr[i];
            // To handle sum=0 at last index
            if (sum == 0) {
                max_len = i + 1;
                ending_index = i;
            }

            // If this sum is seen before, then update max_len
            // if required
            if (hM.containsKey(sum + n)) {
                if (max_len < i - hM.get(sum + n)) {
                    max_len = i - hM.get(sum + n);
                    ending_index = i;
                }
            }
            else // Else put this sum in hash table
                hM.put(sum + n, i);
        }

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i] == -1) ? 0 : 1;
        }

        int end = ending_index - max_len + 1;
        System.out.println(end + " to " + ending_index);

        return max_len;
    }

    public static void main(String arg[]){
//        String s = "@%Hello, my# -+dear$ friend!!*()";
//        //String[] m = s.split("\\W");
//        //s = "HelloMy@#$%".toLowerCase();
//        char[] b = {'h', 'e', 'l', 'o', 'm'};
//        //brokenKey(s,b);
//        compFreq("babzccc", "abbzczz");

//        int[] a = {1, 2, 3};
//        int[] b = {3, 4};
//        int[][] query = {{1, 5}, {1, 1 , 1}, {1, 5}};
//        System.out.println(coolFeature(a, b, query));
//        System.out.print(findEven(new int[]{12,3,456,223}));

//        7.ribbon
//        int[] array = { 1, 2, 3, 4, 9 };
//        int parts = 5;
//        System.out.println(ribbon(array, parts));

        //8.tupe
        //System.out.print(goodTuple(new int[]{1, 1, 2, 1, 5, 3, 2, 3}));
//        int[][] m = {{1,2,3,4,5},
//
//                {6,7,8,9,10},
//
//                {11,12,13,14,15},
//
//                {16,17,18,19,20},
//
//                {21,22,23,24,25}};
//        int[][] n = {{1,2,3},{4,5,6},{7,8,9}};
//        rotate(n, 3);

//        int[] a = { 0, 4, 8, 16 };
//        int[] b = { 0, 2, 6, 12, 14, 20 };
//        System.out.println(maxArithmeticLength(a, b) );//6
//
//        a = new int[] { 5, 7, 13, 14 };
//        b = new int[] { 9, 11, 15 };
//        System.out.println(maxArithmeticLength(a, b));//-1
//
//        a = new int[] { 20, 22 };
//        b = new int[] { 19, 21, 23, 24, 26, 28 };
//        System.out.println(maxArithmeticLength(a, b) );//== 6
//
//        a = new int[] { 179, 335, 647, 699, 959, 1011, 1635, 2051, 2103, 2415, 2623 };
//        b = new int[] { 2, 12, 24, 27, 45, 53, 55, 74, 82, 87, 95, 111, 117, 119, 120, 123, 127, 128, 129, 138, 160,
//                168, 176, 198, 199, 224, 229, 231, 263, 283, 300, 308, 319, 322, 340, 341, 353, 387, 411, 415, 429, 438,
//                439, 443, 446, 466, 468, 491, 518, 525, 531, 539, 543, 569, 570, 587, 594, 595, 751, 803, 855, 907,
//                1063, 1115, 1167, 1219, 1271, 1323, 1375, 1427, 1479, 1531, 1583, 1687, 1739, 1791, 1843, 1895, 1947,
//                1999, 2155, 2207, 2259, 2311, 2363, 2467, 2519, 2571 };
//        System.out.println(maxArithmeticLength(a, b));// == 49
//
//        a = new int[] { 7, 13 };
//        b = new int[] { 1, 10, 16 };
//        System.out.println(maxArithmeticLength(a, b));//4
//
//        a = new int[] { 20, 22 };
//        b = new int[] { 19, 21, 23, 24, 26, 28 };
//        System.out.println(maxArithmeticLength(a, b));//6
//        System.out.println(divisor(120,2));//6
//        System.out.println(sumup("234","67"));
//        int[] arra = {1,1,2,3,2};
//        List<Integer> array = new ArrayList<Integer>(arra.length);
//        int[][] matrix = {{1,2,1}, {2,4,2}, {0,3,1}};
//
//
//        System.out.println(sumup("234","67"));
        PriorityQueue<String> pQueue =
                new PriorityQueue<String>();

        // Adding items to the pQueue using add()
        //todo: PriorityQueue--Heap Data Structures and Heap has O(log(n))
        //check if a particular element is present in the queue, have leaner time complexity i.e. O(n).
//        pQueue.add("Java");
//        pQueue.add("C");
//        pQueue.add("Python");
//        pQueue.add("C++");
//
//        // Printing all elements
//        System.out.println("The queue elements:");
//        Iterator itr = pQueue.iterator();
//        while (itr.hasNext())
//            System.out.println(itr.next());

        int[][] test = {{8, 4, 1}, {4, 4, 1}, {4, 8, 9}};

        sortDiagonal(test);

        for (int i = 0; i < test.length; i++) {
            for (int j = 0; j < test[0].length; j++) {
                System.out.print(test[i][j]);
                System.out.print(" ");
            }
            System.out.print("\n");
        }

    }
}
