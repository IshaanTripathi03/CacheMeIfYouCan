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
        int[] dp=new int[n+1];
        dp[0]=0;
        for(int i=1;i<=n;i++){
            int case1=(int)1e9,case2=(int)1e9,case3=(int)1e9;
            if(i>0)
            case1=costs[i-1]+1+ dp[i-1] ;
            if(i>1)
            case2=costs[i-1]+4+ dp[i-2] ;
            if(i>2)
            case3=costs[i-1]+9+ dp[i-3] ;
            dp[i]=Math.min( case1 , Math.min(case2,case3) );
        }
        return dp[n];
    }
}