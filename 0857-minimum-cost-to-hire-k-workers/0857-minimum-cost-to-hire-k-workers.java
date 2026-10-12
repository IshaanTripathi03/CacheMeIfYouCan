class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n=quality.length;
        double[][] workers=new double[n][2];
        for(int i=0;i<n;i++){
            workers[i][0]=(double)wage[i]/quality[i];
            workers[i][1]=quality[i];
        }
        Arrays.sort(workers,(a,b)->Double.compare(a[0],b[0]));
        PriorityQueue<Double> pq=new PriorityQueue<>(Collections.reverseOrder());
        double totalQuality=0,result=Double.MAX_VALUE;
        for(double worker[]:workers){
            pq.offer(worker[1]);
            totalQuality+=worker[1];
            if(pq.size()>k){
                totalQuality-=pq.poll();
            }
            if(pq.size()==k){
                result=Math.min(result,totalQuality*worker[0]);
            }
        }
        return result;
    }
}