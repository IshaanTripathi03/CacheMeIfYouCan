class Solution {
    public long countCommas(long n) {
        long result=0,start=1000,comm=1;
        while(start<=n){
            long end=Math.min(n,start*1000-1);
            result+=(end-start+1)*comm;
            start*=1000;
            comm++;
        }
        return result;
    }
}