class Solution {
    int func(int[] bloomDay,int mid, int m, int k){
        int count=0,M=0;
        for(int i:bloomDay){
            if(i<=mid){
                count++;
                if(count==k){
                    count=0;
                    M++;
                }
            }
            else{
                count=0;
            }
        }
        return M;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        if((long)m*k>bloomDay.length){
            return -1;
        }
        int max=-1;
        for(int i:bloomDay){
            max=Math.max(max,i);
        }
        int low=1,high=max;
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