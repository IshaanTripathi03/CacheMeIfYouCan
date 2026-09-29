class Solution {
    boolean f(int i,int j,int c,char[][] grid,Boolean[][][] dp){
        if(i==0 && j==0){
            return c==1;
        }
        if(i<0 || j<0 || c<0){
            return false;
        }
        if(dp[i][j][c]!=null){
            return dp[i][j][c];
        }
        int nextC=grid[i][j]==')'?c+1:c-1;
        boolean up=f(i-1,j,nextC,grid,dp);
        boolean left=f(i,j-1,nextC,grid,dp);
        return dp[i][j][c]=up||left;
    }
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(((n+m-1)&1)==1 || grid[0][0]==')'){
            return false;
        }
        Boolean dp[][][]=new Boolean[n][m][n+m+1]; 
        
        return f(n-1,m-1,0,grid,dp);
    }
}