public class ToLowerCase {
    public static String toLowerCase(String str) {
        String out = "";
        try{
            for (int i = 0; i<str.length();i++){
    //            char newChar = str.charAt(i);
                //str.charAt(i)>='A' && str.charAt(i)<='Z'
                if (Character.isUpperCase(str.charAt(i))){
                    out += Character.toLowerCase(str.charAt(i));
                }
                else out += str.charAt(i);
            }
            return out;
        } catch (Exception e){
            System.out.println("Exception Occured :" + e.getMessage());
        }
    }
    public static void main(String args[]){
        toLowerCase("Abs");
    }
}
