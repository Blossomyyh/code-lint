public class CountDigit {

    public static int countDigits(long n){
        int count = 0;
        for (long i = 1; i <= n; i *= 10) {
            count += (n / i + 8) / 10 * i;
            if (n / i % 10 == 1) {
                count += n % i + 1;
            }
        }
            return count;
    }

    public static int countDigit(long n, int k){
//        count for return
//        m for remainder of /10
//        category 1. less than k0  2. between k1-k9  3. more than k+0
        int count = 0;
        long m = n/10 ;
        if (k<0 || k>10){
            return 0;
        } else if (m<k){
            count = (int)m + ((n%10>k)?0: 1);
        } else if (m == k){
            count = (int)(m +n%10) + ((n%10>k)?0: 1);

        } else if (m> k){
            count = (int)(m + 10) + ((n%10<k)?0: 1);
        }
        return count;
    }


    public static void main(String[] args){
        System.out.println(countDigits(30));
        System.out.println(countDigit(30, 2));

//        countDigit(21, 2);
    }
}
