
package chess;

public class pawn extends chess_piece{
    public pawn(int X, int Y, boolean i) {
        super(X, Y, i);
    }
    @Override
    public void move(chess_piece [][] a){
        if(!(iswhite)){
            if (x==1){
                if(a[x+1][y].getClass().getSimpleName().equals("blankspace")&&a[x+2][y].getClass().getSimpleName().equals("blankspace")){
                    pawnmove1[x+1][y]=true;
                    pawnmove1[x+2][y]=true;
                }
            }
            if(x<7){
                if(a[x+1][y].getClass().getSimpleName().equals("blankspace")){
                    pawnmove1[x+1][y]=true;
                }
            }
            if(y<7&&x<7){
                if(!(a[x+1][y+1].getClass().getSimpleName().equals("blankspace"))&&a[x+1][y+1].iswhite==true){
                    avalible[x+1][y+1]=true;
                    a[x+1][y+1].threatenedby[x][y]=true;
                }
            }
            if(y>0&&x<7){
                if(!(a[x+1][y-1].getClass().getSimpleName().equals("blankspace"))&&a[x+1][y-1].iswhite==true){
                    avalible[x+1][y-1]=true;
                    a[x+1][y-1].threatenedby[x][y]=true;
                }
            }
            if(y>0&&x<7){
                if(!(a[x+1][y-1].getClass().getSimpleName().equals("blankspace"))&&a[x+1][y-1].iswhite==false){
                    a[x+1][y-1].protectedby[x][y]=true;
                }
            }
            if(y<7&&x<7){
                if(!(a[x+1][y+1].getClass().getSimpleName().equals("blankspace"))&&a[x+1][y+1].iswhite==false){
                    a[x+1][y+1].protectedby[x][y]=true;
                }
            }
            if(y>0&&x<7){
                if(a[x+1][y-1].getClass().getSimpleName().equals("blankspace")){
                    pawnmove2[x+1][y-1]=true;
                }
            }
            if(y<7&&x<7){
                if(a[x+1][y+1].getClass().getSimpleName().equals("blankspace")){
                    pawnmove2[x+1][y+1]=true;
                }
            }
        }
        else{
            if (x==6){
                if(a[x-1][y].getClass().getSimpleName().equals("blankspace")&&a[x-2][y].getClass().getSimpleName().equals("blankspace")){
                    pawnmove1[x-1][y]=true;
                    pawnmove1[x-2][y]=true;
                }
            }
            if(x>0){
                if(a[x-1][y].getClass().getSimpleName().equals("blankspace")){
                    pawnmove1[x-1][y]=true;
                }
            }
            if(y<7&&x>0){
                if(!(a[x-1][y+1].getClass().getSimpleName().equals("blankspace"))&&a[x-1][y+1].iswhite==false){
                    avalible[x-1][y+1]=true;
                    a[x-1][y+1].threatenedby[x][y]=true;
                }
            }
            if(y>0&&x>0){
                if(!(a[x-1][y-1].getClass().getSimpleName().equals("blankspace"))&&a[x-1][y-1].iswhite==false){
                    avalible[x-1][y-1]=true;
                    a[x-1][y-1].threatenedby[x][y]=true;
                }
            }
            if(y>0&&x>0){
                if(!(a[x-1][y-1].getClass().getSimpleName().equals("blankspace"))&&a[x-1][y-1].iswhite==true){
                    a[x-1][y-1].protectedby[x][y]=true;
                }
            }
            if(y<7&&x>0){
                if(!(a[x-1][y+1].getClass().getSimpleName().equals("blankspace"))&&a[x-1][y+1].iswhite==true){
                    a[x-1][y+1].protectedby[x][y]=true;
                }
            }
            if(y>0&&x>0){
                if(a[x-1][y-1].getClass().getSimpleName().equals("blankspace")){
                    pawnmove2[x-1][y-1]=true;
                }
            }
            if(y<7&&x>0){
                if(a[x-1][y+1].getClass().getSimpleName().equals("blankspace")){
                    pawnmove2[x-1][y+1]=true;
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (supercheck[i][j]==false){
                    avalible[i][j]=false;
                    pawnmove1[i][j]=false;
                    pawnmove2[i][j]=false;
                    
                }
            }
        }
    }
}
