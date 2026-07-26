class Solution {
    public String removeOuterParentheses(String s) {
        int count=0,prevCount=0;
        String result="";
        for(char ch:s.toCharArray()){
            if(ch=='('){
                prevCount=count;
                count++;
            }
            else{
                count--;
            }
            if(prevCount!=0 && count!=0){
                result+=ch;
            }
        }
        return result;
    }
}