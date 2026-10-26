class Solution {
    private static long dfs(int[][] grid,int i,int j,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]==0){
            return 0L;
        }
        long value=grid[i][j];
        grid[i][j]=0;
        value+=dfs(grid,i-1,j,n,m);
        value+=dfs(grid,i+1,j,n,m);
        value+=dfs(grid,i,j-1,n,m);
        value+=dfs(grid,i,j+1,n,m);
        return value;
    }
    public int countIslands(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]!=0 && dfs(grid,i,j,n,m)%k==0){
                    count++;
                }
            }
        }
        return count;
    }
}