class Solution {
    public int maxProfit(int[] prices) {
        int min=Integer.MAX_VALUE,max=-1;
        for(int i:prices){
            min=Math.min(min,i);
            max=Math.max(max,i-min);
        }
        return max;
    }
}