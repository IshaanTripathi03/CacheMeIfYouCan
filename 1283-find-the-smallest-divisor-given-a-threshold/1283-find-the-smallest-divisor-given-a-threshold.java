class Solution {
    int sumwithDivisor(int[] nums, int mid){
        int sum=0;
        for(int i:nums){
            sum+=(i+mid-1)/mid;
        }
        return sum;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int max=-1;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int low=1,high=max;
        while(low<=high){
            int mid=low+(high-low)/2;
            int sum=sumwithDivisor(nums,mid);
            if(sum<=threshold){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}