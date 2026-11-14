class Solution {
    int function(int i,int j,int n,int m,int[][] dungeon,int[][] dp){
        if(i>=n || j>=m){
            return (int)1e9;
        }
        if(i==n-1 && j==m-1){
            return Math.max(1,1-dungeon[i][j]);
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int left=function(i,j+1,n,m,dungeon,dp);
        int up=function(i+1,j,n,m,dungeon,dp);
        int required=Math.min(left,up)-dungeon[i][j];
        return dp[i][j]=Math.max(1,required);
    }
    public int calculateMinimumHP(int[][] dungeon) {
        int n=dungeon.length;
        int m=dungeon[0].length;
        int[][] dp=new int[n][m];
        dp[n-1][m-1]=Math.max(1,1-dungeon[n-1][m-1]);
        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(i==n-1 && j==m-1){
                    continue;
                }
                int right=(int)1e9,down=(int)1e9;
                if(j<m-1)
                right= dp[i][j+1] ;
                if(i<n-1)
                down= dp[i+1][j] ;
                int required=Math.min(right,down)-dungeon[i][j];
                dp[i][j]=Math.max(1,required);
            }
        }
        return dp[0][0];
    }
}