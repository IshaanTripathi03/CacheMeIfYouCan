class Solution {
    public int minCost(int len, int[] cuts) {
        int m=cuts.length;
        int nums[]=new int[m+2];
        int n=m+2;
        for(int i=1;i<n-1;i++){
            nums[i]=cuts[i-1];
        }
        nums[n-1]=len;
        Arrays.sort(nums);
        int dp[][]=new int[n][n];
        for(int i=n-2;i>=1;i--){
            for(int j=i;j<=n-2;j++){
                if(i>j){
                    continue;
                }
                int min=Integer.MAX_VALUE;
                for(int k=i;k<=j;k++){
                    int steps=nums[j+1]-nums[i-1] + dp[i][k-1] + dp[k+1][j];
                    min=Math.min(min,steps);
                }
                dp[i][j]=min;
            }
        }
        return dp[1][n-2];
    }
}