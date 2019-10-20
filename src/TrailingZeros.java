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

    public static int solution(int N) {
        // write your code in Java SE 8
        //first transfer the N to int[]
        int m = Math.abs(N);
        boolean in = false;
        StringBuffer s = new StringBuffer("");
        int k = 10;
        while(m!=0){

            s.insert(0,m%k);
            m = m/k;
        }
        if(N==0) return 50;
        else if(N>0){
            for(int i = 0;i<s.length(); i++){
                if(s.charAt(i)<='5'){
                    s.insert(i,5);
                    in = true;
                    break;
                }
            }
            if(!in){
                s.insert(s.length(),5);
            }
        }else if(N<0){
            for(int i = 0;i<s.length(); i++){
                if(s.charAt(i)>'5'){
                    s.insert(i,5);
                    break;
                }
            }
        }

        return Integer.parseInt(s.toString());
    }

    public static void main(String[] args) {
        //trailingZeros(25);
//        System.out.println();
        int a = solution(-78);

    }
}
