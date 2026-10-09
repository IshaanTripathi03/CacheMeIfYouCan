class Solution {
    public int minInsertions(String s) {
        int open=0,close=0,result=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                open++;
            }
            else{
                if(i+1<n && s.charAt(i+1)==')'){
                    i++;
                }
                else{
                    result++;
                }
                if(open>0){
                    open--;
                }
                else{
                    result++;
                }
            }
        }
        return result+open*2;
    }
}