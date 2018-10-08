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

        long m;
        m = n/5;
        return m;
    }
   /* Thoughts:
    Attempt1:
    Can this problem be converted to : how many 10's to I have?
    Loop through n, and check how many 2s, 5s do we have.
    For each i, do while loop and count the number of 2s, and 5s in that particular i.
            Note:
            5 and 2 makes 10. So don't worry about 10.
    Some values will be checked redundantly, so record the ones checked, return the hash value directly.
    Attempt2:
    Don't even need to worry about 2's because 2 is definitely more than 5's. Only need to care about 5's.
    How many 5's? n/5.   loop (1 ~ n)
    However, some number within (1 ~ n) may give more 5's, which for example is: 25 = 5 * 5, double 5's. And 125 = triple 5's.
    In fact count = n / 5 + n / 25 + n / 125 + ....
            */

    public static void main(String[] args) {
        System.out.println(trailingZeros(11));

    }
}
