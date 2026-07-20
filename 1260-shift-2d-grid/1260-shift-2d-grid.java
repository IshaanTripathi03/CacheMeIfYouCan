class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length;
        int m=grid[0].length;
        k%=(n*m);
        List <List<Integer>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<Integer> row=new ArrayList<>();
            for(int j=0;j<m;j++){
                row.add(0);
            }
            result.add(row);
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int linearIdx=i*m+j;
                int newidx=(linearIdx+k)%(n*m);
                int row=newidx/m;
                int col=newidx%m;
                result.get(row).set(col,grid[i][j]);
            }
        }
        return result;
    }
}