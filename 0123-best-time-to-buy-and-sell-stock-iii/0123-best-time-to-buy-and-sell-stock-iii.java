class Solution {
    
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int[][] front=new int[2][3];
        for(int i=n-1;i>=0;i--){
            int[][] current=new int[2][3];
            for(int buy=0;buy<=1;buy++){
                for(int cap=0;cap<2;cap++){
                    int profit;
                    if(buy==1){
                        profit=Math.max(
                            -prices[i]+front[0][cap],
                            front[1][cap]
                        );
                    }
                    else{
                        profit=Math.max(
                            prices[i]+front[1][cap+1],
                            front[0][cap]
                        );
                    }
                    current[buy][cap]=profit;
                }
            }
            front=current;
        }
        return front[1][0];
    }
}
// int function(int i,int buy,int cap,int[] prices,int n,int[][][] dp){
//     if(i==n || cap==2){
//         return 0;
//     }
//     if(dp[i][buy][cap]!=-1){
//         return dp[i][buy][cap];
//     }
//     int profit;
//     if(buy==1){
//         profit=Math.max(
//             -prices[i]+function(i+1,0,cap,prices,n,dp),
//             function(i+1,1,cap,prices,n,dp)
//         );
//     }
//     else{
//         profit=Math.max(
//             prices[i]+function(i+1,1,cap+1,prices,n,dp),
//             function(i+1,0,cap,prices,n,dp)
//         );
//     }
//     return dp[i][buy][cap]=profit;
// }