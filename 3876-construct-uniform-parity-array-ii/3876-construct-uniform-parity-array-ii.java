class Solution {
    public boolean uniformArray(int[] nums1) {
        int min=nums1[0];
        boolean isOdd=false;
        for(int i:nums1){
            min=Math.min(min,i);
            if((i&1)==1){
                isOdd=true;
            }
        }
        if((min&1)==1){
            return true;
        }
        return !isOdd;
    }
}