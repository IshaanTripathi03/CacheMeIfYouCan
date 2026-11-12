class Solution {
    private static int function(int i,int amount,int[] coins,int[][] dp){
        if(i<0){
            return (int)1e9;
        }
        if(amount==0){
            return 0;
        }
        if(amount==coins[i]){
            return 1;
        }
        if(dp[i][amount]!=-1){
            return dp[i][amount];
        }
        int take=(int)1e9;
        if(amount>=coins[i]){
            take=1+function(i,amount-coins[i],coins,dp);
        }
        
        int notTake=function(i-1,amount,coins,dp);
        return dp[i][amount]=Math.min(take,notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        int result=function(n-1,amount,coins,dp);
        return result==(int)1e9?-1:result;
    }
}