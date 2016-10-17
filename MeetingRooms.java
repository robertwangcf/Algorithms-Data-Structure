/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication_test;
import java.util.*;
import java.lang.*;

/**
 *
 * @author Sony
 */
public class MeetingRooms {
    public static void main(String args[]) {
        Interval l1 = new Interval(0, 30);
        Interval l2 = new Interval(5, 10);
        Interval l3 = new Interval(15, 20);
        Interval[] result = new Interval[] {l1,l2,l3};
        System.out.println(minRoom(result));
    }
    public static int minRoom(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>(){ 
 @Override
 public int compare(Interval l1, Interval l2) {
                return l1.start - l2.start;
            }
        });
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
