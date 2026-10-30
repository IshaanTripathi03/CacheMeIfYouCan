class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        int n=grid.length;
        int m=grid[0].length;
        PriorityQueue<Integer> result=new PriorityQueue<>();
        for(int i=0;i<n;i++){
            if(limits[i]==0){
                continue;
            }
            PriorityQueue<Integer> pq=new PriorityQueue<>();
            for(int j=0;j<m;j++){
                pq.offer(grid[i][j]);
                if(pq.size()>limits[i]){
                    pq.poll();
                }
            }
            while(!pq.isEmpty()){
                result.offer(pq.poll());
                if(result.size()>k){
                    result.poll();
                }
            }
        }
        long sum=0L;
        while(!result.isEmpty()){
            sum+=result.poll();
        }
        return sum;
    }
}