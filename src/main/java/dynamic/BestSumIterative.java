package dynamic;

import java.util.Arrays;

public class BestSumIterative {

    public static void main(String[] args) {
        int[] numbers= new int[]{25,1,5,2};
        Position pos= howSum(100,numbers);
        System.out.println(pos);
    }

    public static Position howSum(int target, int[] numbers){
        Position[] positions= new Position[target+1];
        Arrays.fill(positions,null);
        positions[0]= new Position();
        positions[0].combinations= new int[0];
        //int minLength=Integer.MAX_VALUE;
        //Position toReturn=null;
        for(int i=0;i<positions.length;i++){
            if(positions[i]!=null){
                for(int number:numbers){
                    if(i+number<target+1){
                        int[] newCombinations=createCopyAndAddNumber(positions[i],number);
                        if(positions[i+number]==null){
                            positions[i+number]= new Position();
                            positions[i+number].combinations=newCombinations;
                        }else{
                            int[] posCombinations= positions[i+number].combinations;
                            if(newCombinations.length<posCombinations.length){
                                positions[i+number].combinations=newCombinations;
                            }
                        }
                        /*if(i+number==target){
                            int[] combinations=positions[i+number].combinations;
                            if(combinations.length<minLength){
                                toReturn=positions[i+number];
                                minLength=combinations.length;
                            }
                        }*/
                    }
                }
            }
        }
        return positions[target];
    }

    private static int[] createCopyAndAddNumber(Position position, int number) {
        //Position retPos= new Position();
        int[] combinations= position.combinations;
        int comLen= combinations.length;
        int[] newCombinations= new int[comLen+1];
          for(int i=0;i<comLen;i++){
              newCombinations[i]=combinations[i];
          }
          newCombinations[comLen]=number;
          return newCombinations;
        //retPos.combinations=newCombinations;
        //return retPos;
    }

    private static class Position{
        int[] combinations;
    }
}
