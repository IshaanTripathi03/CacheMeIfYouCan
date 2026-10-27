class Solution {
    public String[] createGrid(int m, int n) {
        String[] result=new String[m];
        result[0]="";
        for(int i=0;i<n;i++){
            result[0]=result[0]+".";
        }
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