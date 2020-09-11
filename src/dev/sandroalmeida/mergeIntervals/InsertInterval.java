package dev.sandroalmeida.mergeIntervals;

import java.util.ArrayList;
import java.util.List;

public class  InsertInterval {

    public static List<Interval> insert(List<Interval> intervals, Interval newInterval){

        List<Interval> mergedIntervals = new ArrayList<>();

        for(int i = 0; i < intervals.size(); i++){
            if(newInterval.start < intervals.get(i).start){
                int position = Math.max((i - 1), 0);
                intervals.add(position, newInterval);
                break;
            } else if(newInterval.start >= intervals.get(i).start && i == intervals.size() - 1){
                intervals.add(i + 1, newInterval);
                break;
            } else if(newInterval.start >= intervals.get(i).start && newInterval.start < intervals.get(i + 1).start){
                intervals.add(i + 1, newInterval);
                break;
            }
        }

        int start = intervals.get(0).start, end = intervals.get(0).end;
        for(int i = 1; i < intervals.size(); i++){
            int currentStart = intervals.get(i).start, currentEnd = intervals.get(i).end;
            if(currentStart <= end)
                end = Math.max(end, currentEnd);
            else{
                mergedIntervals.add(new Interval(start, end));
                start = currentStart;
                end = currentEnd;
            }
        }
        mergedIntervals.add(new Interval(start, end));

        return mergedIntervals;
    }

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Initial intervals: ");
        for (Interval interval : input)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Initial intervals: ");
        for (Interval interval : input)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Initial intervals: ");
        for (Interval interval : input)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }
}
