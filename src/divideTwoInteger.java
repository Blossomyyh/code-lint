public class divideTwoInteger {
    /**
     * todo: int range: [-2^31, 2^31 -1] !!!
     * @param dividend
     * @param divisor
     * @return
     */


    /**
     * todo: tricks when computing divides
     *
     * a/2 = a>>1  signed right shift operator
     * a*2 = a<<1 signed left shift operator  || double a: == a+a
     *
     *;todo: 2 circumstances
     *
     * 1. a,b range [-2^31+1, 2^31-1]
     *
     * 2. todo-- special case for : a is -2^31 b=-1 --> c = 2^31 out of range return 2^31-1;
     *
     *
     * not acceptable because of time complexity -- o(n) large
     *
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {
        if(dividend==-Math.pow(2,31) && divisor==-1){
            return Integer.MAX_VALUE;
        }
        if(divisor==1) return dividend;
        if(divisor==2) return dividend>>1;


        int neg = 0;
        if(dividend<0){
            neg++;
            dividend = -dividend;
        }
        if(divisor<0){
            neg++;
            divisor = -divisor;
        }

        int sum = 0;
        int i = 0;
        while(sum<=dividend){
            sum+=divisor;
            i++;
        }
        return neg==1? -i+1:i-1;
    }




}
