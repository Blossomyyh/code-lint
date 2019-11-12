import java.util.HashSet;
import java.util.List;
import java.util.Stack;

public class purestorage {

    public static int compute_number_score(int number) {
        char[] num = Integer.toString(number).toCharArray();
        int res = 0,count5 = 0,len=1;
        for(int i = 0;i<num.length;i++){
            if(num[i]=='7'){
                res+=1;
                //System.out.print(res);//
            }
            if(i>0 && num[i]=='5' && num[i-1]=='5'){
                res+=3;
                //System.out.print(res);//
            }
            if((num[i]-'0')%2==0){
                res+=4;
                //System.out.print(res);//
            }

            if(i>0){

                if(num[i]-num[i-1]==-1){
                    len++;
                }else{
                    res+=len*len;
                    len = 1;
                }
            }
            //System.out.print(res);//

        }
        res +=len*len;
        //System.out.print(res);//
        if(number%3==0) res+=2;

        return res;
    }


    public static int check_log_history(List<String> events) {
        if(events.size()==0 ||events==null) return 0;
        HashSet<String> set = new HashSet<>();
        Stack<String> stack = new Stack<>();
        for(int i = 0;i<events.size();i++){
            String[] s = events.get(i).split(" ");
            if(s[0].equals("ACQUIRE")){
                if(set.contains(s[1])){
                    return i+1;
                }
                set.add(s[1]);
                stack.push(s[1]);

            }else{
                //System.out.print(stack.peek() + " ");
                if(!stack.isEmpty()&&stack.peek().equals(s[1])) {
                    set.remove(stack.pop());
                }else{
                    return i+1;
                }
            }
        }
        return stack.isEmpty()? 0:events.size()+1;
    }


}
