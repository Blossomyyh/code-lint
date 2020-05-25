public class shiftString {

    /**
     * have to notice that shift should do once a time during traversal
     *
     * no accumulation -- since it will exceed the whole length of string
     *
     * N - shift , L -sting
     * time O(N*L)
     * space O(L)
     * @param s
     * @param shift
     * @return
     */
    public String stringShift(String s, int[][] shift) {
        int cal = 0;
        if(shift==null|| shift.length==0||s==null||s.length()==0) return s;
        for(int[] item: shift){
            if(item[0]==0) s = s.substring(item[1]) + s.substring(0,item[1]);
            else if(item[0]==1) s = s.substring(s.length()-item[1]) + s.substring(0,s.length()-item[1]);
        }

        return s;

    }

    /**
     * only need one attemp
     * time and space the same
     * @param s
     * @param shift
     * @return
     */
    public String stringAllShift(String s, int[][] shift) {
        int cal = 0;
        if(shift==null|| shift.length==0||s==null||s.length()==0) return s;
        for(int[] item: shift){
            if(item[0]==0) cal-=item[1];
            else if(item[0]==1) cal+=item[1];
        }
        int shi = Math.abs(cal)%s.length();
        if(shi==s.length()) return s;
        if(cal==0) return s;
        else if(cal>0) {
            s = s.substring(s.length()-shi) + s.substring(0,s.length()-shi);
        }else if(cal<0){
            s = s.substring(shi) + s.substring(0,shi);
        }
        return s;

    }

}
