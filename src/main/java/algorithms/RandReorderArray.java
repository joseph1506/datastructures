package algorithms;

public class RandReorderArray {
    public static void main(String[] args) {
        int[] numbers= {1,0,3,9,2};
        reOrderArray(numbers);
        for(int j:numbers){
            System.out.print(j);
        }
    }

    private static void reOrderArray(int[] numbers) {
        for(int i=numbers.length-1;i>0;i--){
            int pick = (int) Math.floor((i+1)* Math.random());
            int temp = numbers[i];
            numbers[i] = numbers[pick];
            numbers[pick]= temp;
        }
    }
}
