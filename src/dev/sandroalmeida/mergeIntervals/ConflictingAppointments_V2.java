package dev.sandroalmeida.mergeIntervals;

import java.util.Arrays;
import java.util.Comparator;

/*
* My solution considering the scope of the problem
* if it's related with appointments so the using an array
* if 24 size, one for each hour, will work fine
* this approach exclude the necessity for sorting the intervals
* */
public class ConflictingAppointments_V2 {

    public static boolean canAttendAllAppointments(Interval[] intervals){

        Arrays.sort(intervals, Comparator.comparingInt(a -> a.start));

        for(int i = 1; i < intervals.length; i++){
            if(intervals[i].start < intervals[i - 1].end)
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        Interval[] intervals = { new Interval(1, 4), new Interval(2, 5), new Interval(7, 9) };
        boolean result = ConflictingAppointments_V2.canAttendAllAppointments(intervals);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals1 = { new Interval(6, 7), new Interval(2, 4), new Interval(8, 12) };
        result = ConflictingAppointments_V2.canAttendAllAppointments(intervals1);
        System.out.println("Can attend all appointments: " + result);

        Interval[] intervals2 = { new Interval(4, 5), new Interval(2, 3), new Interval(3, 6) };
        result = ConflictingAppointments_V2.canAttendAllAppointments(intervals2);
        System.out.println("Can attend all appointments: " + result);
    }
}
