class Solution {
    int gcd(int a,int b){
        return a%b==0?b:gcd(b,a%b);
        // if(a==0){
        //     return b;
        // }
        // if(b==0){
        //     return a;
        // }
        // if(a>b){
        //     return gcd(a%b,b);
        // }
        // else{
        //     return gcd(a,b%a);
        // }
    }
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int prefixGcd[]=new int[n];
        int mx=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            mx=Math.max(mx,nums[i]);
            prefixGcd[i]=gcd(mx,nums[i]);
        }
        Arrays.sort(prefixGcd);
        int left=0,right=n-1;
        long sum=0;
        while(left<right){
            sum+=gcd(prefixGcd[left],prefixGcd[right]);
            left++;
            right--;
        }
        return sum;
    }
}