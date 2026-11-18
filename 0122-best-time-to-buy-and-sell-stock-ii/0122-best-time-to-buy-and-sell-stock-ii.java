class Solution {
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[] front=new int[2]; 
        for(int i=n-1;i>=0;i--){
            int[] current=new int[2];
            for(int buy=1;buy>=0;buy--){
                int profit;
                if(buy==1){
                    profit=Math.max(
                        -prices[i]+front[0],
                        front[1]
                    );
                }
                else{
                    profit=Math.max(
                        prices[i]+front[1],
                        front[0]
                    );
                }
                current[buy]=profit;
            }
            front=current;
        }
        return front[1];
    }
}
// int function(int i,int buy,int[] prices,int n,int[][] dp){
//     if(i==n){
//         return 0;
//     }
//     if(dp[i][buy]!=-1){
//         return dp[i][buy];
//     }
//     int profit;
//     if(buy==1){
//         profit=Math.max(
//             -prices[i]+function(i+1,0,prices,n,dp),
//             function(i+1,1,prices,n,dp)
//         );
//     }
//     else{
//         profit=Math.max(
//             prices[i]+function(i+1,1,prices,n,dp),
//             function(i+1,0,prices,n,dp)
//         );
//     }
//     return dp[i][buy]=profit;
// }