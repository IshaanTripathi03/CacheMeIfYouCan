class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        for(int j=0;j<n;j++){
            int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
            int i=0;
            while(i<=j){
                max=Math.max(max,nums[i]);
                i++;
            }
            i=j;
            while(i<n){
                min=Math.min(min,nums[i]);
                i++;
            }
            if(max-min<=k){
                return j;
            }
        }
        return -1;
    }
}