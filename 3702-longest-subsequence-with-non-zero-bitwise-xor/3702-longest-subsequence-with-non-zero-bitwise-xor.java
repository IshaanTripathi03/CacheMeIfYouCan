class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0,countZero=0;
        for(int i:nums){
            xor^=i;
            if(i==0){
                countZero++;
            }
        }
        if(xor!=0){
            return nums.length;
        }
        if(countZero==nums.length){
            return 0;
        }
        else{
            return nums.length-1;
        }
    }
}