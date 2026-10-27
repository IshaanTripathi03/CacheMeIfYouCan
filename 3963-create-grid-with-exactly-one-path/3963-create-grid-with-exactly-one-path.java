class Solution {
    public String[] createGrid(int m, int n) {
        String[] result=new String[m];
        StringBuilder s=new StringBuilder();
        for(int i=0;i<n;i++){
            s.append('.');
        }
        result[0]=s.toString();
        for(int i=1;i<m;i++){
            StringBuilder subStr=new StringBuilder();
            for(int j=0;j<n;j++){
                if(j==n-1){
                    subStr.append('.');
                }
                else{
                    subStr.append('#');
                }
            }
            result[i]=subStr.toString();
        }
        return result;
    }
}