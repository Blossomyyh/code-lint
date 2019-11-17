public class compress {
    public static String compress(String s){
        StringBuffer res = new StringBuffer();
        char[] list = s.toCharArray();
        char a=s.charAt(0);
        int fre = 1;
        for (int i  =1;i<s.length();i++){
            char c = s.charAt(i);
            if (c!=a){
                //add to string
                res.append(a);
                res.append(fre);


                a = c;
                fre =1;
            }else if(c==a){
                fre++;
            }
        }
        //todo at last
        res.append(a);
        res.append(fre);
        return res.toString();
    }


    public static void main(String args[]){
        compress("aavvdccc");
    }
}
