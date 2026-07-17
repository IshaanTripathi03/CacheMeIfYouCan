class Solution {
    public int[] searchRange(int[] nums, int target) {
        int n=nums.length;
        int left=0,right=n-1,first=-1;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(nums[mid]==target){
                first=mid;
                right=mid-1;
            }
            else if(nums[mid]<target){
                left=mid+1;
            }
            else{
                right=mid-1;
            }
        }
        if(first==-1){
            return new int[]{-1,-1};
        }
        int low=0,high=n-1,last=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                last=mid;
                low=mid+1;
            }
            else if(nums[mid]<target){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }
        return new int[]{left,last};
    }
}