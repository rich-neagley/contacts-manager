import javax.swing.*;
import java.awt.*;

public class WindowFrame {
    static Container con;
    static JFrame window;
    static JPanel titleNamePanel;



    public static void main(String[] args) {

        window = new JFrame();
        window.setSize(1080,1000);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        con = window.getContentPane();





    }
}
