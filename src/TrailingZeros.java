public class TrailingZeros {
    /*
 * @param n: An integer
 * @return: An integer, denote the number of trailing zeros in n!
 */
    public static long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        /*
        Don't even need to worry about 2's because 2 is definitely more than 5's. Only need to care about 5's.
How many 5's? n/5.   loop (1 ~ n)
However, some number within (1 ~ n) may give more 5's, which for example is: 25 = 5 * 5, double 5's. And 125 = triple 5's.
In fact count = n / 5 + n / 25 + n / 125 + ....
        */

        int count  = 0;
        for (long m =5 ; m <= n; m=m*5){
            count+= n/m;
        }
        return count;
    }

    public static void main(String[] args) {
        trailingZeros(25);
//        System.out.println();

    }
}
