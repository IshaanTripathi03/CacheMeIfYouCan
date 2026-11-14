class Solution {
    int function(int i,int j1,int j2,int[][]grid,int n,int m,int[][][] dp){
        if(j1<0 || j2<0 || j1>=m || j2>=m){
            return (int)-1e9;
        }
        if(i==n-1){
            if(j1==j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+grid[i][j2];
            }
        }
        if(dp[i][j1][j2]!=-1){
            return dp[i][j1][j2];
        }
        int max=Integer.MIN_VALUE;
        for(int k=-1;k<=1;k++){
            for(int l=-1;l<=1;l++){
                int col1=j1+k;
                int col2=j2+l;
                int val=0;
                if(j1==j2){
                    val+=grid[i][j1];
                }
                else{
                    val+=grid[i][j2]+grid[i][j1];
                }
                if(col1<0 || col1>=m || col2<0 || col2>=m){
                    val=(int)-1e9;
                }
                else{
                    val+=function(i+1,col1,col2,grid,n,m,dp);
                }
                max=Math.max(max,val);
            }
        }
        return dp[i][j1][j2]=max;
    }
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[][][] dp=new int[n][m][m];
        for(int[][] i:dp){
            for(int[] j:i){
                Arrays.fill(j,-1);
            }
        }
        return function(0,0,m-1,grid,n,m,dp);
    }
}