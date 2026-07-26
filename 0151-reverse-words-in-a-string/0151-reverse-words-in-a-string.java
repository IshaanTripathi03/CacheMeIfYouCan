class Solution {
    public String reverseWords(String s) {
        StringBuilder result=new StringBuilder();
        s=" "+s;
        int n=s.length(),idx=n-1;
        boolean flag=true;
        for(int i=n-1;i>=0;i--){
            char ch=s.charAt(i);
            if(flag && Character.isLetterOrDigit(ch)){
                flag=false;
                idx=i;
            }
            else if(flag==false && ch == ' '){
                flag=true;
                result.append(s.substring(i,idx+1));
            }
        }
        result.deleteCharAt(0);
        return result.toString();
    }
}