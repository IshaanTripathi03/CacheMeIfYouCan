class Solution {
    public int uniquePaths(int m, int n) {
        int[] prev=new int[m];
        prev[0]=1;
        for(int i=0;i<n;i++){
            int[] temp=new int[m];
            for(int j=0;j<m;j++){
                if(i==0 && j==0){
                    temp[0]=1;
                    continue;
                }
                int up=0,left=0;
                if(i>0){
                    up=prev[j];
                }
                if(j>0){
                    left=temp[j-1];
                }
                temp[j]=up+left;
            }
            prev=temp;
        }
        return prev[m-1];
    }
}
// int f(int i,int j,int[][] dp){
    //     if(i==0 && j==0){
    //         return 1;
    //     }
    //     if(i<0 || j<0){
    //         return 0;
    //     }
    //     if(dp[i][j]!=-1){
    //         return dp[i][j];
    //     }
    //     int up=f(i-1,j,dp);
    //     int left=f(i,j-1,dp);
    //     return dp[i][j]=up+left;
    // }