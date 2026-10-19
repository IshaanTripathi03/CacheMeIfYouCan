class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> st=new Stack<>();
        int n=heights.length;
        int[] leftSmall=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftSmall[i]=0;
            }
            else{
                leftSmall[i]=st.peek()+1;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        int[] rightSmall=new int[n];
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightSmall[i]=n-1;
            }
            else{
                rightSmall[i]=st.peek()-1;
            }
            st.push(i);
        }
        int max=-1;
        for(int i=0;i<n;i++){
            max=Math.max(max,(rightSmall[i]-leftSmall[i]+1)*heights[i]);
        }
        return max;
    }
}