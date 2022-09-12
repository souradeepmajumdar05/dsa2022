package amazon.meeting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MeetingRooms {
    /**
     * Definition of Interval:*/
      public static class Interval {
          int start, end;
          Interval(int start, int end) {
              this.start = start;
              this.end = end;
          }
      }
    public static boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start<o2.start?-1:1;
            }
        });
        for(int i=1;i<intervals.size();i++)
        {
            if(intervals.get(i-1).end>intervals.get(i).start)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[]args){
      //    testOne();
          testTwo();

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
