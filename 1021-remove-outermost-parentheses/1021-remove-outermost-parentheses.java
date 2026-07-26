class Solution {
    public String removeOuterParentheses(String s) {
        int count=0,prevCount=0;
        StringBuilder result=new StringBuilder();
        for(char ch:s.toCharArray()){
            if(ch=='('){
                prevCount=count;
                count++;
            }
            else{
                count--;
            }
            if(prevCount!=0 && count!=0){
                result.append(ch);
            }
        }
        return result.toString();
    }
}