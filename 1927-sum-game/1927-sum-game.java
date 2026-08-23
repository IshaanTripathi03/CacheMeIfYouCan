class Solution {
    public boolean sumGame(String num) {
        int n=num.length(),leftQ=0,rightQ=0,leftSum=0,rightSum=0;
        for(int i=0;i<n;i++){
            char ch=num.charAt(i);
            if(i<(n/2)){
                if(ch=='?'){
                    leftQ++;
                }
                else{
                    leftSum+=ch-'0';
                }
            }
            else{
                if(ch=='?'){
                    rightQ++;
                }
                else{
                    rightSum+=ch-'0';
                }
            }
        }
        if((leftQ+rightQ)%2==1){
            return true;
        }
        int diff=leftSum-rightSum;
        int possible=9*(rightQ-leftQ)/2;
        return diff!=possible;
    }
}