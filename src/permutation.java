import java.util.*;

public class permutation {
    static Set< String > set = new HashSet< >();
    public static List< String > generatePalindromes(String s) {
        int[] map = new int[128];
        char[] st = new char[s.length() / 2];
        if (!canPermutePalindrome(s, map))
            return new ArrayList< >();
        char ch = 0;
        int k = 0;
        for (int i = 0; i < map.length; i++) {
            if (map[i] % 2 == 1)
                ch = (char) i;
            for (int j = 0; j < map[i] / 2; j++) {
                st[k++] = (char) i;
            }
        }
        permute(st, 0, ch);
        return new ArrayList < String > (set);
    }
    public  static boolean canPermutePalindrome(String s, int[] map) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            map[s.charAt(i)]++;
            if (map[s.charAt(i)] % 2 == 0)
                count--;
            else
                count++;
        }
        return count <= 1;
    }
    public static void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }

    //todo compare all the char in s && reduce the duplicate one with s[l] != s[i]!!!
    static void permute(char[] s, int l, char ch) {
        if (l == s.length) {
            set.add(new String(s) + (ch == 0 ? "" : ch) + new StringBuffer(new String(s)).reverse());
        } else {
            for (int i = l; i < s.length; i++) {
                if (s[l] != s[i] || l == i) {
                    swap(s, l, i);
                    permute(s, l + 1, ch);
                    swap(s, l, i);
                }
            }
        }
    }

    //todo simple permutate
    void simplepermute(char[] s, int l) {
        if (l == s.length) {
            if (canPermutePalindrome(new String(""), new int[128]))
                set.add(new String(s));
        } else {
            for (int i = l; i < s.length; i++) {

                //first need to swap 2
                swap(s, l, i);
                //permute to next step
                simplepermute(s, l + 1);
                //have to put back the swap
                swap(s, l, i);
            }
        }
    }


    /**
     * permute through distinct integer
     * @param nums
     * @return
     */
    public static List<List<Integer>> permute(int[] nums) {
        //unique integer
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> init = new ArrayList<>();
        for (int num : nums)
            init.add(num);
        res = permute(init, 0,nums.length,res);

        return res;
    }

    public static List<List<Integer>> permute(List<Integer> nums, int k,  int n, List<List<Integer>> output){
        if(k==n) output.add(new ArrayList<Integer>(nums));
        for(int i = k;i<n;i++){
            if(!(nums.get(i)==nums.get(k) && i!=k)) {
                Collections.swap(nums, k, i);

                permute(nums, k + 1, n, output);
                //need to put it back!
                Collections.swap(nums, k, i);
            }
        }
        return output;
    }

    /**
     * permute with duplicate integer
     * @param
     */
    public static List<List<Integer>> permuteUnique(int[] nums) {
        //unique integer
        List<List<Integer>> res = new ArrayList<>();
        int[] unum = new int[nums.length];
        int[] fnum = new int[nums.length];
        int[] num = new int[nums.length];
        Map<Integer, Integer> map = new HashMap<>();

        for (int m : nums){
            map.put(m, map.getOrDefault(m,0)+1);
        }
        //Map.Entry<Integer, Integer>   map.entrySet()
        int i = 0;
        for(HashMap.Entry<Integer, Integer> item: map.entrySet()){
            unum[i]=item.getKey();
            fnum[i]=item.getValue();
            i++;
        }



        res = permute(0,num,unum,fnum,res);

        return res;
    }

    public static List<List<Integer>> permute(int h, int[] num, int[] unum,  int[] fnum, List<List<Integer>> output){
        if(h==num.length){
            List<Integer> list = new ArrayList<>();
            for(int n: num) list.add(n);
            output.add(list);
        }else{
            for(int i = 0;i<unum.length;i++){
                if(fnum[i]<1) continue;
                else{
                    num[h] = unum[i];
                    fnum[i]--;
                    permute(h+1,num, unum,fnum, output);
                    //need to put it back!
                    fnum[i]++;
                }
            }
        }

        return output;
    }







    public static void main (String args[]){
        int[] nums= new int[]{2,2,1,1};
//        String s;
//        s.toCharArray();
        permuteUnique(nums);
//        generatePalindromes("aabbccd");
    }
}
