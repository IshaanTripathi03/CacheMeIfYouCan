class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0,prod=1;
        int num=n;
        while(num!=0){
            int k=num%10;
            sum+=k;
            prod*=k;
            num/=10;
        }
        if(n%(sum+prod)==0){
            return true;
        }
        else{
            return false;
        }
    }
}