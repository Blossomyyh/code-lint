import com.sun.javafx.collections.VetoableListDecorator;

import java.sql.Array;
import java.util.*;

//not good brute force
public class sum3 {
    public static List<List<Integer>> sumthree(int[] nums){
        ArrayList<List<Integer>> listRes = new ArrayList<>();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        for (int i=0; i<nums.length; i++){
            for (int j = i+1; j<nums.length;j++){
                ArrayList<Integer> put = new ArrayList<>();
                put.add(i);
                put.add(j);
                map.put(nums[i]+nums[j], put);
            }
        }
        HashSet<Integer> n = new HashSet<Integer>();
        for (int k = 0;k<nums.length;k++){
            n.add(k);
        }
        for (int m = 0;m<nums.length; m++){
            if (map.containsKey(0-nums[m])){
                List<Integer> plus = map.get(0-nums[m]);
                if (!plus.contains(m) ){
                    ArrayList<Integer> res = new ArrayList<>(nums[plus.get(0)]);
                    res.add(nums[plus.get(1)]);
                }
            }
        }
        return listRes;
    }

    public static List<List<Integer>> sumup(int[] nums){
        ArrayList<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0;
        for (i =0;i<nums.length -2 ;i++){
            int j = i+1; int k = nums.length-1;
            int rest = 0-nums[i];
            while (j<k && k<nums.length){
                if (nums[j]+nums[k] < rest){
                    j = increase(nums, j);
                } else if(nums[j]+nums[k] == rest){
                    ArrayList<Integer> arr = new ArrayList<>();
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(nums[k]);
                    list.add(arr);
                    //result.add(Arrays.asList(nums[i], nums[head], nums[tail]));
                    k = decrease(nums, k);
                } else if (nums[j]+nums[k] > rest){
                    j = increase(nums,j);
                }
            }

        }
        return list;

    }
    private static int increase(int[] num, int a){
        while (num[a]==num[a+1] && a<num.length -1) a++;
        return ++a;
    }
    private static int decrease(int[] num, int a){
        while (num[a]==num[a-1] && a>=1) a--;
        return --a;
    }

}
