import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class NordStrom {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        boolean b = true;
        String res = "";
        while ((line = in.readLine()) != null) {
            //if is empty add " "
            //todo: when the line is empty iii use trim!!!
            if(line.trim().equals("") && !b){
                b = true;
                res += " ";
            }else if(line != "" && b){
                // if is the first word - lowercase
                b=false;
                res = res+line.toLowerCase();
            }else if(line != "" && !b){
                // if is the following word
                res = res+ line.substring(0,1).toUpperCase();
                res = res +line.substring(1,line.length()).toLowerCase();
            }
        }
        System.out.println(res);
    }
}