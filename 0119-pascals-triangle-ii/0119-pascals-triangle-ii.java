class Solution {
    public List<Integer> getRow(int rowIndex) {
        long row=1;
        rowIndex++;
        List<Integer> result=new ArrayList<>();
        result.add((int)row);
        for(int i=1;i<rowIndex;i++){
            row*=(rowIndex-i);
            row/=i;
            result.add((int)row);
        }
        return result;
    }
}