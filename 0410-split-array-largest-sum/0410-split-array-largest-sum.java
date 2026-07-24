class Solution {
    boolean maximumSum(int[] nums, int mid,int k){
        int a=1,sum=0;
        for(int i:nums){
            if(sum+i<=mid){
                sum+=i;
            }
            else{
                a++;
                sum=i;
            }
        }
        return a<=k;
    }
    public int splitArray(int[] nums, int k) {
        int low=-1,high=0;
        for(int i:nums){
            low=Math.max(low,i);
            high+=i;
        }
        while(low<=high){
            int mid=low+(high-low)/2;
            if(maximumSum(nums,mid,k)){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}