class Solution {
    public boolean uniformArray(int[] nums1) {
        int n=nums1.length,counter=0;
        boolean[] check=new boolean[n];
        int minOdd=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if((nums1[i]&1)==0){
                check[i]=true;
                counter++;
            }
            else{
                minOdd=Math.min(minOdd,nums1[i]);
            }
        }
        if(counter==n || counter==0){
            return true;
        }
        for(int i=0;i<n;i++){
            if(check[i]==true && nums1[i]>minOdd){
                counter--;
            }
        }
        return counter==0;
    }
}