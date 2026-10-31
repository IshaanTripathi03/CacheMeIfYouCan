class Solution {
    static final int MOD=1_000_000_007;
    long function(int i,int j,int check,int n,int m , int[][] grid, long[][][] dp){
        if(i>=n || j>=m){
            return 0L;
        }
        if(i==n-1 && j==m-1){
            return 1L;
        }
        if(dp[i][j][check]!=-1){
            return dp[i][j][check];
        }
        if(grid[i][j]==1){
            if(check==1){
                return dp[i][j][check]=function(i,j+1,0,n,m,grid,dp);
            }
            else{
                return dp[i][j][check]=function(i+1,j,1,n,m,grid,dp);
            }
        }
        long down=function(i+1,j,1,n,m,grid,dp);
        long right=function(i,j+1,0,n,m,grid,dp);
        return dp[i][j][check]=(down+right)%MOD;
    }
    public int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long[][][] dp=new long[n][m][2];
        for(long[][] i:dp){
            for(long[] j:i){
                Arrays.fill(j,-1);
            }
        }
        return (int)(function(0,0,0,n,m,grid,dp)%MOD);
    }
}