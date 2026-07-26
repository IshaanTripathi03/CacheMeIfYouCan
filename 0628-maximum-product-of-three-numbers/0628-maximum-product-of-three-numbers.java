class Solution {
    public int maximumProduct(int[] nums) {
        int max1=Integer.MIN_VALUE,max2=Integer.MIN_VALUE,max3=Integer.MIN_VALUE;
        int min1=Integer.MAX_VALUE,min2=Integer.MAX_VALUE;
        for(int i:nums){
            if(max1<i){
                max3=max2;
                max2=max1;
                max1=i;
            }
            else if(max2<i){
                max3=max2;
                max2=i;
            }
            else if(max3<i){
                max3=i;
            }
            if(min1>i){
                min2=min1;
                min1=i;
            }
            else if(min2>i){
                min2=i;
            }
        }
        return Math.max(max1*max2*max3 , min1*min2*max1);
    }
}