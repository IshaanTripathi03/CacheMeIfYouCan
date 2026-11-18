class Solution {
    public int maxProfit(int k, int[] prices) {
        int n=prices.length;
        int[][] front=new int[2][k+2];
        for(int i=n-1;i>=0;i--){
            int[][] current=new int[2][k+2];
            for(int buy=0;buy<=1;buy++){
                for(int cap=0;cap<k;cap++){
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