class Solution {
    static boolean check(String s1,String s2){
        int n=s1.length();
        int m=s2.length();
        int[] st1=new int[26];
        int[] st2=new int[26];
        if(n!=m){
            return false;
        }
        for(int i=0;i<n;i++){
            st1[s1.charAt(i)-'a']++;
            st2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<26;i++){
            if(st1[i]!=st2[i]){
                return false;
            }
        }
        return true;
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        int n=strs.length;
        boolean flag[]=new boolean[n];
        List<List<String>> result=new ArrayList<>();
        for(int i=0;i<n;i++){
            List<String> sub=new ArrayList<>();
            if(flag[i]){
                continue;
            }
            sub.add(strs[i]);
            flag[i]=true;
            for(int j=i+1;j<n;j++){
                if(!flag[j] && check(strs[i],strs[j])){
                    sub.add(strs[j]);
                    flag[j]=true;
                }
            }
            result.add(sub);
        }
        return result;
    }
}