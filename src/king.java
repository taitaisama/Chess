
package chess;

public class king extends chess_piece{
    
    public king(int X, int Y, boolean p) {
        super(X, Y, p);
    }
    @Override
    public void move(chess_piece[][]a){
        if (x>0){
            if (a[x-1][y].getClass().getSimpleName().equals("blankspace")){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=iswhite)){
                            if (a[i][j].avalible[x-1][y]==true||a[i][j].pawnmove2[x-1][y]==true){
                                iskingmove=true;
                            }
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x-1][y]=true;
                }
            }
            else if (!(a[x-1][y].getClass().getSimpleName().equals("blankspace"))&&(a[x-1][y].iswhite!=iswhite)){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x-1][y].protectedby[i][j]==true){
                            iskingmove=true;
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x-1][y]=true;
                    a[x-1][y].threatenedby[x][y]=true;
                }
            }
            else if (!(a[x-1][y].getClass().getSimpleName().equals("blankspace"))&&(a[x-1][y].iswhite==iswhite)){
                int k = 0;
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x-1][y].threatenedby[i][j]==true){
                            k++;
                        }
                    }
                }
                if(k>=2){
                    iskingmove=true;
                }
                if(!(iskingmove)){
                    a[x-1][y].protectedby[x][y]=true;
                }
            }
        }
        if (x<7){
            if (a[x+1][y].getClass().getSimpleName().equals("blankspace")){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=iswhite)){
                            if (a[i][j].avalible[x+1][y]==true||a[i][j].pawnmove2[x+1][y]==true){
                                iskingmove=true;
                            }
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x+1][y]=true;
                }
            }
            else if (!(a[x+1][y].getClass().getSimpleName().equals("blankspace"))&&(a[x+1][y].iswhite!=iswhite)){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x+1][y].protectedby[i][j]==true){
                            iskingmove=true;
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x+1][y]=true;
                    a[x+1][y].threatenedby[x][y]=true;
                }
            }
            else if (!(a[x+1][y].getClass().getSimpleName().equals("blankspace"))&&(a[x+1][y].iswhite==iswhite)){
                int k = 0;
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x+1][y].threatenedby[i][j]==true){
                            k++;
                        }
                    }
                }
                if(k>=2){
                    iskingmove=true;
                }
                if(!(iskingmove)){
                    a[x+1][y].protectedby[x][y]=true;
                }
            }
        }
        if (y<7){
            if (a[x][y+1].getClass().getSimpleName().equals("blankspace")){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=iswhite)){
                            if (a[i][j].avalible[x][y+1]==true||a[i][j].pawnmove2[x][y+1]==true){
                                iskingmove=true;
                            }
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x][y+1]=true;
                }
            }
            else if (!(a[x][y+1].getClass().getSimpleName().equals("blankspace"))&&(a[x][y+1].iswhite!=iswhite)){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x][y+1].protectedby[i][j]==true){
                            iskingmove=true;
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x][y+1]=true;
                    a[x][y+1].threatenedby[x][y]=true;
                }
            }
            else if (!(a[x][y+1].getClass().getSimpleName().equals("blankspace"))&&(a[x][y+1].iswhite==iswhite)){
                int k = 0;
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x][y+1].threatenedby[i][j]==true){
                            k++;
                        }
                    }
                }
                if(k>=2){
                    iskingmove=true;
                }
                if(!(iskingmove)){
                    a[x][y+1].protectedby[x][y]=true;
                }
            }
        }
        if (y>0){
            if (a[x][y-1].getClass().getSimpleName().equals("blankspace")){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=iswhite)){
                            if (a[i][j].avalible[x][y-1]==true||a[i][j].pawnmove2[x][y-1]==true){
                                iskingmove=true;
                            }
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x][y-1]=true;
                }
            }
            else if (!(a[x][y-1].getClass().getSimpleName().equals("blankspace"))&&(a[x][y-1].iswhite!=iswhite)){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x][y-1].protectedby[i][j]==true){
                            iskingmove=true;
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x][y-1]=true;
                    a[x][y-1].threatenedby[x][y]=true;
                }
            }
            else if (!(a[x][y-1].getClass().getSimpleName().equals("blankspace"))&&(a[x][y-1].iswhite==iswhite)){
                int k = 0;
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x][y-1].threatenedby[i][j]==true){
                            k++;
                        }
                    }
                }
                if(k>=2){
                    iskingmove=true;
                }
                if(!(iskingmove)){
                    a[x][y-1].protectedby[x][y]=true;
                }
            }
        }
        if(x>0&&y>0){
            if (a[x-1][y-1].getClass().getSimpleName().equals("blankspace")){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=iswhite)){
                            if (a[i][j].avalible[x-1][y-1]==true||a[i][j].pawnmove2[x-1][y-1]==true){
                                iskingmove=true;
                            }
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x-1][y-1]=true;
                }
            }
            else if (!(a[x-1][y-1].getClass().getSimpleName().equals("blankspace"))&&(a[x-1][y-1].iswhite!=iswhite)){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x-1][y-1].protectedby[i][j]==true){
                            iskingmove=true;
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x-1][y-1]=true;
                    a[x-1][y-1].threatenedby[x][y]=true;
                }
            }
            else if (!(a[x-1][y-1].getClass().getSimpleName().equals("blankspace"))&&(a[x-1][y-1].iswhite==iswhite)){
                int k = 0;
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x-1][y-1].threatenedby[i][j]==true){
                            k++;
                        }
                    }
                }
                if(k>=2){
                    iskingmove=true;
                }
                if(!(iskingmove)){
                    a[x-1][y-1].protectedby[x][y]=true;
                }
            }
        }
        if(x<7&&y<7){
            if (a[x+1][y+1].getClass().getSimpleName().equals("blankspace")){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=iswhite)){
                            if (a[i][j].avalible[x+1][y+1]==true||a[i][j].pawnmove2[x+1][y+1]==true){
                                iskingmove=true;
                            }
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x+1][y+1]=true;
                }
            }
            else if (!(a[x+1][y+1].getClass().getSimpleName().equals("blankspace"))&&(a[x+1][y+1].iswhite!=iswhite)){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x+1][y+1].protectedby[i][j]==true){
                            iskingmove=true;
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x+1][y+1]=true;
                    a[x+1][y+1].threatenedby[x][y]=true;
                }
            }
            else if (!(a[x+1][y+1].getClass().getSimpleName().equals("blankspace"))&&(a[x+1][y+1].iswhite==iswhite)){
                int k = 0;
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x+1][y+1].threatenedby[i][j]==true){
                            k++;
                        }
                    }
                }
                if(k>=2){
                    iskingmove=true;
                }
                if(!(iskingmove)){
                    a[x+1][y+1].protectedby[x][y]=true;
                }
            }
        }
        if(x>0&&y<7){
            if (a[x-1][y+1].getClass().getSimpleName().equals("blankspace")){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=iswhite)){
                            if (a[i][j].avalible[x-1][y+1]==true||a[i][j].pawnmove2[x-1][y+1]==true){
                                iskingmove=true;
                            }
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x-1][y+1]=true;
                }
            }
            else if (!(a[x-1][y+1].getClass().getSimpleName().equals("blankspace"))&&(a[x-1][y+1].iswhite!=iswhite)){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x-1][y+1].protectedby[i][j]==true){
                            iskingmove=true;
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x][y+1]=true;
                    a[x-1][y+1].threatenedby[x][y]=true;
                }
            }
            else if (!(a[x-1][y+1].getClass().getSimpleName().equals("blankspace"))&&(a[x-1][y+1].iswhite==iswhite)){
                int k = 0;
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x-1][y+1].threatenedby[i][j]==true){
                            k++;
                        }
                    }
                }
                if(k>=2){
                    iskingmove=true;
                }
                if(!(iskingmove)){
                    a[x-1][y+1].protectedby[x][y]=true;
                }
            }
        }
        if(x<7&&y>0){
            if (a[x+1][y-1].getClass().getSimpleName().equals("blankspace")){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&(a[i][j].iswhite!=iswhite)){
                            if (a[i][j].avalible[x+1][y-1]==true||a[i][j].pawnmove2[x+1][y-1]==true){
                                iskingmove=true;
                            }
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x+1][y-1]=true;
                }
            }
            else if (!(a[x+1][y-1].getClass().getSimpleName().equals("blankspace"))&&(a[x+1][y-1].iswhite!=iswhite)){
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x+1][y-1].protectedby[i][j]==true){
                            iskingmove=true;
                        }
                    }
                }
                if(!(iskingmove)){
                    avalible[x][y-1]=true;
                    a[x+1][y-1].threatenedby[x][y]=true;
                }
            }
            else if (!(a[x+1][y-1].getClass().getSimpleName().equals("blankspace"))&&(a[x+1][y-1].iswhite==iswhite)){
                int k = 0;
                boolean iskingmove=false;
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if (a[x+1][y-1].threatenedby[i][j]==true){
                            k++;
                        }
                    }
                }
                if(k>=2){
                    iskingmove=true;
                }
                if(!(iskingmove)){
                    a[x+1][y-1].protectedby[x][y]=true;
                }
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
