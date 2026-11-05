class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length;
        int[] preSum=new int[n];
        int[] suffSum=new int[n];
        preSum[0]=nums[0];
        suffSum[n-1]=nums[n-1];
        for(int i=1;i<n;i++){
            preSum[i]=preSum[i-1]*nums[i];
            suffSum[n-i-1]=suffSum[n-i]*nums[n-i-1];
        }
        for(int i=0;i<n;i++){
            int pre=i>0?preSum[i-1]:1;
            int suff=i<n-1?suffSum[i+1]:1;
            nums[i]=pre*suff;
        }
        return nums;
    }
}