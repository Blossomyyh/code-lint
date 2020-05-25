import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class meituan {

    public static void main(String[] args){
//        Scanner sc  = new Scanner(System.in);
//        // read numbers
//        String s = new String();
//        if(sc.hasNextLine()){
//             s= sc.nextLine();
//        }
//        // construct map
//        Map<Integer,Integer> map = new HashMap<>();
//        int n = 0;
//        while(sc.hasNextInt()){
//            n++;
//            int m = sc.nextInt();
//            map.put(n,m);
//        }
//        // return
//        for(char c: s.toCharArray()){
//            System.out.print(map.get(c-'0'));
//        }
//
//        int res = 4;
//        double square = Math.PI * res;
//        DecimalFormat df = new DecimalFormat("0.00000");
//        System.out.print(df.format(square));
        Scanner sc  = new Scanner(System.in);
        // read numbers
        int res = 0;
        int n = 0;
        if(sc.hasNextInt()){
            n = sc.nextInt();
        }
        int a = 1;
        if(n%2==0){
            a = -a;
        }
        for(int i =0;i<n;i++){
            int m = sc.nextInt();
            res += a*m*m;
        }
        double square = Math.PI *(double)res;
        DecimalFormat df = new DecimalFormat("0.00000");
        System.out.print(df.format(square));

    }
}
