
package chess;

public class rook extends chess_piece{
    public rook(int X, int Y, boolean p) {
        super(X, Y, p);
    }

    @Override
    public void move(chess_piece[][] a){
        for (int i=x+1;i<8;i++){
            if (a[i][y].getClass().getSimpleName().equals("blankspace")){
                avalible[i][y]=true;
            }
            else if (!(a[i][y].getClass().getSimpleName().equals("blankspace"))&&(a[i][y].iswhite!=this.iswhite)){
                avalible[i][y]=true;
                a[i][y].threatenedby[x][y]=true;
                break;
            }
            else if (!(a[i][y].getClass().getSimpleName().equals("blankspace"))&&(a[i][y].iswhite==this.iswhite)){
                a[i][y].protectedby[x][y]=true;
                break;
            }
        }
        for (int i=x-1;i>=0;i--){
            if (a[i][y].getClass().getSimpleName().equals("blankspace")){
                avalible[i][y]=true;
            }
            else if (!(a[i][y].getClass().getSimpleName().equals("blankspace"))&&(a[i][y].iswhite!=this.iswhite)){
                avalible[i][y]=true;
                a[i][y].threatenedby[x][y]=true;
                break;
            }
            else if (!(a[i][y].getClass().getSimpleName().equals("blankspace"))&&(a[i][y].iswhite==this.iswhite)){
                a[i][y].protectedby[x][y]=true;
                break;
            }
        }
        for (int i=y+1;i<8;i++){
            if (a[x][i].getClass().getSimpleName().equals("blankspace")){
                avalible[x][i]=true;
            }
            else if (!(a[x][i].getClass().getSimpleName().equals("blankspace"))&&(a[x][i].iswhite!=this.iswhite)){
                avalible[x][i]=true;
                a[x][i].threatenedby[x][y]=true;
                break;
            }
            else if (!(a[x][i].getClass().getSimpleName().equals("blankspace"))&&(a[x][i].iswhite==this.iswhite)){
                a[x][i].protectedby[x][y]=true;
                break;
            }
        }
        for (int i=y-1;i>=0;i--){
            if (a[x][i].getClass().getSimpleName().equals("blankspace")){
                avalible[x][i]=true;
            }
            else if (!(a[x][i].getClass().getSimpleName().equals("blankspace"))&&(a[x][i].iswhite!=this.iswhite)){
                avalible[x][i]=true;
                a[x][i].threatenedby[x][y]=true;
                break;
            }
            else if (!(a[x][i].getClass().getSimpleName().equals("blankspace"))&&(a[x][i].iswhite==this.iswhite)){
                a[x][i].protectedby[x][y]=true;
                break;
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
