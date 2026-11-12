class Solution {
    private static int function(int i,int n,int[] nums,int[] dp){
        if(i>=n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int take=nums[i]+function(i+2,n,nums,dp);
        int notTake=function(i+1,n,nums,dp);
        return dp[i]=Math.max(take,notTake);
    }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        int a=function(1,n,nums,dp);
        Arrays.fill(dp,-1);
        int b=function(0,n-1,nums,dp);
        return Math.max( a , b);
    }
}