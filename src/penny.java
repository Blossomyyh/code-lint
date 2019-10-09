import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class penny {
    /**
     * Iterate through each line of input.
     */
    public static void main(String[] args) throws IOException {
//        InputStreamReader reader = new InputStreamReader(System.in);
//        BufferedReader in = new BufferedReader(reader);
//
//        try {
//            double purchasePrice = Double.parseDouble(in.readLine());
//            double cash = Double.parseDouble(in.readLine());
//            calculateChange(purchasePrice, cash);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
        calculateChange(8.75, 50);

        String[] splittedInput = ";bcdefbcbebc|abcdebcfgsdf|cbdbesfbcy|1bcdef23423bc32".split(";");
        String pattern = splittedInput[0];
        String blobs = splittedInput[1];
        doSomething(pattern, blobs);
    }


    public static void doSomething(String pattern, String blobs) {
        // Write your code here. Feel free to create more methods and/or classes
        String output = "";
        int outall = 0;
        String[] list = blobs.split("\\|");
        if(blobs == "") return ;
        if(pattern.length() == 0){
            for(String s: list){
                System.out.print(0+"|");
            }
            System.out.print(0);
        }

        for(String s: list){
            int res = 0;
            int m = s.indexOf(pattern);
            while(m>=0){
                res++;
                m = s.indexOf(pattern, m+1);
            }
            output += res +"|";
            outall += res;
        }

        System.out.print(output.substring(0,output.length()-1) + "|" +outall);
    }


    public static void calculateChange(double purchasePrice, double cash) {
        // Access your code here. Feel free to create other classes as required
        String res = "";
        if(purchasePrice == cash) {
            System.out.print("Zero");
            return;
        }else if(purchasePrice> cash || purchasePrice<0 || cash<0){
            System.out.print("ERROR");
            return;
        } else if(purchasePrice < cash){
            Currency[] list = Currency.values();
            double lev = cash - purchasePrice;
            for (Currency one :list){
                int m = (int)(lev/one.getValue());
                lev = lev-m*one.getValue();

                //todo get exact number
                lev = (double) (Math.round(lev * 100)) / 100;
                if(m>0){
                    for(int j = 0;j<m;j++ ) {
                        res = res+ one.getMoney()+", ";
                    }
                }
                if(lev == 0) break;
            }
        }
        System.out.print(res.substring(0,res.length()-2));
    }
}

enum Currency{
    FiftyPounds("Fifty Pounds", 50),TwentyPounds("Twenty Pounds",20),TenPounds("Ten Pounds",10),
    FivePounds("Five Pounds",5),TwoPounds("Two Pounds",2), OnePound("One Pound",1), FiftyPence("Fifty Pence",0.50),
    TwentyPence("Twenty Pence",0.20), TenPence("Ten Pence",0.10),FivePence("Five Pence",0.05),
    TwoPence("Two Pence",0.02),OnePence("One Pence",0.01);

    private String money;
    private Double value;
    Currency(String money, double value){
        this.money = money;
        this.value = value;
    }
    public String getMoney(){
        return money;
    }

    public double getValue(){
        return value;
    }
}