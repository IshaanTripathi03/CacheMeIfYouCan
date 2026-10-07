class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>> map=new HashMap<>();
        for(String s:strs){
            int[] freq=new int[26];
            for(char ch:s.toCharArray()){
                freq[ch-'a']++;
            }
            StringBuilder key=new StringBuilder();
            for(int i:freq){
                key.append(i).append('#');
            }
            map.computeIfAbsent(key.toString(),k -> new ArrayList<>()).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
// static boolean check(String s1,String s2){
//     int n=s1.length();
//     int m=s2.length();
//     int[] st1=new int[26];
//     int[] st2=new int[26];
//     if(n!=m){
//         return false;
//     }
//     for(int i=0;i<n;i++){
//         st1[s1.charAt(i)-'a']++;
//         st2[s2.charAt(i)-'a']++;
//     }
//     for(int i=0;i<26;i++){
//         if(st1[i]!=st2[i]){
//             return false;
//         }
//     }
//     return true;
// }