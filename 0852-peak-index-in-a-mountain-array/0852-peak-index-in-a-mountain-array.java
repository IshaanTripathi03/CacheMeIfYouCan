class Solution {
    public int peakIndexInMountainArray(int[] nums) {
        int n=nums.length;
        int low=0,high=n-1;
        while(low<=high){
            int mid=(low+high)>>1;
            if(nums[mid]>nums[mid+1]){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }
}