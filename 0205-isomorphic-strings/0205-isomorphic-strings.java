class Solution {
    public boolean isIsomorphic(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        int smap[]=new int[256];
        int tmap[]=new int[256];
        for(int i=0;i<s.length();i++){
            int ch1=s.charAt(i);
            int ch2=t.charAt(i);
            if(smap[ch1]!=tmap[ch2]){
                return false;
            }
            smap[ch1]=i+1;
            tmap[ch2]=i+1;
        }
        return true;
    }
}
// HashMap<Character,Character> st=new HashMap<>();
// HashMap<Character,Character> ts=new HashMap<>();
// if(n1!=n2){
//     return false;
// }
// for(int i=0;i<n1;i++){
//     char ch1=s.charAt(i);
//     char ch2=t.charAt(i);
//     if(st.containsKey(ch1) && st.get(ch1)!=ch2){
//         return false;
//     }
//     if(ts.containsKey(ch2) && ts.get(ch2)!=ch1){
//         return false;
//     }
//     st.put(ch1,ch2);
//     ts.put(ch2,ch1);
// }
// return true;