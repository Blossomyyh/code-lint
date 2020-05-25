public class StringtoInt {
    public int myAtoi(String str) {
        StringBuilder s = new StringBuilder();

        for (Character c : str.toCharArray()) {
            if (s.length() == 0 && c == ' ') {
                // Ignore white space before numbers or word
                continue;
            } else if ((c == '-' || c == '+') && s.length() == 0) {
                // Append only one sign
                s.append(c);
            } else if (c != ' ' && Character.isDigit(c)) {
                // Append only valid numbers
                s.append(c);
            } else {
                // If space or letter is encountered break out of loop
                break;
            }

        }

        return convertString(s.toString());
    }

    public int convertString(String s) {
        int result = 0;

        // If string is empty or only contains a sign, skip
        if (!s.isEmpty() && !s.equals("-") && !s.equals("+")) {
            try {
                // Will throw an error if string is large or smaller than possible max/min integer values
                result = Integer.parseInt(s);
            }
            catch(Exception e) {
                if (s.charAt(0) == '-'){
                    result = Integer.MIN_VALUE;
                } else {
                    result = Integer.MAX_VALUE;
                }
            }
        }

        return result;
    }




    public static int atoi(String str) {
        char[] list = str.toCharArray();
        boolean neg = false;
        boolean st= true;
        int res = 0;
        for(int i = 0;i<list.length;i++){
            if(st==true && list[i]=='-'){
                neg = true;
                st = false;
            }
            if(Character.isDigit(list[i])){
                while(i<list.length && Character.isDigit(list[i])){
                        res =res*10 + (list[i]-'0');
                        if(res> Integer.MAX_VALUE && !neg){
                            return Integer.MAX_VALUE;
                        }else if(res>Integer.MIN_VALUE && neg){
                            return Integer.MIN_VALUE;
                        }


                    i++;
                }
                break;
            }
        }

        return neg? 0-res: res;

    }

    public static int mAtoi(String str) {
        char[] list = str.toCharArray();
        boolean neg = false;
        boolean st= true;
        int res = 0;
        for(int i = 0;i<list.length;i++){
            if(st==true && list[i]=='-'){
                neg = true;
                st = false;
            }
            if(Character.isDigit(list[i])){
                while(i<list.length && Character.isDigit(list[i])){
                    res =res*10 + (list[i]-'0');
                    if(res> Integer.MAX_VALUE && !neg){
                        return Integer.MAX_VALUE;
                    }else if(res>Integer.MAX_VALUE && neg){
                        return Integer.MIN_VALUE;
                    }else{
                        i++;
                    }
                }
                break;
            }
        }
        return neg? 0-res: res;
    }

    public static void main(String arg[]){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        double res  = 0;
        res = mAtoi("  -42");
    }
}
