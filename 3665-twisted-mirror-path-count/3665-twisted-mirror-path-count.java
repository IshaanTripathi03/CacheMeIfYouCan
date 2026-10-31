class Solution {
    static final int MOD=1_000_000_007;
    public int uniquePaths(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        long[][] prev=new long[m][2];
        prev[0][0]=1L;prev[0][1]=1L;
        for(int i=0;i<n;i++){
            long[][] current=new long[m][2];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    current[0][0]=1L;
                    current[0][1]=1L;
                    continue;
                }
                for(int check=0;check<2;check++){
                    long up=0L,left=0L;
                    if(i>0){
                        up=prev[j][1];
                    }
                    if(j>0){
                        left=current[j-1][0]; 
                    }
                    if(grid[i][j]==1){
                        if(check==1){
                            current[j][check]= left; 
                        }
                        else{
                            current[j][check]= up; 
                        }
                    }
                    else{
                        current[j][check]=(up+left)%MOD;
                    } 
                }
            }
            prev=current;
        }
        
        return (int)prev[m-1][1];
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