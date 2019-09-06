import java.util.*;

public class LongestSubstringWithoutRepeatingCharacters {

    /**
     * Given a string, find the length of the longest substring without repeating characters.

     Example 1:

     Input: "abcabcbb"
     Output: 3
     Explanation: The answer is "abc", with the length of 3.
     * @param s
     * @return
     */


    public static int LengthofLongestString1(String s){
        int max = 0;

        for (int i = 0; i< s.length(); i++){
            for (int j = i+1; j<s.length(); j++){
                if (allunique(i, j, s)){
                    max = Math.max(max, j-i);
                }
            }
        }
        return max;

    }

    private static boolean allunique(int i, int j, String s) {
        HashSet<Character> set = new HashSet<Character>();
        for (int m = i; m< j; m++){
            if (set.contains(s.charAt(m))){
                return false;
            } else {
                set.add(s.charAt(m));
            }
        }
        return true;
    }
    //Time complexity :
   // O(2n)=O(n)
    public int LengthofLongestString2(String s){
        HashSet<Character> set= new HashSet<Character>();
        int res = 0;
        int i = 0;
        int j = 0;
        while (i<s.length() && j< s.length()){
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                res = Math.max(res, j-i);
            } else {
                set.remove(s.charAt(i++));
            }
        }

        return 0;
    }

    //hashmap -
    public static int hashmapLength(String s){
        int res = 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>(); // todo: index[]
        for (int i =0, j =0; j< s.length();j++){
            if (map.containsKey(s.charAt(j))){
                i = Math.max(map.get(s.charAt(j)), i); //
            }
            res = Math.max(j-i, res);  //todo: length should be a-b +1
            map.put(s.charAt(j),j+1);  //todo: index[s.charAt(j)] = j + 1;
            //System.out.print(map.get(s.charAt(j)));
            //If we know that the charset is rather small, we can replace the Map with an integer array as direct access table.
            /**
             * Commonly used tables are:

             int[26] for Letters 'a' - 'z' or 'A' - 'Z'
             int[128] for ASCII
             int[256] for Extended ASCII

             Time complexity :O(n)  O(n). Indexj j will iterate n times.
             Space complexity (HashMap) :O(min(m,n)). Same as the previous approach.
             Space complexity (Table):O(m). m is the size of the charset.
             */
        }

        return res;
    }



    public static void main(String args[]){
        LengthofLongestString1("abcabcbb");
        //----------hashtable -------------------------
        Hashtable<Integer,String> ht=new Hashtable<Integer,String>();
        ht.put(100,"");
        ht.put(101,"Vijay");
        ht.put(102,"Ravi");
        ht.put(103,"Rahul");
        System.out.println("-------------Hash table--------------");
        for (Map.Entry m:ht.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }

        //----------------hashmap--------------------------------
        HashMap<Integer,String> hm=new HashMap<Integer,String>();
        hm.put(100,null);
        hm.put(101,"Vijay");
        hm.put(101,"Vija");// hash map allows null
        hm.put(102,"Ravi");
        hm.put(103,"Rahul");
        System.out.println("-----------Hash map-----------");
        for (Map.Entry m:hm.entrySet()) {
            System.out.println(m.getKey()+" "+m.getValue());
        }

        int[] index = new int[128];
        index['c'] = 3;
       // hashmapLength("aadb");
    }
}
