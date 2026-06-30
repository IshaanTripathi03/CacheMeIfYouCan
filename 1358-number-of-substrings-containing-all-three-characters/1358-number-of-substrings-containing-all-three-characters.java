class Solution {
    public int numberOfSubstrings(String s) {
        int n=s.length();
        // HashMap<Character,Integer> map=new HashMap<>();
        int[] freq=new int[3];
        // map.put('a',0);
        // map.put('b',0);
        // map.put('c',0);
        int left=0,count=0;
        for(int right=0;right<n;right++){
            // map.put(s.charAt(right),map.get(s.charAt(right))+1);
            freq[s.charAt(right)-'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0){
                count+=n-right;
                // map.put(s.charAt(left),map.get(s.charAt(left))-1);
                freq[s.charAt(left)-'a']--;
                left++;
            }
        }
        return count;
    }
}