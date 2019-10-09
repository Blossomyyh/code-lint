import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;

public class blackrock {

        /**
         * Iterate through each line of input.
         */
        public static double square(int a){
            return Math.pow(a,2);
        }

    public static void reverseSpell(String input) {
        // Write your code here.
        String[] list = input.split("\\W");
        input = String.join("",list);
        for(int i = input.length()-1; i>0; i--){
            System.out.print(Character.toLowerCase(input.charAt(i))+"-");
        }
        System.out.print(Character.toLowerCase(input.charAt(0)));
    }

        public static void main(String[] args) throws IOException {
            double m = square(5);
            String a = "14";
            Double.parseDouble(a);
            Integer.parseInt(a);
            String[] list = a.split("\\W");
            a = "".join(list[list.length - 1]);


        }


}
