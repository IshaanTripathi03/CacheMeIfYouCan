class Solution {
    public int scoreOfParentheses(String s) {
        int n=s.length(),count=0;
        int points=0;
        for(int i=0;i<n;i++){
            if(s.charAt(i)=='('){
                count++;
            }
            else{
                count--;
                if(s.charAt(i-1)=='('){
                    points+=1<<count;
                }
            }
        }
        return points;
    }
}