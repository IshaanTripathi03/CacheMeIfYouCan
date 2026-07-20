class Solution {
    long func(int[] piles,int k){
        long sum=0;
        for(int i:piles){
            sum+=(i+k-1)/k;
        }
        return sum;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int max=Integer.MIN_VALUE;
        for(int i:piles){
            max=Math.max(max,i);
        }
        int low=1,high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(func(piles,mid)<=h){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}