
package chess;
import java.awt.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
public class Stalemate_Window extends JFrame{
    JLabel label = new JLabel();
    public Stalemate_Window(){
        Container contents = getContentPane();
        String s;
        label.setText("STALEMATE");
        contents.add(label);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        label.setFont(new Font("Monospace 14", Font.PLAIN, 40));
        pack();
    }
}

