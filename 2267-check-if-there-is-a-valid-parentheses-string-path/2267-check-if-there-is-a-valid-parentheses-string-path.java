class Solution {
    
    public boolean hasValidPath(char[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        if(((n+m-1)&1)==1 || grid[0][0]==')'){
            return false;
        }
        boolean prev[][]=new boolean[m][n+m+1];
        prev[0][1]=true;
        for(int i=0;i<n;i++){
            boolean current[][]=new boolean[m][n+m+1];
            current[0][1]=true;
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    continue;
                }
                for(int c=0;c<=n+m;c++){
                    int prevC=grid[i][j]==')'?c+1:c-1;
                    if(prevC<0 || prevC > n + m){
                        continue;
                    }
                    boolean up=i>0 && prev[j][prevC] ;
                    boolean left=j>0 && current[j-1][prevC] ;
                    current[j][c]=up||left;
                }
                
            }
            prev=current;
        }
        return prev[m-1][0] ;
    }
}
// boolean f(int i,int j,int c,char[][] grid,Boolean[][][] dp){
//     if(i==0 && j==0){
//         return c==1;
//     }
//     if(i<0 || j<0 || c<0){
//         return false;
//     }
//     if(dp[i][j][c]!=null){
//         return dp[i][j][c];
//     }
//     int nextC=grid[i][j]==')'?c+1:c-1;
//     boolean up=f(i-1,j,nextC,grid,dp);
//     boolean left=f(i,j-1,nextC,grid,dp);
//     return dp[i][j][c]=up||left;
// }