import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MajorityNumber {

    /**
     * Given an array of size n, find the majority element.
     * The majority element is the element that appears more than ⌊ n/2 ⌋ times.
     *
     * Hashmap function -- O(n) O(k)
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for(int m:nums){
            map.put(m, map.getOrDefault(m,0)+1);
        }
        for(int m: map.keySet()){
            if(map.get(m)>nums.length/2) res= m;
        }
        return res;
    }


    /**
     * Sorting
     * time O(nlogn) O(1)
     *
     * if the elements are sorted in monotonically increasing (or decreasing) order,
     * the majority element can be found at index
     * n/2
     */
    public static int majoritySElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    /**
     * divide and conquer
     * @param args
     */


    public static void main(String args[]){

    }
}
