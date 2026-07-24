class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length,n=nums2.length;
        int l=0,r=0;
        List <Integer> result=new ArrayList<>();
        while(l<m && r<n){
            if(nums1[l]<nums2[r]){
                result.add(nums1[l++]);
            }
            else{
                result.add(nums2[r++]);
            }
        }
        while(l<m){
            result.add(nums1[l++]);
        }
        while(r<n){
            result.add(nums2[r++]);
        }
        if((m+n)%2==1){
            return result.get((m+n)/2);
        }
        else{
            return ((double)result.get((m+n)/2)+result.get(((m+n)/2)-1))/2;
        }
    }
}