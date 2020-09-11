package dev.sandroalmeida.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {

    public static Interval[] merge(Interval[] arr1, Interval[] arr2){
        List<Interval> result = new ArrayList<>();

        Interval interval1;
        Interval interval2;
        int count1 = 0, count2 = 0;

        while(count1 < arr1.length && count2 < arr2.length){
            interval1 = arr1[count1];
            interval2 = arr2[count2];

            // has intersection
            if((interval1.start >= interval2.start && interval1.start <= interval2.end) || (interval2.start >= interval1.start && interval2.start <= interval1.end)){
                result.add(new Interval(Math.max(interval1.start,interval2.start),Math.min(interval1.end, interval2.end)));
            }
            if(interval1.end < interval2.end)
                count1++;
            else
                count2++;

        }

        return result.toArray(new Interval[result.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
