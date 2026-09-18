class Solution {
    List<Integer> pascalRow(int n){
        List<Integer> row=new ArrayList<>();
        int r=1;
        row.add(r);
        for(int i=1;i<n;i++){
            r*=n-i;
            r/=i;
            row.add(r);
        }
        return row;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascalTri=new ArrayList<>();
        for(int i=1;i<=numRows;i++){
            pascalTri.add(pascalRow(i));
        }
        return pascalTri;
    }
}