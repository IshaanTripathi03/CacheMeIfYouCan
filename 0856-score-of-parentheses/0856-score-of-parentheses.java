class Solution {
    public int scoreOfParentheses(String s) {
        Deque<Integer> stack=new ArrayDeque<>();
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