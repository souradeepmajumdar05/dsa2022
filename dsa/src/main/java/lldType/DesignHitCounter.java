package lldType;

import java.util.LinkedList;
import java.util.Queue;

public class DesignHitCounter {
    Queue<Integer> hits;
    /** Initialize your data structure here. */
    public DesignHitCounter() {
        hits = new LinkedList<Integer>();
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        hits.add(timestamp);
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        while (hits.size() > 0 && hits.peek() <= timestamp - 300) {
            hits.poll();
        }
        return hits.size();

    }
}
