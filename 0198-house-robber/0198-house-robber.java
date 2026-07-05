class Solution {
    // int f(int i,int[] nums,int[] dp){
    //     if(i==0){
    //         return nums[0];
    //     }
    //     if(i<0){
    //         return 0;
    //     }
    //     if(dp[i]!=-1){
    //         return dp[i];
    //     }
    //     int take=nums[i]+f(i-2,nums,dp);
    //     int notTake=f(i-1,nums,dp);
    //     return dp[i]= Math.max(take,notTake);
    // }
    public int rob(int[] nums) {
        int n=nums.length;
        if(n==1){
            return nums[0];
        }
        int prev2=nums[0];
        int prev1=Math.max(nums[0],nums[1]);
        for(int i=2;i<n;i++){
            int take=nums[i]+prev2;
            int notTake=prev1;
            int current= Math.max(take,notTake);
            prev2=prev1;
            prev1=current;
        }
        return prev1;
    }
}