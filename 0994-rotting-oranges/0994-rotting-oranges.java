class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int fresh=0;
        ArrayDeque<int[]> q=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    fresh++;
                }
            }
        }
        int time=0;
        int[] dx={-1,1,0,0};
        int[] dy={0,0,1,-1};
        while(!q.isEmpty() && fresh>0){
            int len=q.size();
            for(int k=0;k<len;k++){
                int[] curr=q.poll();
                for(int i=0;i<4;i++){
                    int row=dx[i]+curr[0];
                    int col=dy[i]+curr[1];
                    if(row>=0 && col>=0 && row<n && col<m && grid[row][col]==1){
                        grid[row][col]=2;
                        fresh--;
                        q.offer(new int[]{row,col});
                    }
                }
            }
            time++;
        }
        return fresh==0?time:-1;
    }
}