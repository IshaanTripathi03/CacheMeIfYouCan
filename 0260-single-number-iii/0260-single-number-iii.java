class Solution {
    public int[] singleNumber(int[] nums) {
        long xor=0;
        for(int i:nums){
            xor^=i;
        }
        long rightmost=(xor&(xor-1))^xor;
        int b1=0,b2=0;
        for(int i:nums){
            if((rightmost&i)==0){
                b1^=i;
            }
            else{
                b2^=i;
            }
        }
        return new int[]{b1,b2};
    }
}