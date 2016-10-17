 /** Question Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
* For example,
* Given [[0, 30],[5, 10],[15, 20]],
* return 2
*/
package javaapplication_test.PriorityQueue;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Sony
 * Data Structure: PriorityQueue
 * Algorithm: sort with Comparator
 * Implement three ways for implementation of Comparator interface
 * Implementation 1: using comparator as anonymous class;
 * Implementation 2: using comparator as new object with new class;
 * Implementation 3: a simpler version of No.2, using comparator as new object without new class;
 */
public class MeetingRooms {
    public static void main(String args[]) {
        //for testing only
        Interval l1 = new Interval(0, 30);
        Interval l2 = new Interval(5, 10);
        Interval l3 = new Interval(15, 20);
        Interval[] result = new Interval[] {l1,l2,l3};
        System.out.println(minRoom(result));
    }
    public static int minRoom(Interval[] intervals) {
        //key point 1: the generic type Comparator<T> should be there, as compare is not overriding (object, object)
        
        Arrays.sort(intervals, new Comparator<Interval>(){ 
 @Override
 public int compare(Interval l1, Interval l2) {
                return l1.start - l2.start;
            }
        });
        //key point 2: Integer is enough in queue
        PriorityQueue<Integer> queue = new PriorityQueue<>(); 
        queue.add(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start > queue.peek()) {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }
        return queue.size();
    }
}
class Interval {
    public Interval(int s, int e) {
        start = s;
        this.end = e;
    }
    public int start;
    public int end;
}
class MeetingRooms2 {
    public int minMeetingRooms(Interval[] intervals) {
        MyComparator comp = new MyComparator();
        Arrays.sort(intervals, comp);
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (Interval ele : intervals) {
            if (!q.isEmpty() && ele.start >= q.peek()) {
                 q.poll();
            }
            q.offer(ele.end);
        }
        return q.size();
    }
    

class MyComparator implements Comparator<Interval> {
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }
}
}
class MeetingRooms3 implements Comparator<Interval>{
    public int minMeetingRooms(Interval[] intervals) {
        MeetingRooms3 comp = new MeetingRooms3();
        Arrays.sort(intervals, comp);
        PriorityQueue<Integer> q = new PriorityQueue<Integer>();
        for (Interval ele : intervals) {
            if (!q.isEmpty() && ele.start >= q.peek()) {
                 q.poll();
            }
            q.offer(ele.end);
        }
        return q.size();
    }
    
    public int compare(Interval i1, Interval i2) {
        return i1.start - i2.start;
    }
}
