class Solution {
    public int stoneGameV(int[] stoneValue) {
        int n=stoneValue.length;
        int prefix[]=new int[n];
        int dp[][]=new int[n][n];
        prefix[0]=stoneValue[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+stoneValue[i];
        }
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<n;j++){
                int max=Integer.MIN_VALUE;
                for(int k=i;k<j;k++){
                    int leftSum=prefix[k]- (i>0?prefix[i-1]:0);
                    int rightSum=prefix[j]-prefix[k];
                    int points;
                    if(leftSum<rightSum){
                        points=leftSum+dp[i][k];
                    }
                    else if(rightSum<leftSum){
                        points=rightSum+dp[k+1][j];
                    }
                    else{
                        points=leftSum+Math.max(dp[i][k],dp[k+1][j]);
                    }
                    max=Math.max(max,points);
                }
                dp[i][j]=max;
            }
        }
        return dp[0][n-1];
    }
}
// int f(int[] stoneValue,int i,int j,int[] prefix,int[][] dp){
//     if(i==j){
//         return 0;
//     }
//     if(dp[i][j]!=-1){
//         return dp[i][j];
//     }
//     int max=Integer.MIN_VALUE;
//     for(int k=i;k<j;k++){
//         int leftSum=prefix[k]- (i>0?prefix[i-1]:0);
//         int rightSum=prefix[j]-prefix[k];
//         int points;
//         if(leftSum<rightSum){
//             points=leftSum+f(stoneValue,i,k,prefix,dp);
//         }
//         else if(rightSum<leftSum){
//             points=rightSum+f(stoneValue,k+1,j,prefix,dp);
//         }
//         else{
//             points=leftSum+Math.max(f(stoneValue,i,k,prefix,dp),f(stoneValue,k+1,j,prefix,dp));
//         }
//         max=Math.max(max,points);
//     }
//     return dp[i][j]=max;
// }