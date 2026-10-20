class Solution {
    public int paintWalls(int[] cost, int[] time) {
        int n=cost.length;
        int[] prev=new int[n+1];
        for(int remaining=1;remaining<=n;remaining++){
            if(remaining<=time[0]+1){
                prev[remaining]=cost[0];
            }
            else{
                prev[remaining]= (int)1e9;
            }
        }
        for(int i=1;i<n;i++){
            int[] current=new int[n+1];
            current[0]=0;
            
            for(int remaining=1;remaining<=n;remaining++){
                int free,paid=cost[i];
                free= prev[remaining] ;
                if(remaining-time[i]-1>0)
                paid+=prev[remaining-time[i]-1];
                current[remaining]= Math.min(free,paid);
            }
            prev=current;
        }
        return prev[n];
    }
}
// int function (int i,int remaining,int[] cost,int[] time,int[][] dp){
//     if(remaining<=0){
//         return 0;
//     }
//     if(i>=0 && dp[i][remaining]!=-1){
//         return dp[i][remaining];
//     }
//     if(i<0 && remaining>0){
//         return (int)1e9;
//     }
//     int free,paid;
//     free=function(i-1,remaining,cost,time,dp);
//     paid=cost[i]+function(i-1,remaining-time[i]-1,cost,time,dp);
//     return dp[i][remaining]= Math.min(free,paid);
// }