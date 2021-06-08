
package chess;

public class bishop extends chess_piece{
    
    public bishop(int X, int Y, boolean p) {
        super(X, Y, p);
    }
     @Override
    public void move(chess_piece[][] a){
        int i=x+1;
        for (int j=y+1;j<8&&i<8;j++){
            if (a[i][j].getClass().getSimpleName().equals("blankspace")){
                avalible[i][j]=true;
            }
            else if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=this.iswhite)){
                avalible[i][j]=true;
                a[i][j].threatenedby[x][y]=true;
                break;
            }
            else if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite==this.iswhite)){
                a[i][j].protectedby[x][y]=true;
                break;
            }
            i++;
        }
        i=x-1;
        for (int j=y-1;j>=0&&i>=0;j--){
            if (a[i][j].getClass().getSimpleName().equals("blankspace")){
                avalible[i][j]=true;
            }
            else if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=this.iswhite)){
                avalible[i][j]=true;
                a[i][j].threatenedby[x][y]=true;
                break;
            }
            else if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite==this.iswhite)){
                a[i][j].protectedby[x][y]=true;
                break;
            }
        i--;
        }
        i=x+1;
        for (int j=y-1;j>=0&&i<8;j--){
            if (a[i][j].getClass().getSimpleName().equals("blankspace")){
                avalible[i][j]=true;
            }
            else if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=this.iswhite)){
                avalible[i][j]=true;
                a[i][j].threatenedby[x][y]=true;
                break;
            }
            else if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite==this.iswhite)){
                a[i][j].protectedby[x][y]=true;
                break;
            }
            i++;
        }
        i=x-1;
        for (int j=y+1;j<8&&i>=0;j++){
            if (a[i][j].getClass().getSimpleName().equals("blankspace")){
                avalible[i][j]=true;
            }
            else if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=this.iswhite)){
                avalible[i][j]=true;
                a[i][j].threatenedby[x][y]=true;
                break;
            }
            else if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite==this.iswhite)){
                a[i][j].protectedby[x][y]=true;
                break;
            }
            i--;
        }
        for (int l=0;l<8;l++){
            for (int j=0;j<8;j++){
                if (supercheck[l][j]==false){
                    avalible[l][j]=false;
                    
                }
            }
        }
    }
}
