class Solution {
    public int jump(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[n-1]=0;
        for(int i=n-2;i>=0;i--){
            int min=Integer.MAX_VALUE-1;
            for(int j=i+1;j<n && j<=i+nums[i];j++){
                min=Math.min(min,dp[j]);
            }
            dp[i]=1+min;
        }
        return dp[0];
    }
}