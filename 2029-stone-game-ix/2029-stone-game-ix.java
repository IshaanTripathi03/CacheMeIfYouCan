class Solution {
    public boolean stoneGameIX(int[] stones) {
        int n=stones.length;
        int freq[]=new int[3];
        for(int i:stones){
            freq[i%3]++;
        }
        
        if(freq[0]%2==0){
            return freq[1]>0 && freq[2]>0;
        }
        return Math.abs(freq[1]-freq[2])>2;
    }
}