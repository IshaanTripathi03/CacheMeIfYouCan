class Solution {
    static void f(int open,int close,int n,List<String> list,StringBuilder sub){
        if(sub.length()==2*n){
            list.add(sub.toString());
            return;
        }
        if(open<n){
            f(open+1,close,n,list,sub.append('('));
            sub.deleteCharAt(sub.length() - 1);
        }
        if(close<open){
            f(open,close+1,n,list,sub.append(')'));
            sub.deleteCharAt(sub.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> list=new ArrayList<>();
        StringBuilder sub=new StringBuilder();
        f(0,0,n,list,sub);
        return list;
    }
}