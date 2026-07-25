class Solution {
    public int maxProduct(int n) {
        int firstMax=-1,secondMax=-1;
        while(n!=0){
            int k=n%10;
            if(k>firstMax){
                secondMax=firstMax;
                firstMax=k;
            }
            else if(secondMax<k){
                secondMax=k;
            }
            n/=10;
        }
        return firstMax*secondMax;
    }
}