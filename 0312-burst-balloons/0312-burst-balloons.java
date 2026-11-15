class Solution {
    
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] num=new int[n+2];
        num[0]=1;num[n+1]=1;
        for(int i=1;i<=n;i++){
            num[i]=nums[i-1];
        }
        int[][] dp=new int[n+2][n+2];
        for(int i=n;i>=1;i--){
            for(int j=1;j<=n;j++){
                if(i>j){
                    continue;
                }
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int partition=num[i-1]*num[k]*num[j+1]+ dp[i][k-1] + dp[k+1][j];
                    max=Math.max(max,partition);
                }
                dp[i][j]=max;
            }
        }
        return  dp[1][n];
    }
}
// private static int function(int i,int j,int[] num,int[][] dp){
//     if(j<i){
//         return 0;
//     }
//     if(dp[i][j]!=-1){
//         return dp[i][j];
//     }
//     int max=Integer.MIN_VALUE;
//     for(int k=i;k<=j;k++){
//         int partition=num[i-1]*num[k]*num[j+1]+function(i,k-1,num,dp)+function(k+1,j,num,dp);
//         max=Math.max(max,partition);
//     }
//     return dp[i][j]=max;
// }