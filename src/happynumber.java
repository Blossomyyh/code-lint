import java.util.HashSet;
import java.util.Set;

public class happynumber {
    public boolean isHappy(int n){
        Set<Integer> set = new HashSet<>();
        while(n != 1 && !set.contains(n)){
            n = cal(n);
            set.add(n);
        }
        return n==1;
    }

    private int cal(int n) {
        int sum = 0;
        while(n>0){
            int d = n % 10;
            n = n / 10;
            sum += d * d;
        }
        return sum;
    }
}
