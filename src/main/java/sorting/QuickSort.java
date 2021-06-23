package sorting;

/* low  --> Starting index,  high  --> Ending index */
/*
    quickSort(arr[], low, high)  {
        if (low < high)
        {

    /* pi is partitioning index, arr[pi] is now
           at right place *//*

        pi = partition(arr, low, high);

        quickSort(arr, low, pi - 1);  // Before pi
        quickSort(arr, pi + 1, high); // After pi
        }
        }
*/


public class QuickSort {

    public static void main(String[] args) {
        //int[] numbers = {1,4,8,2,10,20,11,12};
        int[] numbers = {1,4,4,2,10,2,12,12};
        quicksort(numbers,0,7);
        System.out.printf(numbers.toString());
    }

    public static void quicksort(int numbers[],int low, int high){
        if(low<high){
            int pi= partition(numbers,low,high);

            quicksort(numbers,low,pi-1);
            quicksort(numbers,pi+1,high);
        }
    }

    private static int partition(int[] numbers, int low, int high) {
        int pivot= numbers[high];
        int i= low-1;

        for(int j=low;j<=high-1;j++){
            if(numbers[j]<pivot){
                i++;
                swap(numbers,i,j);
            }
        }
        swap(numbers,i+1,high);
        return i+1;
    }

    private static void swap(int[] numbers, int i, int j){
        int temp= numbers[i];
        numbers[i]=numbers[j];
        numbers[j]=temp;
    }


}
