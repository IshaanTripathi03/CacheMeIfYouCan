class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n=arr.length;
        // dp[i] = minimum length of a target-sum subarray
        int dp[]=new int[n+1];
        int left=0,sum=0,min=n+1,ans=n+1;
        for(int right=0;right<n;right++){
            sum+=arr[right];
            while(sum>target){
                sum-=arr[left];
                left++;
            }
            if(sum==target){
                int len=right-left+1;
                if(left>0 && dp[left-1]!=n+1){
                    ans=Math.min(ans,dp[left-1]+len);
                }
                min=Math.min(min,len);
            }
            dp[right]=min;
        }
        return ans==n+1?-1:ans;
    }
}