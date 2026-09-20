class Solution {
    public int reverseDegree(String s) {
        int n=s.length(),sum=0;
        for(int i=0;i<n;i++){
            int ch=26-(s.charAt(i)-'a');
            sum+=(ch*(i+1));
        }
        return sum;
    }
}