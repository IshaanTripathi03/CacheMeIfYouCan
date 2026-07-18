class Solution {
    int gcd(int a,int b){
        return a%b==0?b:gcd(b%a,a);
    }
    public int findGCD(int[] nums) {
        int max=-1,min=Integer.MAX_VALUE;
        for(int i:nums){
            max=Math.max(max,i);
            min=Math.min(min,i);
        }
        return gcd(max,min);
    }
}