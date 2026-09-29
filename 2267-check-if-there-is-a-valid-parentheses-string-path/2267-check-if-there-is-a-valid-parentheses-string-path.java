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
        boolean dp[][][]=new boolean[n][m][n+m+1];
        dp[0][0][1]=true;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    continue;
                }
                for(int c=0;c<=n+m;c++){
                    int prevC=grid[i][j]==')'?c+1:c-1;
                    if(prevC<0 || prevC > n + m){
                        continue;
                    }
                    boolean up=i>0 && dp[i-1][j][prevC] ;
                    boolean left=j>0 && dp[i][j-1][prevC] ;
                    dp[i][j][c]=up||left;
                }
                
            }
        }
        return dp[n-1][m-1][0] ;
    }
}