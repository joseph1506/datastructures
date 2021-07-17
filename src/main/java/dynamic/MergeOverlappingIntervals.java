package dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {
        Interval[] arr= new Interval[4];
        arr[0]=new Interval(6,8);
        arr[1]=new Interval(1,9);
        arr[2]=new Interval(2,4);
        arr[3]=new Interval(4,7);
        Stack<Interval> merged= mergeIntervals(arr);
        System.out.println("Merged---->");
        while(!merged.isEmpty()){
            System.out.println(merged.pop().toString());
        }

        Interval[] mergedItems=mergeIntervalsNoAdditionalSpace(arr);
        System.out.println("Diff Merged---->");
        printArray(mergedItems);

    }

    private static Stack<Interval> mergeIntervals(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return new Stack<>();

        Arrays.sort(intervals, sorter);
        System.out.println("Sorted---------------");
        printArray(intervals);
        System.out.println("Sorted---------------");
        Stack<Interval> merged= new Stack<>();
        merged.push(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            Interval interval= intervals[i];

            Interval topItem= merged.peek();

            if(topItem.end<interval.start){
                merged.push(interval);
            } else if(topItem.end<interval.end){
                merged.push(mergeTwoIntervals(interval,merged.pop()));
            }
        }
        return merged;
    }

    private static Interval[] mergeIntervalsNoAdditionalSpace(Interval[] intervals) {
        if(intervals==null || intervals.length==0) return intervals;

        Arrays.sort(intervals, sorter);
        //printArray(intervals);
        int lastIndex=0;
        for(int i=1;i<intervals.length;i++){
            Interval interval= intervals[i];

            Interval topItem= intervals[lastIndex];

            if(topItem.end<interval.start){
                //merged.push(interval);
                lastIndex=i;
            } else if(topItem.end<interval.end){
                topItem.end=interval.end;
                intervals[i]=null;
                //merged.push(mergeTwoIntervals(interval,merged.pop()));
            }else if(topItem.end>=interval.end){
                intervals[i]=null;
            }
        }
        return intervals;
    }

    private static Interval mergeTwoIntervals(Interval interval, Interval topPop) {
        topPop.end=interval.end;
        return topPop;
    }

    public static final Comparator<Interval> sorter= (o1,o2)-> o1.start-o2.start;

    public static void printArray(Interval[] arr){
        for(Interval interval:arr){
            if(interval!=null) System.out.println(interval.toString());
        }
    }
}



class Interval
{
    int start,end;
    Interval(int start, int end)
    {
        this.start=start;
        this.end=end;
    }

    @Override
    public String toString() {
        return "Interval{" +
                "start=" + start +
                ", end=" + end +
                '}';
    }
}
