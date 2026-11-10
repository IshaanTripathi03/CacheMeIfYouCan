class Solution {
    private static boolean check(int mid,int[] bloomDay,int m,int k){
        int bouquetsCount=0,totalCounts=0;
        for(int i:bloomDay){
            if(i<=mid){
                bouquetsCount++;
            }
            else{
                totalCounts+=bouquetsCount/k;
                bouquetsCount=0;
            }
        }
        totalCounts+=bouquetsCount/k;
        return totalCounts>=m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int low=Integer.MAX_VALUE,high=0;
        if((long)bloomDay.length<(long)m*k){
            return -1;
        }
        for(int i:bloomDay){
            low=Math.min(low,i);
            high=Math.max(high,i);
        }
        while(low<=high){
            int mid=(low+high)>>1;
            if(check(mid,bloomDay,m,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}