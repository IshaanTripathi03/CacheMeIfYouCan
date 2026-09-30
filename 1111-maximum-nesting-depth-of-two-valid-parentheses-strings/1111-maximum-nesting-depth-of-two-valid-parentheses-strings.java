class Solution {
    public int[] maxDepthAfterSplit(String seq) {
        int n=seq.length();
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            result[i]=(i&1)^(seq.charAt(i)=='('?0:1);
        }
        return result;
    }
}