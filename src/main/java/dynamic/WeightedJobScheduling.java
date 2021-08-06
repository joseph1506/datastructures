package dynamic;

import java.util.Arrays;
import java.util.Comparator;

public class WeightedJobScheduling {

    public static void main(String[] args) {
        Job jobs[] = {new Job(1, 2, 50), new Job(3, 5, 20),
                new Job(6, 19, 100), new Job(2, 100, 200)};

        System.out.println(maxProfitONSquare(jobs));
        System.out.println(maximumProfitOptimal(jobs));

    }

    // this is O(N2) logic using linear search
    private static int maxProfitONSquare(Job[] jobs) {
        Arrays.sort(jobs,endSorter);

        int[] profit= new int[jobs.length];
        for(int i=0;i<jobs.length;i++){
            profit[i]=jobs[i].profit;
        }

        for(int i=1;i<jobs.length;i++){
            Job iJob= jobs[i];

            for(int j=0;j<i;j++){
                Job jJob= jobs[j];
                if(!overlap(jJob,iJob)){
                    profit[i]= Math.max(profit[i],profit[j]+ iJob.profit);
                }
            }
        }

        int max=0;
        for(int i=0;i< jobs.length;i++){
            if(profit[i]>max) max=profit[i];
        }

        return max;
    }

    private static boolean overlap(Job jJob, Job iJob) {
        if(jJob.end>iJob.start) return true;

        return false;
    }


    public static class Job {
        int start;
        int end;
        int profit;

        public Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public static Comparator<Job> endSorter =  (o1,o2)->o1.end-o2.end;


    // Using binary search and NLogN solution
    public static int maximumProfitOptimal(Job[] jobs){
        //(1, 2, 50),(3, 5, 20),(6, 19, 100),(2, 100, 200)
        Arrays.sort(jobs,endSorter);   // nlogn

        int[] profit= new int[jobs.length];
        profit[0]= jobs[0].profit;

        for(int i=1;i< jobs.length;i++){

            // without scheduling current job
            int profitWithoutCurrentJob= profit[i-1];

            int lastNonOverlappingJobIndex= searchLastOverlappingJob(jobs,i);

            int profitConsideringCurrentJob=jobs[i].profit;
            if(lastNonOverlappingJobIndex!=-1){
                profitConsideringCurrentJob+=profit[lastNonOverlappingJobIndex];
            }
            profit[i]= Math.max(profitConsideringCurrentJob,profitWithoutCurrentJob);
        }
        return profit[jobs.length-1];
    }

    private static int searchLastOverlappingJob(Job[] jobs, int jobIndex) {
        int low=0,high=jobIndex-1;

        while(low<=high){
            int mid=(low+high)/2;

            if(jobs[mid].end<=jobs[jobIndex].start){
                if(jobs[mid+1].end<=jobs[jobIndex].start){
                    low=mid+1;
                }else {
                    return mid;
                }
            }else{
                high=mid-1;
            }
        }
        return -1;
    }

}
