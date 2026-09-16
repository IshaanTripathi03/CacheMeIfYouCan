class Solution {
    static final int MOD=1_000_000_007;
    static int f(int n,int k,int dp[][]){
        if(k==0){
            return 1;
        }
        if(n==0){
            return 0;
        }
        if(dp[n][k]!=-1){
            return dp[n][k];
        }
        if(n-1==k){
            return 1;
        }
        long sum=f(n-1,k,dp);
        for(int start = 0; start < n - 1; start++) {
            sum += f(start + 1, k - 1,dp);
            sum%=MOD;
        }
        return dp[n][k]=(int)sum;
    }
    public int numberOfSets(int n, int k) {
        int dp[][]=new int[n+1][k+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return f(n,k,dp);
    }
}