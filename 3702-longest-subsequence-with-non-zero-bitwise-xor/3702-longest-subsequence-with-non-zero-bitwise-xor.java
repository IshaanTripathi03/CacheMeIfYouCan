class Solution {
    public int longestSubsequence(int[] nums) {
        int xor=0;
        for(int i:nums){
            xor^=i;
        }
        int len=nums.length;
        if(xor!=0){
            return len;
        }
        for(int i:nums){
            if(i!=0){
                return --len;
            }
            
        }
        return 0;
    }
}