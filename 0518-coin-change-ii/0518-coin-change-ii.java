class Solution {
    
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        for(int amt=0;amt<=amount;amt++){
            if(amt%coins[0]==0){
                prev[amt]=1;
            }
        }
        for(int i=1;i<n;i++){
            int[] current=new int[amount+1];
            for(int amt=0;amt<=amount;amt++){
                int take=0,notTake=0;
                if(amt>=coins[i]){
                    take= current[amt-coins[i]] ;
                }
                notTake= prev[amt] ;
                current[amt]=take+notTake;
            }
            prev=current;
        }
        return prev[amount];
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