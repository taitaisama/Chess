
package chess;

public class chess_piece {
    int x;
    int y;
    boolean iswhite;
    boolean pawnmove1[][]=new boolean[8][8];
    boolean pawnmove2[][]=new boolean[8][8];
    boolean protectedby[][]=new boolean[8][8];
    boolean threatenedby[][]=new boolean[8][8];
    public boolean[][]avalible=new boolean[8][8];
    boolean supercheck[][]= new boolean[8][8]; 
    public chess_piece(int X,int Y,boolean p){
        x=X;
        y=Y;
        iswhite=p;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                supercheck[i][j]=true;
            }
        }
    }
    public void move(chess_piece[][]a){
    }
}
