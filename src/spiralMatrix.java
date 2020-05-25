import java.util.ArrayList;
import java.util.List;

public class spiralMatrix {
    public static List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if(matrix==null || matrix.length==0) return ans;
        int row = matrix.length;
        int col = matrix[0].length;

        boolean[][] seen = new boolean[row][col];
        int[] x = {0,1,0,-1};
        int[] y = {1,0,-1,0};

        int r = 0,c = 0, dir = 0;
        for(int i = 0;i<row*col;i++){
            ans.add(matrix[r][c]);
            seen[r][c] = true;
            int nx = r+x[dir];
            int ny = c+y[dir];
            if(nx>=0 && nx<row && ny>=0 && ny<col && !seen[nx][ny]){
                r = nx;
                c = ny;
            }else{
                //change the direction
                dir = (dir+1)%4;
                r += x[dir];
                c += y[dir];
            }
        }
        return ans;

    }


    public static void main(String args[]){
        int[][] m = {{1,2,3,4},{5,6,7,8,},{9,10,11,12}};
        spiralOrder(m);
    }
}
