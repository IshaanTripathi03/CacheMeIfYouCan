class Solution {
    // private static int function(int i,int[] costs,int[] dp){
    //     if(i==0){
    //         return 0;
    //     }
    //     if(i<0){
    //         return (int) 1e9;
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }
    //     int case1=costs[i-1]+1+function(i-1,costs,dp);
    //     int case2=costs[i-1]+4+function(i-2,costs,dp);
    //     int case3=costs[i-1]+9+function(i-3,costs,dp);
    //     return dp[i]=Math.min( case1 , Math.min(case2,case3) );
    // }
    public int climbStairs(int n, int[] costs) {
        int prev1=0,prev2=(int)1e9,prev3=(int)1e90;
        for(int i=1;i<=n;i++){
            int case1=(int)1e9,case2=(int)1e9,case3=(int)1e9;
            if(i>0)
            case1=costs[i-1]+1+ prev1 ;
            if(i>1)
            case2=costs[i-1]+4+ prev2 ;
            if(i>2)
            case3=costs[i-1]+9+ prev3 ;
            int current=Math.min( case1 , Math.min(case2,case3) );
            prev3=prev2;
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}