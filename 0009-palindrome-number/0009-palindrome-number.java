class Solution {
    public boolean isPalindrome(int x) {
        int n=x,rev=0;
        while(n!=0){
            int k=n%10;
            rev=rev*10+k;
            n/=10;
        }
        if(rev==Math.abs(x)){
            return true;
        }
        else{
            return false;
        }
    }
}