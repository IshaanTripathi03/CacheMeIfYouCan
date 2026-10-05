class Solution {
    
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(char ch:s.toCharArray()){
            if(ch=='('){
                stack.push(0);
            }
            else{
                int top=stack.pop();
                int count;
                if(top==0){
                    count=1;
                }
                else{
                    count=2*top;
                }
                stack.push(stack.pop()+count);
            }
        }
        return stack.pop();
    }
}