package amazon.maximum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaximumNumberofVisiblePoints {
    public int visiblePoints(List<List<Integer>> points, int angle, List<Integer> location)
    {
        int same = 0, res = 0;
        List<Double> as = new ArrayList<>();

        for (List<Integer> p : points)
        {
            int dy = p.get(1) - location.get(1),
                    dx = p.get(0) - location.get(0);

            if (dy == 0 && dx == 0)
            {
                same++; // same point with location l;
                continue;
            }
            double agl = Math.atan2(dy, dx) * (180 / Math.PI);

            as.add(agl);
            as.add(agl + 360); // get rid of negative;
        }
        Collections.sort(as);
        for (int i = 0, j = 0; i < as.size(); i++)
        {
            while(as.get(i) - as.get(j) > angle)
                j++;

            res = Math.max(res, i - j + 1);
        }
        return res + same;
    }

}
