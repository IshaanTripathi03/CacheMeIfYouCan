class Solution {
    public long sumAndMultiply(int n) {
        long sum=0,rev=0;
        while(n!=0){
            long k=n%10;
            if(k!=0){
                sum+=k;
                rev=rev*10+k;
            }
            n/=10;
        }
        long a=0;
        while(rev!=0){
            long k=rev%10;
            a=a*10+k;
            rev/=10;
        }
        return sum*a;
    }
}