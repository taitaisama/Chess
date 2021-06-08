
package chess;

public class knight extends chess_piece{
    
    public knight(int X, int Y, boolean p) {
        super(X, Y, p);
    }
    @Override
    public void move(chess_piece [][]a){
        if(x<6&&y<7){
            if(a[x+2][y+1].getClass().getSimpleName().equals("blankspace")){
                avalible[x+2][y+1]=true;
            }
            else if (a[x+2][y+1].iswhite!=this.iswhite){
                a[x+2][y+1].threatenedby[x][y]=true;
                avalible[x+2][y+1]=true;
            }
            else if (a[x+2][y+1].iswhite==this.iswhite){
                a[x+2][y+1].protectedby[x][y]=true;
            }
        }
        if (x>1&&y>0){
            if(a[x-2][y-1].getClass().getSimpleName().equals("blankspace")){
                avalible[x-2][y-1]=true;
            }
            else if (a[x-2][y-1].iswhite!=this.iswhite){
                a[x-2][y-1].threatenedby[x][y]=true;
                avalible[x-2][y-1]=true;
            }
            else if (a[x-2][y-1].iswhite==this.iswhite){
                a[x-2][y-1].protectedby[x][y]=true;
            }
        }
        if (x<6&&y>0){
            if(a[x+2][y-1].getClass().getSimpleName().equals("blankspace")){
                avalible[x+2][y-1]=true;
            }
            else if (a[x+2][y-1].iswhite!=this.iswhite){
                a[x+2][y-1].threatenedby[x][y]=true;
                avalible[x+2][y-1]=true;
            }
            else if (a[x+2][y-1].iswhite==this.iswhite){
                a[x+2][y-1].protectedby[x][y]=true;
            }
        }
        if (x>1&&y<7){
            if(a[x-2][y+1].getClass().getSimpleName().equals("blankspace")){
                avalible[x-2][y+1]=true;
            }
            else if (a[x-2][y+1].iswhite!=this.iswhite){
                a[x-2][y+1].threatenedby[x][y]=true;
                avalible[x-2][y+1]=true;
            }
            else if (a[x-2][y+1].iswhite==this.iswhite){
                a[x-2][y+1].protectedby[x][y]=true;
            }
        }
        if(x<7&&y<6){
            if(a[x+1][y+2].getClass().getSimpleName().equals("blankspace")){
                avalible[x+1][y+2]=true;
            }
            else if (a[x+1][y+2].iswhite!=this.iswhite){
                a[x+1][y+2].threatenedby[x][y]=true;
                avalible[x+1][y+2]=true;
            }
            else if (a[x+1][y+2].iswhite==this.iswhite){
                a[x+1][y+2].protectedby[x][y]=true;
            }
        }
        if (x>0&&y>1){
            if(a[x-1][y-2].getClass().getSimpleName().equals("blankspace")){
                avalible[x-1][y-2]=true;
            }
            else if (a[x-1][y-2].iswhite!=this.iswhite){
                a[x-1][y-2].threatenedby[x][y]=true;
                avalible[x-1][y-2]=true;
            }
            else if (a[x-1][y-2].iswhite==this.iswhite){
                a[x-1][y-2].protectedby[x][y]=true;
            }
        }
        if (x<7&&y>1){
            if(a[x+1][y-2].getClass().getSimpleName().equals("blankspace")){
                avalible[x+1][y-2]=true;
            }
            else if (a[x+1][y-2].iswhite!=this.iswhite){
                a[x+1][y-2].threatenedby[x][y]=true;
                avalible[x+1][y-2]=true;
            }
            else if (a[x+1][y-2].iswhite==this.iswhite){
                a[x+1][y-2].protectedby[x][y]=true;
            }
        }
        if (x>0&&y<6){
            if(a[x-1][y+2].getClass().getSimpleName().equals("blankspace")){
                avalible[x-1][y+2]=true;
            }
            else if (a[x-1][y+2].iswhite!=this.iswhite){
                a[x-1][y+2].threatenedby[x][y]=true;
                avalible[x-1][y+2]=true;
            }
            else if (a[x-1][y+2].iswhite==this.iswhite){
                a[x-1][y+2].protectedby[x][y]=true;
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if (supercheck[i][j]==false){
                    avalible[i][j]=false;
                    
                }
            }
        }
    }
}
