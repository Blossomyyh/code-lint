import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    /**
     *
     * @param
     * @param
     * @return
     *
     * Input: a = 1, b = 2 Output: 3
     *
     * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
     *
     *
     *
     * ****
     * ＆ AND; 与可以显示进位和<<一起
     * | OR ;
     * ^ XOR如果相对应位值相同，则结果为0，否则为1---可看做是相加但是不显现进位;
     * 〜反位;
     * << 按位左移运算符;
     * >>> 按位右移补零操作符。左操作数的值按右操作数指定的位数右移，移动得到的空位以零填充。
     */

    public int getSum(int a, int b){
        int res = 0;


        return res;
    }

    public static int getSumBit(int a, int b){
        /**
         * Binary of 12 = 00001100

         Binary of 20 = 00010100

         Now a|b=12|20=00011100 which is 28 in decimal.

         In OR Only combination of 0 will 0 otherwise it's 1 always like 0 and 0 = 0, 1 and 0 = 1 , …..

         Similarly & is bitwise and operator here combination of 1 will 1 otherwise zero.

         E.g. 1 and 1 = 1 , 1 and 0 = 0…

         Taking old values a&b = 00000100 wich is 4 in decimal

         In case of XOR that is a^b even combination and Zero combination will zero otherwise 1

         00001100

         00010100

         00011000 which is XOR of above binaries.

         Means a^b = 00011000 which is 24 in decimal
         */
        if(b==0){
            return a;
        }
        int s1 = a ^ b;
        //异或这里可看做是相加但是不显现进位，比如5 ^ 3
                 /*0 1 0 1
                   0 0 1 1
                 ------------
                   0 1 1 0
              上面的如果看成传统的加法，不就是1+1=2，进1得0，但是这里没有显示进位出来，仅是相加，0+1或者是1+0都不用进位*/
        int s2 = (a & b) << 1;


        //相与为了让进位显现出来，比如5 & 3
                /* 0 1 0 1
                   0 0 1 1
                 ------------
                   0 0 0 1
              上面的最低位1和1相与得1，而在二进制加法中，这里1+1也应该是要进位的，所以刚好吻合，但是这个进位1应该要再往前一位，所以左移一位*/
        //经过上面这两步，如果进位不等于0，那么就是说还要把进位给加上去，所以用了尾递归，一直递归到进位是0。
        return getSumBit(s1,s2);

        /*首先分析情况，不让用+-符号，就是要实现+-操作符。
        二进制的加法，每一位分四种情况，1+1:进位，原位放0；1+0:不进位，原位放1；0+1:不进位，原位放1；0+0:不进位，原位放0。
        逻辑产生：只有1+1的前一位，需要进位；该位数字不一样的话，放1，一样的话，放0。
        代码块产生：需要进位的值为int step = a & b; step <<= 1;原位存放为：int unit = a ^ b;
        迭代：算出一步后，仍需进行下一次的step与unit相加，直到不需要进位。
        */
    }

    /**
     *     int getSum(int a, int b) {
     int sum;
     int carry;
     if(a==0) return b;
     if(b==0) return a;
     carry=a&b;
     sum=a^b;
     while(carry){
     int temp=sum;
     carry=carry&(INT_MAX); //最高位为1即负数左移会报错, 使carry最高位永远为0
     sum=sum^(carry<<1);
     carry=temp&(carry<<1);
     }
     return sum;
     * @param
     */

    // brute force
    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for(int i = 0; i< nums.length; i++){
            for (int j = i; j< nums.length; j++){
                if ((i+j) == target) {
                    res[0] = i;
                    res[1] = j;
                    break;
                }
            }
        }
        return res;
    }

    //one pass on HashTable map
    public int[] twoHSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }


    public static void main(String arg[]){

        //System.out.print(getSumBit(3,-1));
        int[] n = {2,7,9};
        int[] res = twoSum(n,9);

    }
}
