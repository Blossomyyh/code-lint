import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Anagrams {
    /**
     * Created by gouthamvidyapradhan on 25/02/2017.
     * Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.
     * <p>
     * Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.
     * <p>
     * The order of output does not matter.
     * <p>
     * Example 1:
     * <p>
     * Input:
     * s: "cbaebabacd" p: "abc"
     * <p>
     * Output:
     * [0, 6]
     * <p>
     * Explanation:
     * The substring with start index = 0 is "cba", which is an anagram of "abc".
     * The substring with start index = 6 is "bac", which is an anagram of "abc".
     * Example 2:
     * <p>
     * Input:
     * s: "abab" p: "ab"
     * <p>
     * Output:
     * [0, 1, 2]
     * <p>
     * Explanation:
     * The substring with start index = 0 is "ab", which is an anagram of "ab".
     * The substring with start index = 1 is "ba", which is an anagram of "ab".
     * The substring with start index = 2 is "ab", which is an anagram of "ab".
     */

    int[] content = new int[256];
    int[] sub = new int[256];

//    s long string; p short string to compare
    public List<Integer> findAnagram(String p, String s){

        List<Integer> result = new ArrayList<Integer>();
        int pLen = p.length();
        int sLen = s.length();
        if (pLen < sLen) return result;

//        todo: Array has function to fill up a list with String --not static
        Arrays.fill(content, 0 );
        Arrays.fill(sub, 0);

        for (int n = 0; n< pLen; n++){
            sub[s.charAt(n)]++;
            content[p.charAt(n)]++;
        }

//      todo:every step record the number of the hashing element and compare whether they meet the principal

        for (int i = pLen; i<sLen; i++){
            if (compare()){
                result.add(i-pLen);
            }
            content[s.charAt(i)]++;
            content[s.charAt(i-pLen)]--;
        }

//      todo:do not forget the final one
        if (compare())
            result.add(sLen - pLen);

        return result;
    }


    public boolean compare(){
        for (int i = 0; i<sub.length; i++){
            if (content[i] != sub[i]) return false;
        }
        return true;
    }
    public static void main(String[] args){

        return;
    }

}
