
package chess;
import java.awt.*;
import javax.swing.*;
public class Checkmate_window extends JFrame{
    JLabel label = new JLabel();
    public Checkmate_window(){
        Container contents = getContentPane();
        String s;
        if(!(Chess.iswhiteturn)){
            s="White";
        }
        else{
            s="Black";
        }
        label.setText("CHECKMATE! The winner is "+s);
        contents.add(label);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label.setFont(new Font("Monospace 14", Font.PLAIN, 40));
        pack();
    }
}
