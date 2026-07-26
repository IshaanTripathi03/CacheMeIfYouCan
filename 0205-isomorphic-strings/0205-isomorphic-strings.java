class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character,Character> st=new HashMap<>();
        HashMap<Character,Character> ts=new HashMap<>();
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2){
            return false;
        }
        for(int i=0;i<n1;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            if(st.containsKey(ch1) && st.get(ch1)!=ch2){
                return false;
            }
            if(ts.containsKey(ch2) && ts.get(ch2)!=ch1){
                return false;
            }
            st.put(ch1,ch2);
            ts.put(ch2,ch1);
        }
        return true;
    }
}
