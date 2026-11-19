class Solution {
    int dfs(int i,int j,int[][] grid,int id,int n,int m){
        if(i<0 || j<0 || i>=n || j>=m || grid[i][j]!=1){
            return 0;
        }
        int sum=1;
        grid[i][j]=id;
        sum+=dfs(i-1,j,grid,id,n,m);
        sum+=dfs(i+1,j,grid,id,n,m);
        sum+=dfs(i,j+1,grid,id,n,m);
        sum+=dfs(i,j-1,grid,id,n,m);
        return sum;
    }
    public int largestIsland(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxSize=0,id=2;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    int size=dfs(i,j,grid,id,n,m);
                    map.put(id++,size);
                    maxSize=Math.max(maxSize,size);
                }
            }
        }
        int[] dx={0,0,1,-1};
        int[] dy={1,-1,0,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==0){
                    int currentSize=1;
                    HashSet<Integer> set=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int row=i+dx[k];
                        int col=j+dy[k];
                        if(row<n && col<m && row>=0 && col>=0 && !set.contains(grid[row][col]) && grid[row][col]!=0){
                            currentSize+=map.get(grid[row][col]);
                            set.add(grid[row][col]);
                        }
                    }
                    maxSize=Math.max(maxSize,currentSize);
                }
                
            }
        }
        return maxSize==0?1:maxSize;
    }
}