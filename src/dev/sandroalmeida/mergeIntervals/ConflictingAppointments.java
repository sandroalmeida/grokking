package dev.sandroalmeida.mergeIntervals;

/*
* My solution considering the scope of the problem
* if it's related with appointments so the using an array
* if 24 size, one for each hour, will work fine
* this approach exclude the necessity for sorting the intervals
* */
public class ConflictingAppointments {

    public static boolean canAttendAllAppointments(Interval[] intervals){

        Integer[] calendar = new Integer[24];
        for(Interval i : intervals){
            int start = i.start;
            while(start <= i.end){
                if(calendar[start] == null){
                    calendar[start] = start;
                    start++;
                } else{
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
