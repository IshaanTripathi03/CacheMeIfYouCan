class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int n=nums.length;
        int left=0,max1=0,max2=0,prev=-1;
        for(int right=0;right<n;right++){
            while(prev>=nums[right]){
                left=right;
                prev=-1;
            }
            max1=Math.max(max1,right-left+1);
            prev=nums[right];
        }
        left=0;prev=51;
        for(int right=0;right<n;right++){
            while(prev<=nums[right]){
                left=right;
                prev=51;
            }
            max2=Math.max(max2,right-left+1);
            prev=nums[right];
        }
        return Math.max(max1,max2);
    }
}