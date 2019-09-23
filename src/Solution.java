import java.util.ArrayList;
import java.util.Collections;

public class Solution {

   public  static String mergeStrings(String a, String b) {
        int len = Math.min(a.length(), b.length());
        String res = new String();
        for(int i =0; i<len; i++){
            res = res + Character.toString(a.charAt(i));
            res = res + Character.toString(b.charAt(i));
        }
        //System.out.println(res);
        if(len == a.length()){
            res = res.concat(b.substring(len));
        } else if(len == b.length()){
            res = res.concat(a.substring(len));
        }
        return res;
    }


    public static void main (String args[]){
//        mergeStrings("adv", "sd");
        int x=0;
        for(int i=0;i<10000000; i++){
            x++;
        }
    }
}


//public static long pthFactor(long n, long p) {
//// Write your code here
//ArrayList<Long> list = new ArrayList<Long>();
//    long i =1;
//        while(i <= Math.sqrt(n)){
//                if(n%i == 0){
//                if(n/i != i){
//                list.add(i);
//                list.add(n/i);
//                } else {
//                list.add(i);
//                }
//                }
//                i++;
//                }
//                //
//                //System.out.print(list);
//                Collections.sort(list);
//                list.size();
//                if(p <= list.size()){
//
//                long m =list.get((int)p -1);
//                return m;
//                } else {
//                return 0;
//                }
//                }
//
//                }