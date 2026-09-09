class Solution {
    public long countCommas(long n) {
        long result=0,start=1000;
        for (int i=1;i<=5;i++) {
            if (n >=start) {
                result += n - start + 1;
            }
            start *= 1000;
        }
        return result;
    }
}