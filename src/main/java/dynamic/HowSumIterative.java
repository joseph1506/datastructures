package dynamic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HowSumIterative {

    public static void main(String[] args) {
        int[] numbers= new int[]{7,14,2};
        //System.out.println(howSum(300,numbers));
        Position pos= howSum(4,numbers);
        System.out.println(pos);
    }

    public static Position howSum(int target, int[] numbers){
        Position[] positions= new Position[target+1];
        Arrays.fill(positions,null);
        positions[0]= new Position();
        positions[0].combinations= new int[0];

        for(int i=0;i<positions.length;i++){
            if(positions[i]!=null){
                for(int number:numbers){
                    if(i+number<target+1){
                        positions[i+number]=createCopyAndAddNumber(positions[i],number);
                    }
                }
            }
        }
        return positions[target];
    }

    private static Position createCopyAndAddNumber(Position position, int number) {
        Position retPos= new Position();
        int[] combinations= position.combinations;
        int comLen= combinations.length;
        int[] newCombinations= new int[comLen+1];
          for(int i=0;i<comLen;i++){
              newCombinations[i]=combinations[i];
          }
          newCombinations[comLen]=number;
        retPos.combinations=newCombinations;
        return retPos;
    }

    private static class Position{
        int[] combinations;
    }
}
