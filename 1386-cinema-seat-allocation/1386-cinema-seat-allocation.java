class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats,(a,b)->Integer.compare(a[0],b[0]));        
        int seatAlloted=0;
        int idx=0;
        int reservedRow=0;
        while(idx<reservedSeats.length){
            int currenRow=reservedSeats[idx][0];
            int row[]=new int[10];
            while(idx<reservedSeats.length && reservedSeats[idx][0]==currenRow){
                int seat=reservedSeats[idx][1];
                row[seat-1]=1;
                idx++;
            }
            reservedRow++;
            boolean left=(row[1]==0 && row[2]==0 && row[3]==0 && row[4]==0);
            boolean right=(row[5]==0 && row[6]==0 && row[7]==0 && row[8]==0);
            boolean mid=(row[3]==0 && row[4]==0 && row[5]==0 && row[6]==0);
            if(left){
                seatAlloted++;
            }
            if(right){
                seatAlloted++;
            }
            if(!left && !right && mid){
                seatAlloted++;
            }
        }
        seatAlloted+=(n-reservedRow)*2;
        return seatAlloted;
    }
}