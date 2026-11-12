class Solution {
    
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[] prev=new int[amount+1];
        
        for(int amt=0;amt<=amount;amt++){
            if(amt%coins[0]==0){
                prev[amt]=amt/coins[0];
            }
            else{
                prev[amt]=(int)1e9;
            }
        }
        
        for(int i=1;i<n;i++){
            int current[]=new int[amount+1];
            for(int amt=0;amt<=amount;amt++){
                int take=(int)1e9;
                if(amt>=coins[i]){
                    take=1+ current[amt-coins[i]] ;
                }
                int notTake= (int)1e9;
                if(i>0){
                    notTake=prev[amt];
                }
                current[amt]=Math.min(take,notTake);
            }
            prev=current;
        }
        int result=prev[amount];
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