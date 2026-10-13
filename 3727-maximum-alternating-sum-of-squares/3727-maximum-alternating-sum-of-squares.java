class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            nums[i]=Math.abs(nums[i]);
        }
        Arrays.sort(nums);
        long sum=0;
        for(int i=0;i<n>>1;i++){
            sum-=(long)nums[i]*nums[i];
        }
        for(int i=n>>1;i<n;i++){
            sum+=(long)nums[i]*nums[i];
        }
        return sum;
    }
}