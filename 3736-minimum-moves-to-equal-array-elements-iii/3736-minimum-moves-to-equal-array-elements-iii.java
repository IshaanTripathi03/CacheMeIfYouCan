class Solution {
    public int minMoves(int[] nums) {
        int max=Integer.MIN_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
        }
        int moves=0;
        for(int i:nums){
            moves+=Math.abs(max-i);
        }
        return moves;
    }
}