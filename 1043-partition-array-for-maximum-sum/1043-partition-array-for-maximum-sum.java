class Solution {
    int f(int i,int[] arr,int k,int n,int[] dp){
        if(i==n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int len=0,maxi=Integer.MIN_VALUE,maxSum=Integer.MIN_VALUE;
        for(int j=i;j<Math.min(k+i,n);j++){
            len++;
            maxi=Math.max(maxi,arr[j]);
            int sum=(len*maxi)+f(j+1,arr,k,n,dp);
            maxSum=Math.max(maxSum,sum);
        }
        return dp[i]=maxSum;
    }
    public int maxSumAfterPartitioning(int[] arr, int k) {
        int n=arr.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return f(0,arr,k,n,dp);
    }
}