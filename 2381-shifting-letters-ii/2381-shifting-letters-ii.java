class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n=s.length();
        int[] freq=new int[n+1];
        for(int row[]:shifts){
            int start=row[0];
            int end=row[1];
            int shift=row[2]==1?1:-1;
            freq[start]+=shift;
            freq[end+1]-=shift;
        }
        StringBuilder result=new StringBuilder();
        int shift=0;
        for(int i=0;i<n;i++){
            shift=(shift+freq[i])%26;
            if(shift<0){
                shift+=26;
            }
            char ch=(char)(((s.charAt(i)-'a'+shift)%26)+'a');
            result.append(ch);
        }
        return result.toString();
    }
}