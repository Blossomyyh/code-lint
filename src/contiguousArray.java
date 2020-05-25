import java.util.Arrays;

public class contiguousArray {
    /**
     * time o(N) space o(N)
     * @param nums
     * @return
     */
    public int findMaxLength(int[] nums) {
        int[] arr = new int[2*nums.length+1];
        Arrays.fill(arr, -2);
        arr[nums.length] = -1;
        int max = 0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            count += (nums[i]==0?-1:1);
            if(arr[count+nums.length]>=-1){
                max = Math.max(max,i-arr[count+nums.length]);
            }else{
                arr[count+nums.length]= i;
            }
        }
        return max;
    }



}
