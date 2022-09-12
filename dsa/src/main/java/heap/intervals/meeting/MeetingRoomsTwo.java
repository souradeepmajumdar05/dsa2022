package heap.intervals.meeting;

import java.util.*;


/**
 * also check https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/
 */
public class MeetingRoomsTwo {
    /**
     * Definition of Interval:*/
      public static class Interval {
          int start, end;
          Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
      }
    public static int canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start<o2.start?-1:1;
            }
        });
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int count=0;
        for(int i=0;i<intervals.size();i++){
            if(pq.isEmpty()){
               count++;
               pq.offer(intervals.get(i).end);
            }
            else{
                if(intervals.get(i).start>= pq.peek()){
                    pq.poll();
                }
                else
                {
                    count++;
                }
                pq.offer(intervals.get(i).end);
            }
        }
        return count;
    }
    public static void main(String[]args){
         testOne();
      //   testTwo();

    }

    private static void testTwo() {
        List<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(465,497));
        intervals.add(new Interval(386,462));
        intervals.add(new Interval(354,380));
        intervals.add(new Interval(134,189));
        intervals.add(new Interval(199,282));
        intervals.add(new Interval(18,104));
        intervals.add(new Interval(499,562));
        intervals.add(new Interval(4,14));
        intervals.add(new Interval(111,129));
        intervals.add(new Interval(292,345));
        System.out.println(canAttendMeetings(intervals));
    }

    private static void testOne() {
        List<Interval> intervals=new ArrayList<>();
        intervals.add(new Interval(0,30));
        intervals.add(new Interval(5,10));
        intervals.add(new Interval(15,10));
        System.out.println(canAttendMeetings(intervals));
    }
}
