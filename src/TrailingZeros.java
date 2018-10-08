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

        long m = 0, plus = 1;
        int s = 0;
        while (plus <= n){
            s++;
            plus *= 5;
            System.out.println(plus);
            System.out.println(s);

        }
        s--;
        System.out.println(s);

        for (int i = 1; i<=s; i++){
            int ele = (int)Math.pow(5,i);
            m = m + n/ele;
            System.out.println(m);

        }
        return m;
    }


<<<<<<< HEAD
=======
    public long trailingZerosB(long n) {
        if ( n < 5) {
            return 0;
        }
        long count = 0;
        for (long i = 5; n / i != 0; i *= 5) {
            count += n / i;
        }
        return count;
    }

>>>>>>> origin/home
    public static void main(String[] args) {
        System.out.println(trailingZeros(25));

    }
}
