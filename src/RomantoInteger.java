import java.util.HashMap;
import java.util.Map;

public class RomantoInteger {

    //todo left<right -- subtraction; left>=right -- add on

    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('M',1000);
        map.put('D',500);
        map.put('C',100);
        map.put('L',50);
        map.put('X',10);
        map.put('V',5);
        map.put('I',1);


        char[] list = s.toCharArray();
        if(s.length()==1){
            return map.get(list[0]);
        }
        int res = 0;
        for(int i =0 ;i<list.length-1;i++){
            int add = 0;
            if(map.get(list[i])<map.get(list[i+1])){
                while(i<list.length-1 && map.get(list[i])<map.get(list[i+1])){
                    add += map.get(list[i+1])-map.get(list[i]);
                    i++;
                }
                res +=add;
            }else{
                res += map.get(list[i]);
            }
        }
        if(map.get(list[list.length-2])>=map.get(list[list.length-1])){
            res+= map.get(list[list.length-1]);
        }
        return res;
    }


    static Map<String, Integer> values = new HashMap<>();

    static {
        values.put("M", 1000);
        values.put("D", 500);
        values.put("C", 100);
        values.put("L", 50);
        values.put("X", 10);
        values.put("V", 5);
        values.put("I", 1);
    }

    public static int newromanToInt(String s) {

        int sum = 0;
        int i = 0;
        while (i < s.length()) {
            String currentSymbol = s.substring(i, i + 1);
            int currentValue = values.get(currentSymbol);
            int nextValue = 0;
            if (i + 1 < s.length()) {
                String nextSymbol = s.substring(i + 1, i + 2);
                nextValue = values.get(nextSymbol);
            }

            if (currentValue < nextValue) {
                sum += (nextValue - currentValue);
                i += 2;
            }
            else {
                sum += currentValue;
                i += 1;
            }

        }
        return sum;
    }


    public static void main(String arg[]){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double res  = 0;
        res = newromanToInt("ICD");
    }


}
