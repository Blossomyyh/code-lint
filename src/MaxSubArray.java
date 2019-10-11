import java.lang.reflect.Array;
import java.util.Arrays;

public class MaxSubArray {
    public static int maxSubArray(int[] nums) {
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];

        //todo: dynamicly compare curr with currSum for we only return maxsubvalue
        for(int i = 1; i < n; ++i) {
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }

    public static int[] SubArray(int[] nums) {
        //todo: not right -- I need to use dynamic solution!!
        int[] sum =  new int[nums.length];
        int max = 0;
        sum[0] = nums[0];
        for (int i = 1;i<nums.length; i++){
            sum[i] = nums[i] + sum[i-1];
            if (sum[max]<sum[i]){
                max = i;
            }
        }
        int start = max;
        for (int j = 0;j<max;j++){
            if (sum[j]>=0){
                start = j;
                break;
            }
        }
        int[] res = new int[max-start+1];
        for (int m = start; m<=max;m++){
            res[m-start] = nums[m];
        }
        //Arrays.copyOfRange(nums,start, max)
        return res;
    }
    public static void main(String args[]){
        int[] a = {-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray(a);
    }

}
