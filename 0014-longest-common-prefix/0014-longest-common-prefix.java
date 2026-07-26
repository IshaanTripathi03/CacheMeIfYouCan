class Solution {
    public String longestCommonPrefix(String[] strs) {
        int min=Integer.MAX_VALUE;
        String a="";
        for(String s:strs){
            if(min>s.length()){
                min=s.length();
                a=s;
            }
        }
        String result="";
        for(int j=0;j<min;j++){
            char ch=a.charAt(j);
            for(int i=0;i<strs.length;i++){
                if(strs[i].charAt(j)==ch){
                    if(i==strs.length-1)    result+=ch;
                }
                else{
                    return result;
                }
            }
        }
        return result;
    }
}