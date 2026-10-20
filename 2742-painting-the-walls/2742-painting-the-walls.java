class Solution {
    int function (int i,int remaining,int[] cost,int[] time,int[][] dp){
        if(remaining<=0){
            return 0;
        }
        if(i>=0 && dp[i][remaining]!=-1){
            return dp[i][remaining];
        }
        if(i<0 && remaining>0){
            return (int)1e9;
        }
        int free,paid;
        free=function(i-1,remaining,cost,time,dp);
        paid=cost[i]+function(i-1,remaining-time[i]-1,cost,time,dp);
        return dp[i][remaining]= Math.min(free,paid);
    }
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        int[][] dp=new int[n][n+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return function(n-1,n,cost,time,dp);
    }
}