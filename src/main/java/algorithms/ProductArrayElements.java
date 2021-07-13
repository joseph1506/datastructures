package algorithms;

/*input: array of integers
output: array of intergers
logic: each position in output array should contain the product of other positions in the input array without using division
eg
input : [1,2,4,5]
output: [2*4*5, 1*4*5, 1*2*5, 1*2*4]*/


public class ProductArrayElements {


    public static void main(String[] args) {
        //int[] elements= new int[]{1,4,2,6,3,7,8,9};
        int[] elements= new int[]{3,4,6,2,7};
        int[] product= properAlgo(elements);
        System.out.println(product);
    }

    private static int[] greedyAlgo(int[] elements) {

        int[] beforeNumberProduct= new int[elements.length];
        int beforeProduct=1;

        for(int i=0;i<elements.length;i++){
            if(i==0){
                beforeNumberProduct[i]=beforeProduct;
            }else{
                beforeProduct=beforeProduct*elements[i-1];
                beforeNumberProduct[i]=beforeProduct;
            }
        }
        System.out.println(beforeNumberProduct);

        int[] afterNumberProduct= new int[elements.length];
        int afterProduct=1;

        for(int i=elements.length-1;i>=0;i--){
            if(i==elements.length-1){
                afterNumberProduct[i]=afterProduct;
            }else{
                afterProduct=afterProduct*elements[i+1];
                afterNumberProduct[i]=afterProduct;
            }
        }
        System.out.println(afterNumberProduct);


        int[] product= new int[elements.length];

        for(int i=0;i<elements.length;i++){
            product[i]= beforeNumberProduct[i]*afterNumberProduct[i];
        }
        System.out.println(product);
        return product;
    }

    private static int[] properAlgo(int[] elements) {
        int[] product= new int[elements.length];
        int beforeProduct=1;

        for(int i=0;i<elements.length;i++){
            if(i==0){
                product[i]=beforeProduct;
            }else{
                beforeProduct=beforeProduct*elements[i-1];
                product[i]=beforeProduct;
            }
        }
        System.out.println(product);

        int afterProduct=1;
        for(int i=elements.length-1;i>=0;i--){
            if(i!=elements.length-1){
                afterProduct=afterProduct*elements[i+1];
            }
            product[i]= product[i]*afterProduct;

        }
        System.out.println(product);
        return product;
    }
}
