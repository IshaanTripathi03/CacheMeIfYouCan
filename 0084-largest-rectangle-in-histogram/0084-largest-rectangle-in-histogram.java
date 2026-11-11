class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] leftIdx=new int[n];
        int[] rightIdx=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                leftIdx[i]=0;
            }
            else{
                leftIdx[i]=st.peek()+1;
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            st.pop();
        }
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()){
                rightIdx[i]=n-1;
            }
            else{
                rightIdx[i]=st.peek()-1;
            }
            st.push(i);
        }
        int maxArea=0;
        for(int i=0;i<n;i++){
            int area=(rightIdx[i]-leftIdx[i]+1)*heights[i];
            maxArea=Math.max(maxArea,area);
        }
        return maxArea;
    }
}