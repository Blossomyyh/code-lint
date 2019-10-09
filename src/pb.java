import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Objects;

public class pb {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
//        InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//        BufferedReader in = new BufferedReader(reader);
//        String line;
//        while ((line = in.readLine()) != null) {
            matchBenchmark("Vodafone,STOCK,10|Google,STOCK,15:Vodafone,STOCK,15|Vodafone,BOND,10|Google,STOCK,10");
                    //"Vodafone,STOCK,10|Google,STOCK,15|Microsoft,BOND,15:Vodafone,STOCK,15|Google,STOCK,10|Microsoft,BOND,15");
//        }
    }


    public static void matchBenchmark(String input) {
        // Access your code here. Feel free to create other classes as required
        String[] list = input.split(":");
        if(list[0]=="" ||list[1]=="") return;
        String portfolio = list[0];
        String benchmark = list[1];
        String[] plist = portfolio.split("\\|");
        String[] blist = benchmark.split("\\|");


        //init array
        ArrayList<Asset> VP = new ArrayList<>();
        ArrayList<Asset> VB = new ArrayList<Asset>();
        ArrayList<Asset> GP = new ArrayList<Asset>();
        ArrayList<Asset> GB = new ArrayList<Asset>();
        ArrayList<Asset> MP= new ArrayList<Asset>();
        ArrayList<Asset> MB= new ArrayList<Asset>();

        for (String p: plist){
            String[] s = p.split(",");
            Asset a = new Asset(s[0], s[1], Integer.parseInt(s[2]));
            if(p.charAt(0) == 'V'){
                VP.add(a);
            }else if(p.charAt(0) == 'G'){
                GP.add(a);
            }else if(p.charAt(0) == 'M'){
                MP.add(a);
            }
        }
        for (String b: blist){
            String[] s = b.split(",");
            Asset a = new Asset(s[0], s[1], Integer.parseInt(s[2]));
            if(b.charAt(0) == 'V'){
                VB.add(a);
            }else if(b.charAt(0) == 'G'){
                GB.add(a);
            }else if(b.charAt(0) == 'M'){
                MB.add(a);
            }
        }

        //compare
        ArrayList<String> res = new ArrayList<>();
        res = compare(VP, VB, res);
        res = compare(GP, GB, res);
        res = compare(MP, MB, res);

        Comparator compare = Collections.reverseOrder();
        Collections.sort(res,compare);
        for(String r: res){
            System.out.println(r);
        }



    }


    public static ArrayList<String> compare(ArrayList<Asset> a, ArrayList<Asset> b, ArrayList<String> s){
        int abond =0, bbond = 0, astock = 0, bstock = 0;
        String comp = "";
        for (Asset m:a){
            comp = m.getComp();
            if(Objects.equals(m.getType(), "STOCK")) astock = m.getnum();
            else if(Objects.equals(m.getType(), "BOND")) abond = m.getnum();
        }
        for (Asset m:b){
            if(Objects.equals(m.getType(), "STOCK")) bstock = m.getnum();
            else if(Objects.equals(m.getType(), "BOND")) bbond = m.getnum();
        }

        if(astock != bstock){
            if(astock> bstock){
                s.add("SELL,"+ comp +","+"STOCK,"+(astock-bstock));
            }else if (astock<bstock){
                s.add("BUY,"+ comp +","+"STOCK,"+(bstock-astock));
            }
        }
        if(abond != bbond){
            if(abond> bbond){
                s.add("SELL,"+ comp +","+"BOND,"+(abond-bbond));
            }else if (astock<bstock){
                s.add("BUY,"+ comp +","+"BOND,"+(bbond-abond));
            }
        }
        return s;
    }

}

class Asset {
    String comp;
    String type;
    int num;
    Asset(String comp, String type, int num){
        this.comp = comp;
        this.type = type;
        this.num = num;
    }

    String getComp() {
        return comp;
    }

    String getType() {
        return type;
    }

    int getnum() {
        return num;
    }

}
