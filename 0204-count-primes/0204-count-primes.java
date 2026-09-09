class Solution {
    public int countPrimes(int n) {
        if(n<=2){
            return 0;
        }
        boolean[] nums=new boolean[n+1];        
        for(int i=2;i*i<=n;i++){
            if(nums[i]==false){
                for(int j=i*i;j<=n;j+=i){
                    nums[j]=true;
                }
            }
        }
        int count=0;
        for(int i=2;i<n;i++){
            if(nums[i]==false){
                count++;
            }
        }
        return count;
    }
}