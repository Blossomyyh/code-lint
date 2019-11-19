public class island {

    //todo bfs isolated island nums - 200
    public int numIslands(char[][] grid) {
        //todo wipe out special cases!!!!
        if(grid==null||grid.length==0) return 0;
        int r = grid.length;
        int c = grid[0].length;
        int res = 0;
        int[][] visit = new int[r][c];
        for(int i = 0;i<r;i++){
            for(int j = 0;j<c;j++){
                if(visit[i][j] ==0 && (grid[i][j]-'1')==0){
                    //search for island
                    dfs(i,j,visit,grid);
                    res++;
                }
            }
        }
        return res;
    }

    public void dfs(int i, int j, int[][] visit, char[][] grid){
        int[] ix = {1,-1,0,0};
        int[] jx = {0,0,1,-1};
        visit[i][j] = 1;

        for(int m =0;m<4;m++){
            //todo  have to check the outbound!!!!
            if(i+ix[m]>=0 &&(i+ix[m]<grid.length)
                    && (j+jx[m]>=0) && (j+jx[m]<grid[0].length)&&
                    (grid[i+ix[m]][j+jx[m]]-'1')==0 && visit[i+ix[m]][j+jx[m]] ==0){
                dfs(i+ix[m], j+jx[m], visit, grid);
            }
        }
    }
    /**
     * time complexity : O(m*n) only encounter one block once!
     * space the same
     */


     //todo KMP





}
