class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0,n=nums.length;
        boolean isZero=true;
        for(int i:nums){
            xor^=i;
            if(i!=0){
                isZero=false;
            }
        }
        if(xor!=0){
            return nums.length;
        }
        else{
            return isZero?0:n-1;
        }
    }
}