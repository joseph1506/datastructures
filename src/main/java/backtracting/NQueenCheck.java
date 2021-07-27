package backtracting;

public class NQueenCheck {


    public static void main(String[] args) {
        System.out.println(checkQueenAttackForN(4));
    }

    private static Position[] checkQueenAttackForN(int boardSize) {
        Position[] positions= new Position[boardSize];
        boolean isPossible= solveNQueenRecursion(boardSize,positions,0);
        if(isPossible){
            return positions;
        } else {
            return null;
        }
    }

    private static boolean solveNQueenRecursion(int boardSize, Position[] positions, int row) {
        if(row==boardSize){
            return true;
        }

        for(int col=0;col<boardSize;col++){
            boolean iPositionSafe= true;
            // check if i position is safe
            for(int j=0;j<row;j++){
                Position prevQueenPos= positions[j];
                // if safe
                if(prevQueenPos.col==col|| prevQueenPos.row- prevQueenPos.col==row-col ||
                        prevQueenPos.row+ prevQueenPos.col==row+col){
                    iPositionSafe=false;
                    break;
                }
            }
            if(iPositionSafe){
                positions[row]=new Position(row,col);
                if(solveNQueenRecursion(boardSize,positions,row+1)){
                    return true;
                }
            }
        }
        return false;
    }


    public static class Position{
        int row;
        int col;
        Position(int row,int col){
            this.row=row;
            this.col=col;
        }
    }

}
