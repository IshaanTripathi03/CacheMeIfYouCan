class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE , sum=0 , n=nums.length;;
        for(int i:nums){
            min=Math.min(min,i);
            sum+=i;
        }
        return sum-(n*min);
    }
}