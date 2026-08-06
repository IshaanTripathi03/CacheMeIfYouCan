class Solution {
    public int smallestNumber(int n, int t) {
        for(int i=n;i<=n+10;i++){
            int num=i;
            int prod=1;
            while(num!=0){
                int digit=num%10;
                if(digit==0){
                    prod=0;
                    break;
                }
                prod*=digit;
                num/=10;
            }
            if(prod%t==0){
                return n;
            }
            n++;
        }
        return -1;
    }
}