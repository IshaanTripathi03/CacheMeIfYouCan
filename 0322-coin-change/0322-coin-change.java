class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        
        for(int amt=0;amt<=amount;amt++){
            if(amt%coins[0]==0){
                dp[0][amt]=amt/coins[0];
            }
            else{
                dp[0][amt]=(int)1e9;
            }
        }
        
        for(int i=1;i<n;i++){
            for(int amt=0;amt<=amount;amt++){
                int take=(int)1e9;
                if(amt>=coins[i]){
                    take=1+ dp[i][amt-coins[i]] ;
                }
                int notTake= (int)1e9;
                if(i>0){
                    notTake=dp[i-1][amt];
                }
                dp[i][amt]=Math.min(take,notTake);
            }
        }
        int result=dp[n-1][amount];
        return result==(int)1e9?-1:result;
    }
}

// private static int function(int i,int amount,int[] coins,int[][] dp){
//     if(i==0){
//         if(amount%coins[0]==0){
//             return amount/coins[0];
//         }
//         return (int)1e9;
//     }
//     if(dp[i][amount]!=-1){
//         return dp[i][amount];
//     }
//     int take=(int)1e9;
//     if(amount>=coins[i]){
//         take=1+function(i,amount-coins[i],coins,dp);
//     }
    
//     int notTake=function(i-1,amount,coins,dp);
//     return dp[i][amount]=Math.min(take,notTake);
// }