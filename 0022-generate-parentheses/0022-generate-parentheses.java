class Solution {
    void f(int open,int close,StringBuilder sb,List<String> result,int n){
        if(sb.length()==2*n){
            result.add(sb.toString());
            return;
        }
        if(open<n){
            f(open+1,close,sb.append('('),result,n);
            sb.deleteCharAt(sb.length()-1);
        }
        if(close<open){
            f(open,close+1,sb.append(')'),result,n);
            sb.deleteCharAt(sb.length()-1);
        }
        
    }
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        StringBuilder sb=new StringBuilder();
        f(0,0,sb,result,n);
        return result;
    }
}