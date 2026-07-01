class Solution {
    // int f(int[] num,int i,int j,int[][] dp){
    //     if(i>j){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int max=Integer.MIN_VALUE;
    //     for(int k=i;k<=j;k++){
    //         int steps=num[i-1]*num[k]*num[j+1]+ f(num,i,k-1,dp) + f(num,k+1,j,dp);
    //         max=Math.max(max,steps);
    //     }
    //     return dp[i][j]=max;
    // }
    public int maxCoins(int[] nums) {
        int n=nums.length +2;
        int[] num=new int[n];
        num[0]=1;
        for(int i=1;i<n-1;i++){
            num[i]=nums[i-1];
        }
        num[n-1]=1;
        int[][] dp=new int[n][n];
        for(int i=n-2;i>=1;i--){
            for(int j=i;j<=n-2;j++){
                if(i>j){
                    continue;
                }
                int max=Integer.MIN_VALUE;
                for(int k=i;k<=j;k++){
                    int steps=num[i-1]*num[k]*num[j+1]+ dp[i][k-1] + dp[k+1][j];
                    max=Math.max(max,steps);
                }
                dp[i][j]=max;
            }
        }
        return dp[1][n-2];
    }
}