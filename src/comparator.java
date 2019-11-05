import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class comparator {
//    public static String[] sorting(int[] m, String[] nums){
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

    /**Comparator
     *  @return a negative integer ---less than
     *          zero --- equal to
     *          a positive integer --- greater than
     *          first </=/> second
     * @param m
     * @param nums
     * @return
     */
    public static void comparaOver(int[] m,String[] nums){
        Arrays.sort(nums, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                StringBuilder sb1 = new StringBuilder(), sb2 = new StringBuilder();
                if(sb1.length()!= sb2.length()) return sb1.length()>sb2.length()? 1:-1;
                else return sb1.toString().compareTo(sb2.toString());

                /** "xx".compareTo("")
                 * returns an int datatype which is based on the lexicographical comparison between two strings.

                 returns < 0 then the String calling the method is lexicographically first
                 returns == 0 then the two strings are lexicographically equivalent
                 returns > 0 then the parameter passed to the compareTo method is lexicographically first.
                 */
            }
        });
    }



}





