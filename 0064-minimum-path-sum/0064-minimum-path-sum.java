class Solution {
    
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] prev=new int[m];
        prev[0]=grid[0][0];
        for(int i=0;i<n;i++){
            int[] current=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    current[0]=grid[0][0];
                    continue;
                }
                int up=(int)1e9,left=(int)1e9;
                if(i>0)
                up=grid[i][j]+ prev[j] ;
                if(j>0)
                left=grid[i][j]+ current[j-1] ;
                current[j]=Math.min(up,left);
            }
            prev=current;
        }
        return prev[m-1];
    }
}
// private static int function(int i,int j,int[][] grid,int[][] dp){
//     if(i<0 || j<0){
//         return (int)1e9;
//     }
//     if(i==0 && j==0){
//         return grid[0][0];
//     }
//     if(dp[i][j]!=-1){
//         return dp[i][j];
//     }
//     int up=grid[i][j]+function(i-1,j,grid,dp);
//     int left=grid[i][j]+function(i,j-1,grid,dp);
//     return dp[i][j]=Math.min(up,left);
// }