class Solution {
    int func(int[] weights, int mid){
        int max=mid,day=1;
        for(int i:weights){
            if(max>=i){
                max-=i;
            }
            else{
                day++;
                max=mid-i;
            }
        }
        return day;
    }
    public int shipWithinDays(int[] weights, int days) {
        int max=Integer.MIN_VALUE,sum=0;
        for(int i:weights){
            max=Math.max(max,i);
            sum+=i;
        }
        int low=max,high=sum;
        while(low<=high){
            int mid=low+(high-low)/2;
            int capacity=func(weights,mid);
            if(capacity<=days){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}