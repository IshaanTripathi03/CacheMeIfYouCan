class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int n=mat.length;
        int m=mat[0].length;
        int row=0,col=m-1;
        while(row<n && col>=0){
            int left  = col > 0     ? mat[row][col-1] : -1;
            int down  = row < n-1   ? mat[row+1][col] : -1;
            if( down > mat[row][col] && down >left ){
                row++;
            }
            else if( left >mat[row][col] && left >down ){
                col--;
            }
            else{
                break;
            }
        }
        while(row>=0 && col<m){
            int right = col < m-1   ? mat[row][col+1] : -1;
            int up    = row > 0     ? mat[row-1][col] : -1;
            if( right > mat[row][col] && right >up ){
                col++;
            }
            else if( up >mat[row][col] && up >right ){
                row--;
            }
            else{
                return new int[]{row,col};
            }
        }
        return new int[]{-1,-1};
    }
}