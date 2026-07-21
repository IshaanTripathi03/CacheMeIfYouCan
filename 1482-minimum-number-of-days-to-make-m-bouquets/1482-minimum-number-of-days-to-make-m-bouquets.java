class Solution {
    static int func(int[] bloomDay,int mid, int m, int k){
        int count=0,M=0;
        for(int i:bloomDay){
            if(i<=mid){
                count++;
            }
            else{
                M+=(count/k);
                count=0;
            }
        }
        M+=(count/k);
        return M;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int max=-1,min=Integer.MAX_VALUE;
        for(int i:bloomDay){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        int low=min,high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            int countM=func(bloomDay,mid,m,k);
            if(countM>=m){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}