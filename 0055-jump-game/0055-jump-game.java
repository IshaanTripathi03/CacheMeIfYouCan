class Solution {
    
    public boolean canJump(int[] nums) {
        int n=nums.length;
        boolean[] dp=new boolean[n];
        dp[n-1]=true;
        for(int i=n-2;i>=0;i--){
            for(int jump=1;jump<=nums[i];jump++){
                if (i + jump < n && dp[i + jump]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
// boolean f(int i,int jump,int[] nums,int n,int[][] dp){
//     if(i==n-1 || i+jump>n){
//         return true;
//     }
//     jump=Math.min(jump,n-1);
//     if(dp[i][jump]!=-1){
//         return dp[i][jump]==1;
//     }
//     boolean flag=false;
//     for(int k=1;k<=jump && i+k<n ;k++){
//         int nextJump=Math.min(nums[i+k],n-1);
//         boolean check=f(i+k,nextJump,nums,n,dp);
//         if(check){
//             dp[i][jump]=1;
//         }
//         flag=flag || check;
//     }
//     return flag;
// }