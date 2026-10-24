class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String Arrival=arriveAlice.compareTo(arriveBob)<0?arriveBob:arriveAlice;
        String Departure=leaveAlice.compareTo(leaveBob)<0?leaveAlice:leaveBob;
        if(Departure.compareTo(Arrival)<0){
            return 0;
        }
        int monthArrival=Integer.parseInt(Arrival.substring(0,2));
        int monthDeparture=Integer.parseInt(Departure.substring(0,2));
        int dayArrival=Integer.parseInt(Arrival.substring(3));
        int dayDeparture=Integer.parseInt(Departure.substring(3));
        int[] nums={31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        int countDays=0;
        while(monthArrival<12 && monthArrival!=monthDeparture){
            countDays+=nums[monthArrival-1]-dayArrival+1;
            dayArrival=1;
            monthArrival++;
        }
        return countDays+=dayDeparture-dayArrival+1;
    }
}