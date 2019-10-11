import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class Greedy {
    public int jump(int[] nums) {
//        ArrayList<String> s = new ArrayList<>();
//        s.size();
//        HashMap<String, Integer> m = new HashMap<>();
//        m.size();
//        HashSet<Integer> h = new HashSet<>();
//        h.size();
//        LinkedList<String> l = new LinkedList<>();
//        l.size();
        int curEnd =0, curFar = 0, jump = 0;
        if (nums.length == 1) return 0;
        for(int i = 0; i< nums.length;i++){
            curFar = Math.max(curFar, i+nums[i]);
            if(i==curEnd){
                jump++;
                curEnd = curFar;
                if(curEnd>=nums.length-1) break;
            }
        }
        return jump;
    }

}
