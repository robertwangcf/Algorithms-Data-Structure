package Sort;

import java.util.*;

/**
 * Created by Robert on 5/12/2018.
 */


class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {
    public static void main(String args[]) {
        //for testing only
        Interval firstInterval = new Interval(1, 4);
        Interval secondInterval = new Interval(1, 5);
        List<Interval> intervals = new ArrayList<>();
        intervals.add(firstInterval);
        intervals.add(secondInterval);
        merge(intervals).forEach(i -> {
            System.out.print(i.start);
            System.out.print(i.end);
        });
    }

    public static List<Interval> merge(List<Interval> intervals) {
        Collections.sort(intervals, (i1, i2) -> {
            if (i1.end == i2.end) {
                return i2.start - i1.start;
            }
            return i2.end - i1.end;
        });
        final Stack<Interval> comparisonStack = new Stack<>();
        for (Interval interval : intervals) {
            if (comparisonStack.isEmpty()) {
                comparisonStack.push(interval);
            } else {
                Interval newInterval = popAndCombineIntervals(comparisonStack, interval);
                comparisonStack.push(newInterval);
            }
        }
        //Collect result
        List<Interval> ret = new LinkedList<>();
        while (!comparisonStack.isEmpty()) {
            ret.add(comparisonStack.pop());
        }
        return ret;
    }

    private static Interval popAndCombineIntervals(Stack<Interval> comparisonStack, Interval nextInterval) {
        Interval lastInterval = comparisonStack.peek();
        if (lastInterval.start <= nextInterval.end) {
            lastInterval = comparisonStack.pop();
            return new Interval(nextInterval.start, lastInterval.end);
        }
        return nextInterval;
    }
}
