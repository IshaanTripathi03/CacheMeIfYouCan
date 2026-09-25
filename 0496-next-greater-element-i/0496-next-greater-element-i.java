class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n=nums1.length;
        int m=nums2.length;
        for(int i=0;i<n;i++){
            int val=nums1[i];
            for(int j=0;j<m;j++){
                if(val==nums2[j]){
                    int k=j;
                    int max=-1;
                    while(k<m && val>=nums2[k]){
                        k++;
                    }
                    if(k<m){
                        max=nums2[k];
                    }
                    nums1[i]=max;
                }
            }
        }
        return nums1;
    }
}