class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        int[] freq1=new int[10];
        int[] freq2=new int[10];
        int min1=Integer.MAX_VALUE , min2=Integer.MAX_VALUE;
        for(int i:nums1){
            freq1[i]++;
            min1=Math.min(min1,i);
        }
        for(int i:nums2){
            freq2[i]++;
            min2=Math.min(min2,i);
        }
        for(int i=0;i<10;i++){
            if(freq1[i]+freq2[i]==2){
                return i;
            }
        }
        return Math.min(min1,min2)*10+Math.max(min1,min2);
    }
}