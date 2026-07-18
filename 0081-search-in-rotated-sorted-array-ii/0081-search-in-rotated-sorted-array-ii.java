class Solution {
    public boolean search(int[] nums, int target) {
        int low=0,high=nums.length-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(nums[mid]==target){
                return true;
            }
            //Trim down in the ONLY condtion
            if(nums[low]==nums[mid] && nums[mid]==nums[high]){
                low++;
                high--;
                continue;
            }
            //For left sorted
            if(nums[low]<=nums[mid]){
                if(nums[mid]>=target && nums[low]<=target){
                    high=mid-1;
                }
                else{
                    low=mid+1;
                }
            }
            //For right sorted
            else{
                if(nums[high]>=target && nums[mid]<=target){
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }
        return false;
    }
}