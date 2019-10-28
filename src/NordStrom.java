import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class NordStrom {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        BufferedReader in = new BufferedReader(reader);
//        String line;
//        boolean b = true;
//        String res = "";
//        while ((line = in.readLine()) != null) {
//            //if is empty add " "
//            //todo: when the line is empty iii use trim!!!
//            if(line.trim().equals("") && !b){
//                b = true;
//                res += " ";
//            }else if(line != "" && b){
//                // if is the first word - lowercase
//                b=false;
//                res = res+line.toLowerCase();
//            }else if(line != "" && !b){
//                // if is the following word
//                res = res+ line.substring(0,1).toUpperCase();
//                res = res +line.substring(1,line.length()).toLowerCase();
//            }
//        }
//        System.out.println(res);
//
//
//        Scanner sc = new Scanner(System.in);
//        int target = sc.nextInt();
//        System.out.println(target);
//        ArrayList<Integer> list = new ArrayList<>();
//        int i = 0;
//        while(sc.hasNextInt()){
//            list.add(sc.nextInt());
//            i++;
//
//        }



        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
        BufferedReader in = new BufferedReader(reader);
        String line;
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, ArrayList<String>> sort = new HashMap<>();

        boolean start= true;
        while ((line = in.readLine()) != null) {
            String[] s = line.split(":");
            String name = s[0];
            //System.out.println(name);

            String[] ele = s[1].split(",");
            if(start){
                for(int i = 0;i<ele.length;i++){
                    map.put(ele[i],i+1);
                    //System.out.println(ele[i]+" "+(i+1)+" ");
                }
                start = false;
            }else{
                int[] num= new int[ele.length];

                for(int i = 0;i<ele.length;i++){
                    num[i] =map.get(ele[i]);
                }
                int pair=0;
                for(int i= 0;i<ele.length; i++){
                    for(int j =i+1;j<ele.length;j++){
                        if(j<i) pair++;
                    }
                }
                System.out.println(pair);
                if(sort.containsKey(pair)) {
                    sort.get(pair).add(name);
                    Collections.sort(sort.get(pair));
                }else{
                    ArrayList<String> news = new ArrayList<>();
                    news.add(name);
                    sort.put(pair,news);
                }
            }
            //System.out.println(ele);
        }
    }
}