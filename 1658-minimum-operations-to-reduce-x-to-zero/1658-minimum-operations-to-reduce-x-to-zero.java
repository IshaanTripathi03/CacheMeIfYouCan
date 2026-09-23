class Solution {
    public int minOperations(int[] nums, int x) {
        int n=nums.length;
        int totalSum=0;
        for(int i:nums){
            totalSum+=i;
        }
        int target=totalSum-x;
        int left=0,max=-1,sum=0;
        for(int right=0;right<n;right++){
            sum+=nums[right];
            while(left<=right && sum>target){
                sum-=nums[left];
                left++;
            }
            if(sum==target){
                max=Math.max(max,right-left+1);
            }
        }
        return max==-1?max:n-max;
    }
}