class Solution {
    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int sum=0,n=x;
        while(n!=0){
            int k=n%10;
            sum+=k;
            n/=10;
        }
        return (x%sum==0)?sum:-1;
    }
}