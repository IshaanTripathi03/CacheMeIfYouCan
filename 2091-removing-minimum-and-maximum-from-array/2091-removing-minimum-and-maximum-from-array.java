class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        int minIdx=-1,maxIdx=-1;
        for(int i=0;i<n;i++){
            if(min>nums[i]){
                min=nums[i];
                minIdx=i;
            }
            if(max<nums[i]){
                max=nums[i];
                maxIdx=i;
            }
        }
        int front = Math.max(minIdx, maxIdx) + 1;
        int back = Math.max(n - minIdx, n - maxIdx);

        int minFrontMaxBack = (minIdx + 1) + (n - maxIdx);
        int maxFrontMinBack = (maxIdx + 1) + (n - minIdx);

        return Math.min(
            Math.min(front, back),
            Math.min(minFrontMaxBack, maxFrontMinBack)
        );
    }
}