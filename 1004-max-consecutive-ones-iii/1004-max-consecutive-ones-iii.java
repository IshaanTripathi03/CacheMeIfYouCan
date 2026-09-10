class Solution {
    public int longestOnes(int[] nums, int k) {
        int left=0;
        int countZero=0,n=nums.length,max=0;
        for(int right=0;right<n;right++){
            if(nums[right]==0){
                countZero++;
            }
            if(countZero>k){
                if(nums[left]==0){
                    countZero--;
                }
                left++;
            }
            if(countZero<=k){
                max=Math.max(max,right-left+1);
            }
        }
        return max;
    }
}