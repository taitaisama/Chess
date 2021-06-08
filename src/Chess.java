package chess;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public final class Chess extends JFrame implements ActionListener,ComponentListener{
    JButton board[][]= new JButton [8][8];
    chess_piece [][] a = new chess_piece[8][8];
    JPanel z = new JPanel(new GridLayout(0,8)); 
    String className ;
    int ismate=0;
    boolean iskingthreatened = false;
    JPanel g = new JPanel(new GridLayout(0,1));
    public static void main(String[] args) {
        new Chess().setVisible(true);
    }
    boolean isshowingthreat = false;
    int nummove=0;
    int X;
    int Y;
    JLabel move = new JLabel();
    JButton show = new JButton("Show Threats");
    JButton knighta = new JButton();
    JButton queena = new JButton();
    JButton rooka = new JButton();
    JButton bishopa = new JButton();
    JButton newgame = new JButton("New Game");
    JPanel down = new JPanel();
    public static boolean iswhiteturn = true;
    boolean iswhitekingmoved=false;
    boolean isblackkingmoved=false;
    boolean iswhiterightrookmoved=false;
    boolean iswhiteleftrookmoved=false;
    boolean isblackrightrookmoved=false;
    boolean isblackleftrookmoved=false;
    Container contents = getContentPane();
    public Chess(){
        contents.add(z);
        setTitle("Chess!");
        knighta.setFont(new Font("Monospaced 14", Font.PLAIN, 60));
        queena.setFont(new Font("Monospaced 14", Font.PLAIN, 60));
        bishopa.setFont(new Font("Monospaced 14", Font.PLAIN, 60));
        rooka.setFont(new Font("Monospaced 14", Font.PLAIN, 60));
        g.add(new JLabel("Change pawn to:-"));
        contents.addComponentListener(this);
        g.add(knighta);
        contents.add(move,BorderLayout.NORTH);
        numbermove();
        knighta.addActionListener(this);
        g.add(rooka);
        rooka.addActionListener(this);
        g.add(bishopa);
        bishopa.addActionListener(this);
        g.add(queena);
        queena.addActionListener(this);
        contents.add(g,BorderLayout.EAST);
        g.setVisible(false);
        set_a();
        setbuttons();
        setboard();
        addboard();
        checkcheck();
        down.setLayout(new FlowLayout());
        down.add(newgame);
        down.add(show);
        contents.add(down,BorderLayout.SOUTH);
        newgame.addActionListener(this);
        show.addActionListener(this);
        if(iskingthreatened==true){
            spsetmoves();
        }
        else {
            setmoves();
        }
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack();
    }
    @Override
    public void componentResized(ComponentEvent e) {
        double n = Math.min(z.getSize().getHeight()/432,z.getSize().getWidth()/336);
        n=n-0.001;
        for(int i=0;i<8;i++){
           for(int j=0;j<8;j++){
                board[i][j].setFont(new Font("Monospaced 14", Font.PLAIN, (int)(40*n)));
           }
        }
    }
    public void showthreat(){
        isshowingthreat=true;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j].setEnabled(false);
                if(a[i][j].iswhite!=iswhiteturn){
                    for (int I=0;I<8;I++){
                        for (int J=0;J<8;J++){
                            if(a[i][j].avalible[I][J]==true||a[i][j].pawnmove2[I][J]==true){
                                board[I][J].setBackground(Color.orange);
                            }
                        }
                    }
                }
            }
        }
    }
    public void addboard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                z.add(board[i][j]);
            }
        }
    }
    public void numbermove(){
        move.setText("Number of moves = "+nummove);
    }
    public void set_a(){
        for(int i=0;i<8;i++){
                a[1][i]= new pawn(1,i,false);
                a[6][i]= new pawn(6,i,true);
        }
        a[0][0]= new rook(0,0,false);
        a[0][7]= new rook(0,7,false);
        a[0][1]= new knight(0,1,false);
        a[0][6]= new knight(0,6,false);
        a[0][2]= new bishop(0,2,false);
        a[0][5]= new bishop(0,5,false);  
        a[0][3]= new queen(0,3,false);
        a[0][4]= new king(0,4,false);
        a[7][0]= new rook(7,0,true);
        a[7][7]= new rook(7,7,true);
        a[7][1]= new knight(7,1,true);
        a[7][6]= new knight(7,6,true);
        a[7][2]= new bishop(7,2,true);
        a[7][5]= new bishop(7,5,true);  
        a[7][3]= new queen(7,3,true);
        a[7][4]= new king(7,4,true);
        
        for(int i =0;i<8;i++){
            a[3][i]= new blankspace(3,i,true);
            a[4][i]= new blankspace(4,i,true);
            a[5][i]= new blankspace(5,i,true);
            a[2][i]= new blankspace(2,i,true);
        }
        /*for(int i =0;i<8;i++){
            for(int j=0;j<8;j++){
                a[j][i]= new blankspace(j,i,true);
            }
        }
        a[7][0] = new king(7,0,false);
        a[3][1] = new king(3,1,true);
        a[2][2] = new pawn(2,2,true);
        a[2][3] = new rook(2,3,false);*/
    }
    @Override
    public void actionPerformed(ActionEvent event){
        if(event.getSource()!=newgame&&event.getSource()!=knighta&&event.getSource()!=queena&&event.getSource()!=rooka&&event.getSource()!=bishopa&&event.getSource()!=show){
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if (board[i][j]==event.getSource()){
                        Enabel(i,j);
                        break;
                    }
                }
            }
        }
        else if (event.getSource()==newgame){
            set_a();
            iswhitekingmoved=false;
            isblackkingmoved=false;
            iswhiterightrookmoved=false;
            iswhiteleftrookmoved=false;
            isblackrightrookmoved=false;
            isblackleftrookmoved=false;
            iswhiteturn=true;
            setmoves();
            setboard();
        }
        else if (event.getSource()!=show){
            int i;
            int j=0;
            for(i=0;i<8;i++){
                boolean q =false;
                for(j=0;j<8;j++){
                    if((a[i][j].getClass().getSimpleName().equals("pawn")&&a[i][j].iswhite&&i==0)||(a[i][j].getClass().getSimpleName().equals("pawn")&&!(a[i][j].iswhite)&&i==7)){
                        q=true;
                        break;
                    }
                }
                if(q==true){
                    break;
                }
            }
            if(event.getSource()==rooka){
                a[i][j]=new rook(i,j,a[i][j].iswhite);
            }
            else if(event.getSource()==bishopa){
                a[i][j]=new bishop(i,j,a[i][j].iswhite);
            }
            else if(event.getSource()==queena){
                a[i][j]=new queen(i,j,a[i][j].iswhite);
            }
            else if(event.getSource()==knighta){
                a[i][j]=new knight(i,j,a[i][j].iswhite);
            }
            g.setVisible(false);
            setmoves();
            setboard();
        }
        else {
            if (isshowingthreat){
                isshowingthreat=false;
                reset();
                setboard();
            }
            else {
                reset();
                showthreat();
            }
        }
    }
    public void Enabel(int x,int y){
        reset();
        if(!(a[x][y].getClass().getSimpleName().equals("blankspace"))&&a[x][y].iswhite==iswhiteturn){
            X=x;
            Y=y;
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if(a[x][y].avalible[i][j]==true||a[x][y].pawnmove1[i][j]==true){
                        board[i][j].setBackground(Color.green);
                        board[i][j].setEnabled(true);
                    }
                    if(a[x][y].protectedby[i][j]==true){
                        board[i][j].setBackground(Color.blue);
                    }
                    if(a[i][j].threatenedby[x][y]==true){
                        board[i][j].setBackground(Color.orange);
                    }
                    if(a[i][j].protectedby[x][y]==true){
                        board[i][j].setBackground(Color.yellow);
                    }
                    if(a[i][j].threatenedby[x][y]==true){
                        board[i][j].setBackground(Color.red);
                    }
                }
            }
        }
        else {
            if(iswhiteturn){
                nummove++;
                numbermove();
            }
            if(a[X][Y].getClass().getSimpleName().equals("king")){
                if(a[X][Y].iswhite){
                    iswhitekingmoved=true;
                }
                else{
                    isblackkingmoved=true;
                }
            }
            if(a[X][Y].getClass().getSimpleName().equals("rook")){
                if(a[X][Y].iswhite&&X==7&&Y==7){
                    iswhiterightrookmoved=true;
                }
                else if(a[X][Y].iswhite&&X==7&&Y==0){
                    iswhiteleftrookmoved=true;
                }
                else if(!(a[X][Y].iswhite)&&X==0&&Y==0){
                    isblackleftrookmoved=true;
                }
                else if(!(a[X][Y].iswhite)&&X==0&&Y==7){
                    isblackrightrookmoved=true;
                }
            }
            iswhiteturn=!iswhiteturn;
            if(a[X][Y].getClass().getSimpleName().equals("king")&&Math.abs(Y-y)==2&&X-x==0){
                if(X==7&&y==2){
                    a[x][y]=a[X][Y];
                    a[x][y].x=x;
                    a[x][y].y=y;
                    a[X][Y]=new blankspace(X,Y,true);
                    a[7][3]=a[7][0];
                    a[7][3].x=7;
                    a[7][3].y=3;
                    a[7][0]=new blankspace(7,0,true);
                }
                else if(X==7&&y==6){
                    a[x][y]=a[X][Y];
                    a[x][y].x=x;
                    a[x][y].y=y;
                    a[X][Y]=new blankspace(X,Y,true);
                    a[7][5]=a[7][7];
                    a[7][5].x=7;
                    a[7][5].y=5;
                    a[7][7]=new blankspace(7,7,true);
                }
                else if(X==0&&y==2){
                    a[x][y]=a[X][Y];
                    a[x][y].x=x;
                    a[x][y].y=y;
                    a[X][Y]=new blankspace(X,Y,true);
                    a[0][3]=a[0][0];
                    a[0][3].x=0;
                    a[0][3].y=3;
                    a[0][0]=new blankspace(0,0,true);
                }
                else if(X==0&&y==6){
                    a[x][y]=a[X][Y];
                    a[x][y].x=x;
                    a[x][y].y=y;
                    a[X][Y]=new blankspace(X,Y,true);
                    a[0][5]=a[0][7];
                    a[0][5].x=0;
                    a[0][5].y=5;
                    a[0][7]=new blankspace(0,7,true);
                }
                setmoves();
                setboard();
            }
            else{
                a[x][y]=a[X][Y];
                a[x][y].x=x;
                a[x][y].y=y;
                a[X][Y]=new blankspace(X,Y,true);
                checkpawn();
                if(g.isVisible()==false){
                    setmoves();
                    checkcheck();
                    if(iskingthreatened==true){
                        spsetmoves();
                        setboard();
                    }
                    else {
                        setmoves();
                        setboard();
                    }
                }
            }
        }
    }
    public void checkmate(){
        Checkmate_window v = new Checkmate_window();
        v.setVisible(true);
    }
    public void stalemate(){
        Stalemate_Window v = new Stalemate_Window();
        v.setVisible(true);
    }
    public void checkpawn(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((a[i][j].getClass().getSimpleName().equals("pawn")&&a[i][j].iswhite&&i==0)||(a[i][j].getClass().getSimpleName().equals("pawn")&&!(a[i][j].iswhite)&&i==7)){
                    if(a[i][j].iswhite){
                        pawnconvert(true);
                    }
                    else{
                        pawnconvert(false);
                    }
                }
            }
        }
    }
    public void pawnconvert(boolean s){
        if (s){
            knighta.setText("♘");
            queena.setText("♕");
            rooka.setText("♖");
            bishopa.setText("♗");
        }
        else{
            knighta.setText("♞");
            queena.setText("♛");
            rooka.setText("♜");
            bishopa.setText("♝");
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j].setEnabled(false);
            }
        }
        g.setVisible(true);
    }
    public void checkcheck(){
        iskingthreatened=false;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (a[i][j].getClass().getSimpleName().equals("king")){
                    for (int I=0;I<8;I++){
                        for (int J=0;J<8;J++){
                            if (a[i][j].threatenedby[I][J]==true){
                                iskingthreatened=true;
                                if(a[i][j].iswhite){
                                    iswhitekingmoved=true;
                                }
                                else{
                                    isblackkingmoved=true;
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public void spcheckcheck(){
        iskingthreatened=false;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if (a[i][j].getClass().getSimpleName().equals("king")&&a[i][j].iswhite==iswhiteturn){
                    for (int I=0;I<8;I++){
                        for (int J=0;J<8;J++){
                            if (a[i][j].threatenedby[I][J]==true){
                                iskingthreatened=true;
                            }
                        }
                    }
                }
            }
        }
    }
    public void reset(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if((i+j)%2==0){
                    board[i][j].setBackground(Color.WHITE);
                }
                else {
                    board[i][j].setBackground(Color.GRAY);
                }
                if(a[i][j].getClass().getSimpleName().equals("blankspace")){
                    board[i][j].setEnabled(false);
                }
                else {
                    if(iswhiteturn){
                        if (!(a[i][j].iswhite)){
                            board[i][j].setEnabled(false);
                        }
                    }
                    else{
                        if (a[i][j].iswhite){
                            board[i][j].setEnabled(false);
                        }
                    }
                }
            }
        }
    }
    public void setbuttons(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board [i][j]= new JButton();
                board [i][j].addActionListener(this);
                if((i+j)%2==0){
                    board[i][j].setBackground(Color.WHITE);
                }
                else {
                    board[i][j].setBackground(Color.GRAY);
                }
                board[i][j].setFont(new Font("Monospaced 14", Font.PLAIN, 60));
                board[i][j].setSize(1000,1000);
            }
        }
    }
    public void spsetmoves(){
        for (int I=0;I<8;I++){
            for (int J=0;J<8;J++){
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        a[I][J].avalible[i][j]=false;
                        a[I][J].protectedby[i][j]=false;
                        a[I][J].threatenedby[i][j]=false;
                        a[I][J].pawnmove1[i][j]=false;
                        a[I][J].pawnmove2[i][j]=false;
                    }
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(!(a[i][j].getClass().getSimpleName().equals("king"))){
                    a[i][j].move(a);
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(a[i][j].getClass().getSimpleName().equals("king")){
                    a[i][j].move(a);
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&a[i][j].iswhite==iswhiteturn){
                    for (int I=0;I<8;I++){
                        for (int J=0;J<8;J++){
                            if(a[i][j].avalible[I][J]==true||a[i][j].pawnmove1[I][J]==true){
                                chess_piece o;
                                o=a[I][J];
                                a[I][J]=a[i][j];
                                a[I][J].x=I;
                                a[I][J].y=J;
                                a[i][j]=new blankspace(i,j,true);
                                setmoves();
                                checkcheck();
                                if(iskingthreatened==true){
                                    a[i][j]=a[I][J];
                                    a[i][j].x=i;
                                    a[i][j].y=j;
                                    a[I][J]=o;
                                    a[i][j].supercheck[I][J]=false;
                                    setmoves();
                                }
                                else {
                                    a[i][j]=a[I][J];
                                    a[i][j].x=i;
                                    a[i][j].y=j;
                                    a[I][J]=o;
                                    setmoves();
                                }
                            }
                        }
                    }
                }
            }
        }
        ismate=0;
        for (int I=0;I<8;I++){
            for (int J=0;J<8;J++){
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if((a[i][j].avalible[I][J]==true||a[i][j].pawnmove1[I][J]==true)&&a[i][j].iswhite==iswhiteturn){
                            ismate=1;
                        }
                    }
                }
            }
        }
        if(ismate==0){
            checkmate();
        }
        for (int I=0;I<8;I++){
            for (int J=0;J<8;J++){
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        a[I][J].supercheck[i][j]=true;
                    }
                }
            }
        }
    }
    public void nsetmoves(){
        for (int I=0;I<8;I++){
            for (int J=0;J<8;J++){
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        a[I][J].avalible[i][j]=false;
                        a[I][J].protectedby[i][j]=false;
                        a[I][J].threatenedby[i][j]=false;
                        a[I][J].pawnmove1[i][j]=false;
                        a[I][J].pawnmove2[i][j]=false;
                    }
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(!(a[i][j].getClass().getSimpleName().equals("king"))){
                    a[i][j].move(a);
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(a[i][j].getClass().getSimpleName().equals("king")){
                    a[i][j].move(a);
                }
            }
        }
        if(isblackkingmoved==false&&iswhiteturn==false&&isblackleftrookmoved==false&&a[0][1].getClass().getSimpleName().equals("blankspace")&&a[0][2].getClass().getSimpleName().equals("blankspace")&&a[0][3].getClass().getSimpleName().equals("blankspace")){
            boolean lol = false;
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if((a[i][j].avalible[0][2]==true||a[i][j].pawnmove2[0][2]==true)&&a[i][j].iswhite==true){
                        lol=true;
                    }
                }
            }
            if(lol==false){
                a[0][4].avalible[0][2]=true;
            }
        }
        if(isblackkingmoved==false&&iswhiteturn==false&&isblackrightrookmoved==false&&a[0][6].getClass().getSimpleName().equals("blankspace")&&a[0][5].getClass().getSimpleName().equals("blankspace")){
            boolean lol = false;
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if((a[i][j].avalible[0][6]==true||a[i][j].pawnmove2[0][6]==true)&&a[i][j].iswhite==true){
                        lol=true;
                    }
                }
            }
            if(lol==false){
                a[0][4].avalible[0][6]=true;
            }
        }
        if(iswhitekingmoved==false&&iswhiteturn==true&&iswhiteleftrookmoved==false&&a[7][1].getClass().getSimpleName().equals("blankspace")&&a[7][2].getClass().getSimpleName().equals("blankspace")&&a[7][3].getClass().getSimpleName().equals("blankspace")){
            boolean lol = false;
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if((a[i][j].avalible[7][2]==true||a[i][j].pawnmove2[7][2]==true)&&a[i][j].iswhite==false){
                        lol=true;
                    }
                }
            }
            if(lol==false){
                a[7][4].avalible[7][2]=true;
            }
        }
        if(iswhitekingmoved==false&&iswhiteturn==true&&iswhiterightrookmoved==false&&a[7][6].getClass().getSimpleName().equals("blankspace")&&a[7][5].getClass().getSimpleName().equals("blankspace")){
            boolean lol = false;
            for (int i=0;i<8;i++){
                for (int j=0;j<8;j++){
                    if((a[i][j].avalible[7][6]==true||a[i][j].pawnmove2[7][6]==true)&&a[i][j].iswhite==false){
                        lol=true;
                    }
                }
            }
            if(lol==false){
                a[7][4].avalible[7][6]=true;
            }
        }
    }
    public void setmoves(){
        for (int I=0;I<8;I++){
            for (int J=0;J<8;J++){
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        a[I][J].avalible[i][j]=false;
                        a[I][J].protectedby[i][j]=false;
                        a[I][J].threatenedby[i][j]=false;
                        a[I][J].pawnmove1[i][j]=false;
                        a[I][J].pawnmove2[i][j]=false;
                    }
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(!(a[i][j].getClass().getSimpleName().equals("king"))){
                    a[i][j].move(a);
                }
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(a[i][j].getClass().getSimpleName().equals("king")){
                    a[i][j].move(a);
                }
            }
        }
        ismate=0;
        for (int I=0;I<8;I++){
            for (int J=0;J<8;J++){
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        if((a[i][j].avalible[I][J]==true||a[i][j].pawnmove1[I][J]==true)&&a[i][j].iswhite==iswhiteturn){
                            ismate=1;
                        }
                    }
                }
            }
        }
        if(ismate==0&&iskingthreatened==false){
            stalemate();
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(!(a[i][j].getClass().getSimpleName().equals("blankspace"))&&a[i][j].iswhite==iswhiteturn){
                    for (int I=0;I<8;I++){
                        for (int J=0;J<8;J++){
                            if(a[i][j].avalible[I][J]==true||a[i][j].pawnmove1[I][J]==true){
                                chess_piece o;
                                o=a[I][J];
                                a[I][J]=a[i][j];
                                a[I][J].x=I;
                                a[I][J].y=J;
                                a[i][j]=new blankspace(i,j,true);
                                nsetmoves();
                                spcheckcheck();
                                if(iskingthreatened==true){
                                    a[i][j]=a[I][J];
                                    a[i][j].x=i;
                                    a[i][j].y=j;
                                    a[I][J]=o;
                                    a[i][j].supercheck[I][J]=false;
                                    nsetmoves();
                                }
                                else {
                                    a[i][j]=a[I][J];
                                    a[i][j].x=i;
                                    a[i][j].y=j;
                                    a[I][J]=o;
                                    nsetmoves();
                                }
                            }
                        }
                    }
                }
            }
        }
        for (int I=0;I<8;I++){
            for (int J=0;J<8;J++){
                for (int i=0;i<8;i++){
                    for (int j=0;j<8;j++){
                        a[I][J].supercheck[i][j]=true;
                    }
                }
            }
        }
    }
    public void setboard(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                board[i][j].setEnabled(false);
                board[i][j].setMargin(new Insets(0, 0, 0, 0));
            }
        }
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                className = a[i][j].getClass().getSimpleName();
                switch (className) {
                    case "pawn":
                        board[i][j].setEnabled(true);
                        if (a[i][j].iswhite){
                            board[i][j].setText("♙");
                        }
                        else{
                            board[i][j].setText("♟");
                        }   break;
                    case "rook":
                        board[i][j].setEnabled(true);
                        if (a[i][j].iswhite){
                            board[i][j].setText("♖");
                        }
                        else{
                            board[i][j].setText("♜");
                        }   break;
                    case "bishop":
                        board[i][j].setEnabled(true);
                        if (a[i][j].iswhite){
                            board[i][j].setText("♗");
                        }
                        else{
                            board[i][j].setText("♝");
                        }   break;
                    case "knight":
                        board[i][j].setEnabled(true);
                        if (a[i][j].iswhite){
                            board[i][j].setText("♘");
                        }
                        else{
                            board[i][j].setText("♞");
                        }   break;
                    case "queen":
                        board[i][j].setEnabled(true);
                        if (a[i][j].iswhite){
                            board[i][j].setText("♕");
                        }
                        else{
                            board[i][j].setText("♛");
                        }   break;
                    case "king":
                        board[i][j].setEnabled(true);
                        if (a[i][j].iswhite){
                            board[i][j].setText("♔");
                        }
                        else{
                            board[i][j].setText("♚");
                        }   break;
                    default:
                        board[i][j].setText("");
                        break;
                }
                if(iswhiteturn){
                    if (!(a[i][j].iswhite)){
                        board[i][j].setEnabled(false);
                    }
                }
                else{
                    if (a[i][j].iswhite){
                        board[i][j].setEnabled(false);
                    }
                }
            }
        }
    }
    public boolean checkavalible(int x,int y){
        boolean f=false;
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                if(a[x][y].avalible[i][j]||a[x][y].pawnmove1[i][j]){
                    f=true;
                    return f;
                }
            }
        }
        return f;
    }
    @Override
    public void componentMoved(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void componentShown(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void componentHidden(ComponentEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
