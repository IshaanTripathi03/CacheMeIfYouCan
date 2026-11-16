class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int n=nums.length;
        int totalSum=0;
        for(int i:nums){
            totalSum+=i;
        }
        if(totalSum%k!=0){
            return false;
        }
        int target=totalSum/k;
        Arrays.sort(nums);
        if(nums[n-1]>target){
            return false;
        }
        int totalMask=1<<n;
        int[] dp=new int[totalMask];
        Arrays.fill(dp,-1);
        dp[0]=0;
        for(int mask=0;mask<totalMask;mask++){
            if(dp[mask]==-1){
                continue;
            }
            for(int i=0;i<n;i++){
                if((mask&(1<<i))!=0){
                    continue;
                }
                int newSum=dp[mask]+nums[i];
                if(newSum>target){
                    continue;
                }
                int newMask=(mask|(1<<i));
                dp[newMask]=newSum%target;
            }
        }
        return dp[totalMask-1]==0;
    }
}