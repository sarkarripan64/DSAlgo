package ds.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by sarkarri on 2/15/17.
 */
public class MergeOverlappingIntervals {
    public static void main(String[] args) {
        ArrayList<Interval> x = new ArrayList<Interval>();
        Interval i1 = new Interval(1, 2);
        Interval i2 = new Interval(2, 6);
        Interval i3 = new Interval(7, 10);
        Interval i4 = new Interval(11, 18);

        x.add(i1);
        x.add(i2);
        x.add(i3);
        x.add(i4);

        List<Interval> res = merge(x);
        for (Interval i : res) {
            System.out.println(i);
        }
    }

    static List<Interval> merge(List<Interval> iList) {
        Collections.sort(iList, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.startTime - o2.startTime;
            }
        });

        Interval prevIntvl = iList.get(0);
        List<Interval> res = new ArrayList<>();
        for (int i = 1; i < iList.size(); i++) {
            Interval curIntvl = iList.get(i);
            if (curIntvl.startTime < prevIntvl.endTime) {
                prevIntvl.setEndTime(prevIntvl.endTime > curIntvl.endTime ? prevIntvl.endTime : curIntvl.endTime);
            } else {
                res.add(prevIntvl);
                prevIntvl = curIntvl;
            }
        }

        res.add(prevIntvl);

        return res;
    }
}

class Interval {
    int startTime;
    int endTime;

    public Interval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}