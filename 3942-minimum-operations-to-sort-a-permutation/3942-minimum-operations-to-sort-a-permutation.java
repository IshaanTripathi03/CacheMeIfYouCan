class Solution {
    public int minOperations(int[] nums) {
        int idx=0;
        int n=nums.length;
        while(nums[idx]!=0){
            idx++;
        }
        boolean isAsc=true,isDec=true;
        for(int i=1;i<n;i++){
            int value=nums[(idx+i)%n];
            
            if(value!=i){
                isAsc=false;
            }
            if(value!=n-i){
                isDec=false;
            }
            if(!isAsc && !isDec){
                return -1;
            }
        }
        int result;
        if(isAsc){
            return Math.min(idx,n-idx+2);
        }
       
            return Math.min(n-idx,idx+2);
        
        
    }
}