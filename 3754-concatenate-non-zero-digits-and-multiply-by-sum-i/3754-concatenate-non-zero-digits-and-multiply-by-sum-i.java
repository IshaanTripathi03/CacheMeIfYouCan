class Solution {
    public long sumAndMultiply(int n) {
        int sum=0,x=0;
        int i=1;
        while(n!=0){
            int k=n%10;
            n/=10;
            if(k==0){
                continue;
            }
            sum+=k;
            x+=(k*i);
            i*=10;
        }
        return (long)sum*x;
    }
}