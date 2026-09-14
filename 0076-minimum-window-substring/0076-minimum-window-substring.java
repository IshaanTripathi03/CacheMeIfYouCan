class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 ||
                s.length() < t.length()) {
            return new String();
        }
        int[] freq=new int[256];
        // HashMap<Character,Integer> map=new HashMap<>();
        for(char ch:t.toCharArray()){
            // map.put(ch,map.getOrDefault(ch,0)+1);
            freq[ch]++;
        }
        int n=s.length(), m=t.length();
        int left=0;
        int minlen=Integer.MAX_VALUE,count=0;
        String result="";
        for(int right=0;right<n;right++){
            char ch=s.charAt(right);
            // if(map.containsKey(ch) && map.get(ch)>0){
            //     count++;
            // }
            if(freq[ch]>0){
                count++;
            }
            // map.put(ch,map.getOrDefault(ch,0)-1);
            freq[ch]--;
            while(count==m){
                char lftch=s.charAt(left);
                if(minlen>right-left+1){
                    minlen=right-left+1;
                    result=s.substring(left,right+1);
                }
                // map.put(lftch,map.get(lftch)+1);
                freq[lftch]++;
                // if(map.get(lftch)>0){
                //     count--;
                // }
                if(freq[lftch]>0){
                    count--;
                }
                left++;
            }
        }
        return result;
    }
}