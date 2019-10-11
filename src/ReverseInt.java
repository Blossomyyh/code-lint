import java.util.Collections;
import java.util.Objects;

public class ReverseInt {
    //todo: 1. int 0 into consideration 2. dealing with 0 whether in the beginning or in the middle.
    public static int reverse(int x) {
        boolean m = true;
        if (x<0){
            m = false;
        }
        x= Math.abs(x);
        StringBuilder s= new StringBuilder();
        while (x !=0){
            int n = x%10;
            x=(x-n)/10;
            s.append(n);
        }
        //todo: 1. if we need to delete the 0 in the beginning we need to use StringBuilder and dele s[0]! if find == '0'
        //todo: 2. actually we do have Integer.parseInt() to dele 0
//        for (int i = 0; i<s.length(); i++){
//            if (s.charAt(0)== '0'){
//                s.deleteCharAt(0);
//            }else break;
//        }
        return m? Integer.parseInt(s.toString()):(-Integer.parseInt(s.toString()));
        /*Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
        range: [−2^31,  2^31 − 1].
        For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
        */
    }

    public static int res(int x){
        // n used to store the quotient in division, m to store remainder in division

        // todo: it is add numbers -- so we do not need to worry about the -/+
        int rev = 0;
        while(x!= 0){
            int pop = x%10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE/10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE/10 && pop < -8)) return 0;

            rev = rev*10 + pop;
            x = (x-pop)/10;
        }
        return rev;
    }

    public static void main(String args[]){
        System.out.print(Integer.MAX_VALUE +"and "+ Integer.MIN_VALUE);//todo: Integer.MAX_VALUE && Integer.MIN_VALUE 2147483647(2^31) and -2147483648
        int a = reverse(-10300);
    }
}
