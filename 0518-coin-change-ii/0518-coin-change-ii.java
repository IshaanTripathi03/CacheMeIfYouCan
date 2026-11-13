class Solution {
    
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] dp=new int[amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt%coins[0]==0){
                dp[amt]=1;
            }
        }
        for(int i=1;i<n;i++){
            for(int amt=0;amt<=amount;amt++){
                int take=0,notTake=0;
                if(amt>=coins[i]){
                    take= dp[amt-coins[i]] ;
                }
                notTake= dp[amt] ;
                dp[amt]=take+notTake;
            }
        }
        return dp[amount];
    }
}
// private static int function(int i,int amount,int[] coins,int[][] dp){
//     if(i==0){
//         if(amount%coins[0]==0){
//             return 1;
//         }
//         return 0;
//     }
//     if(dp[i][amount]!=-1){
//         return dp[i][amount];
//     }
//     int take=0,notTake=0;
//     if(amount>=coins[i]){
//         take=function(i,amount-coins[i],coins,dp);
//     }
//     notTake=function(i-1,amount,coins,dp);
//     return dp[i][amount]=take+notTake;
// }