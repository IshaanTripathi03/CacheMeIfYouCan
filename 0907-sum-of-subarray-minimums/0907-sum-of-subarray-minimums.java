class Solution {
    static final int MOD=1_000_000_007;
    public int sumSubarrayMins(int[] arr) {
        int n=arr.length;
        int[] leftSmaller=new int[n];
        int[] rightSmaller=new int[n];
        ArrayDeque<Integer> st1=new ArrayDeque<>();
        ArrayDeque<Integer> st2=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            while(!st1.isEmpty() && arr[st1.peek()]>=arr[i]){
                st1.pop();
            }
            leftSmaller[i]=st1.isEmpty()?-1:st1.peek();
            st1.push(i);
        }
        
        for(int i=n-1;i>=0;i--){
            while(!st2.isEmpty() && arr[st2.peek()]>arr[i]){
                st2.pop();
            }
            rightSmaller[i]=st2.isEmpty()?n:st2.peek();
            st2.push(i);
        }
        
        long sum=0L;
        for(int i=0;i<n;i++){
            int left=i-leftSmaller[i];
            int right=rightSmaller[i]-i;
            long count=(long)left*right;
            sum=(sum+arr[i]*count)%MOD;
        }
        return (int)sum;
    }
}