class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length;
        int m=matrix[0].length;
        int[][] dp=new int[n][m];
        int sum=0;
        for(int i=0;i<n;i++){
            dp[i][0]=matrix[i][0];
            sum+=dp[i][0];
        }
        //Matrix[0][0]=has already been traversed , we dont need to do it again otherwise sum will increase by 1 if mattrix[0][0]=1
        for(int j=1;j<m;j++){
            dp[0][j]=matrix[0][j];
            sum+=dp[0][j];
        }

        for(int i=1;i<n;i++){
            for(int j=1;j<m;j++){
                if(matrix[i][j]==0){
                    continue;
                }
                else{
                    dp[i][j]=Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] , dp[i][j-1])) + 1;
                }
                sum+=dp[i][j];
            }
        }
        return sum;
    }
}