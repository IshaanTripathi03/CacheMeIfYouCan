class Solution {
    private static int function(int i,int amount,int[] coins,int[][] dp){
        if(i==0){
            if(amount%coins[0]==0){
                return 1;
            }
            return 0;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int take=0,notTake=0;
        if(amount>=coins[i]){
            take=function(i,amount-coins[i],coins,dp);
        }
        notTake=function(i-1,amount,coins,dp);
        return dp[i][amount]=take+notTake;
    }
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return function(n-1,amount,coins,dp);
    }
}