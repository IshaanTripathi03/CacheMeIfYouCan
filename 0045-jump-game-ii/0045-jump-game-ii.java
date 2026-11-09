class Solution {
    public int jump(int[] nums) {
        int currentEnd=0,farthest=0,jump=0,n=nums.length;
        for(int i=0;i<n-1;i++){
            farthest=Math.max(farthest,i+nums[i]);
            if(currentEnd==i){
                jump++;
                currentEnd=farthest;
            }
        }
        return jump;
    }
}