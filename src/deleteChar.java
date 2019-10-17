public class deleteChar {
//    public static String solution(String S) {
//        // write your code in Java SE 8
//        if (S.length()==0) return "";
//        // create stringbuffer for delete
//        StringBuffer sb = new StringBuffer(S);
//        int freq = 1;
//        char a = sb.charAt(0);
//        for(int i =1 ;i<sb.length(); i++){
//            if(sb.charAt(i)==a){
//                freq++;
//                if(freq>=3){
//                    sb.deleteCharAt(i);
//                    i--;
//                }
//            } else if (sb.charAt(i)!=a){
//                a = sb.charAt(i);
//                freq = 0;
//            }
//        }
//        return sb.toString();
//    }


    public static int solution(int[][] A) {
        // write your code in Java SE 8
        int lin = A.length;
        int col = A[0].length;
        int min = col>lin? lin:col;
        if (min == 1) return 1;
        //start from largest square to min(1)
        for(int m = min; m>=1; m--){
            for(int i = 0; i<=col-m;i++){
                for(int j = 0;j<=lin-m;j++){
                    //check every possible square of size m
                    if(check(A, i,j,m)) return m;
                }
            }
        }

        return 0;
    }

    // define function to test whether the square is qualified
    public static boolean check(int[][] A, int i, int j, int m){
        //each row should be equal
        int sum = 0;
        for(int a =0 ;a<m; a++){
            sum +=A[j][a+i];
        }
        int temp = 0;
        for(int k= 1; k<m ;k++){
            for(int a=0 ;a<m; a++){
                temp +=A[j+k][a+i];
            }
            if (temp !=sum) return false;
            temp = 0;
        }
        temp = 0;
        for(int k = 0;k<m;k++){
            for(int a=0; a<m;a++){
                temp +=A[j+a][i+k];
            }
            if (temp !=sum) return false;
            temp = 0;
        }
        temp = 0;
        for(int q = 0; q<m;q++){
            temp +=A[j+q][i+q];
        }
        if (temp !=sum) return false;
        temp = 0;

        for(int q = 0; q<m;q++){
            temp +=A[j+q][i+(m-q-1)];
        }
        if (temp !=sum) return false;

        return true;
    }
    public static void main (String args[]){
        int[][] A = {
                {4, 3, 4, 5, 3},
                {2, 7, 3, 8, 4},
                {1, 7, 6, 5, 2},
                {8, 4, 9, 5, 5}};
        solution(A);

    }
}
