public class minPathSum {
    /**
     * 2D dp
     *
     * Top down
     *
     * dp(j)=grid(i,j)+min(dp(j),dp(j+1))
     * Time complexity :
     O
     (
     m
     n
     )
     O(mn). We traverse the entire matrix once.

     Space complexity :
     O
     (
     n
     )
     O(n). Another array of row size is used.
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if(grid==null||grid.length==0) return 0;
        int res = 0;

        int[][] dp = new int[n][m];
        dp[0][0] = grid[0][0];
        for(int i =1;i<n;i++){
            dp[i][0] = dp[i-1][0]+grid[i][0];
        }
        for(int j =1;j<m;j++){
            dp[0][j] = dp[0][j-1]+grid[0][j];
        }
        for(int i = 1;i<n;i++){
            for(int j = 1;j<m;j++){
                dp[i][j] = Math.min(dp[i][j-1],dp[i-1][j]) + grid[i][j];
            }
        }
        return dp[n-1][m-1];
    }


    /**
     * 2D
     * Bottom up
     * @param grid
     * @return
     */
    public int min2DPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int res = 0;

        int[][] dp = new int[grid.length][grid[0].length];
        for(int i = grid.length-1;i>=0 ;i--){
            for(int j = grid[0].length-1;j>=0;j--){
                //init 0 col
                if(i==grid.length-1 && j!=grid[0].length-1){
                    dp[i][j] = dp[i][j+1]+grid[i][j];
                }else if(j == grid[0].length-1 && i!=grid.length-1 ){
                    dp[i][j] = dp[i+1][j]+grid[i][j];
                }else if(j != grid[0].length - 1 && i != grid.length - 1){
                    dp[i][j] = grid[i][j]+ Math.min(dp[i+1][j], dp[i][j+1]);
                }else{
                    dp[i][j] = grid[i][j];
                }
            }
        }
        return dp[0][0];
    }

    /**
     * 1D
     *
     *  dp[j] = dp[j+1]+grid[i][j];
     *  dp[j] = dp[j]+grid[i][j];
     *
     *  dp[j] = grid[i][j]+ Math.min(dp[j], dp[j+1]);
     *
     *  return dp[0]
     * @param grid
     * @return
     */
    public int min1DPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;
        int res = 0;

        int[] dp = new int[grid[0].length];
        for(int i = grid.length-1;i>=0 ;i--){
            for(int j = grid[0].length-1;j>=0;j--){
                if(i==grid.length-1 && j!=grid[0].length-1){
                    //init 0 line
                    dp[j] = dp[j+1]+grid[i][j];
                }else if(j == grid[0].length-1 && i!=grid.length-1 ){
                    //init 0 col every round
                    dp[j] = dp[j]+grid[i][j];
                }else if(j != grid[0].length - 1 && i != grid.length - 1){
                    //compute min
                    dp[j] = grid[i][j]+ Math.min(dp[j], dp[j+1]);
                }else{
                    dp[j] = grid[i][j];
                }
            }
        }
        return dp[0];
    }

    /**
     * without extra space
     * @param grid
     * @return
     */

    public int mingridPathSum(int[][] grid) {
        if(grid==null||grid.length==0) return 0;

        for(int i = grid.length-1;i>=0 ;i--){
            for(int j = grid[0].length-1;j>=0;j--){
                if(i==grid.length-1 && j!=grid[0].length-1){
                    //init 0 line
                    grid[i][j] = grid[i][j+1]+grid[i][j];
                }else if(j == grid[0].length-1 && i!=grid.length-1 ){
                    //init 0 col every round
                    grid[i][j] = grid[i+1][j]+grid[i][j];
                }else if(j != grid[0].length - 1 && i != grid.length - 1){
                    //compute min
                    grid[i][j] = grid[i][j]+ Math.min(grid[i+1][j], grid[i][j+1]);
                }
            }
        }
        return grid[0][0];
    }

}
