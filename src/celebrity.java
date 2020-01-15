import java.util.ArrayList;
import java.util.List;

public class celebrity {
    boolean knows (int i, int j){
        return true;
    }
    public int findCelebrity(int n) {
        for(int i = 0;i<n;i++){
            int c = 0;
            for(int j = 0;j<n;j++){
                if(i!=j && knows(j,i)) c++;
            }
            if(c==n-1){
                int nk = 0;
                for(int m = 0;m<n;m++){

                    if(m!= i && !knows(i,m)) nk++;
                }
                if(nk==n-1) return i;
            }

        }
        return -1;
    }


    /**
     * only in O(n) time - can compare through 2 pointers
     * first find the only one that he knows nobody
     * second make sure the line and the column of the person is 0 or 1
     * compare once for two a,b and b,a
     * @param n
     * @return
     */
    public int findSimCelebrity(int n) {
        int a = 0;
        int b = n-1;
        while(a<b){
            if( knows(a,b) ){
                a++;
            }else{
                b--;
            }
        }
        for(int i=0; i<n; i++){
            if( i!= a && ( !knows(i,a) || knows(a,i))){
                return -1;
            }
        }
        return a;
    }


    /**
     * if ans knows col--swap them
     * @param n
     * @return
     */
    public int findSwapCelebrity(int n) {

        int ans = 0;
        for (int col = 0; col < n; col++) {
            if (knows(ans, col)) {
                ans = col;
            }
        }

        ///* at this point, we already find an ans which has all 0 at its row for col >= its row number//
        for (int col = 0; col < ans; col++) {
            if (knows(ans, col)) {
                return -1;
            }
        }

        for (int row = 0; row < n; row++) {
            if (!knows(row, ans)) {
                return -1;
            }
        }

        return ans;
    }

    /**
     * best way to handle
     * @param n
     * @return
     */
    public int findListCelebrity(int n) {
        if (n <= 1) {
            return -1;
        }
        if (n == 2) {
            if (knows(0,1)) {
                return knows(1,0) ? -1 : 1;
            } else {
                return knows(1,0) ? 0 : -1;
            }
        }
        List<Integer> celebrities = new ArrayList<Integer>();
        for (int i = 0; i < n; i++) {
            celebrities.add(i);
        }
        while(celebrities.size()!=1) {
            List<Integer> tmp = new ArrayList<Integer>();
            for (int i = 0; i < celebrities.size() - 1; i= i + 2) {
                if (knows(celebrities.get(i), celebrities.get(i+1))) {
                    tmp.add(celebrities.get(i+1));
                } else {
                    tmp.add(celebrities.get(i));
                }
            }
            if (celebrities.size() % 2 == 1) {
                tmp.add(celebrities.get(celebrities.size()-1));
            }
            celebrities = tmp;
        }
        int result = celebrities.get(0);
        for (int i = 0; i < n; i++) {
            if (result != i && knows(result, i)) {
                return -1;
            }
        }
        return result;
    }

}
