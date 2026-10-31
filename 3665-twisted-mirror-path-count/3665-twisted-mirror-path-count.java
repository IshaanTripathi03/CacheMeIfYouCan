class Solution {
    static final int MOD=1_000_000_007;
    
    public int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long[][][] dp=new long[n][m][2];
        dp[0][0][0]=1L;dp[0][0][1]=1L;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    continue;
                }
                for(int check=0;check<2;check++){
                    long up=0L,left=0L;
                    if(i>0){
                        up=dp[i-1][j][1];
                    }
                    if(j>0){
                        left=dp[i][j-1][0]; 
                    }
                    if(grid[i][j]==1){
                        if(check==1){
                            dp[i][j][check]= left; 
                        }
                        else{
                            dp[i][j][check]= up; 
                        }
                    }
                    else{
                        dp[i][j][check]=(up+left)%MOD;
                    } 
                }
            }
        }
        
        return (int)dp[n-1][m-1][1];
    }
}
// long function(int i,int j,int check,int n,int m , int[][] grid, long[][][] dp){
//     if(i<0 || j<0){
//         return 0L;
//     }
//     if(i==0 && j==0){
//         return 1L;
//     }
//     if(dp[i][j][check]!=-1){
//         return dp[i][j][check];
//     }
//     if(grid[i][j]==1){
//         if(check==1){
//             return dp[i][j][check]=function(i,j-1,0,n,m,grid,dp);
//         }
//         else{
//             return dp[i][j][check]=function(i-1,j,1,n,m,grid,dp);
//         }
//     }
//     long up=function(i-1,j,1,n,m,grid,dp);
//     long left=function(i,j-1,0,n,m,grid,dp);
//     return dp[i][j][check]=(up+left)%MOD;
// }