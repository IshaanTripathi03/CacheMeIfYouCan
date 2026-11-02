class Solution {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int n=nums.length;
        int median=(n&1)==1?nums[n>>1]: (nums[n>>1]+nums[(n>>1)-1])/2;
        int moves=0;
        for(int i:nums){
            moves+=Math.abs(median-i);
        }
        return moves;
    }
}