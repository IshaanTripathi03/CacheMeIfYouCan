class Solution {
    static final int MOD=1_000_000_007;
    public int numberOfSets(int n, int k) {
        int N=n+k-1;
        int R=2*k;
        int[] prev=new int[R+1];
        prev[0]=1;
        for(int i=1;i<=N;i++){
            int front[]=new int[R+1];
            front[0]=1;
            for(int j=1;j<=R && j<=i;j++){
                front[j]=(prev[j-1]+prev[j])%MOD;
            }
            prev=front;
        }
        return prev[R];
    }
}