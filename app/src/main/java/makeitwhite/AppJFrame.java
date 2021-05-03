package makeitwhite;
import javax.swing.JFrame;

public class AppJFrame extends JFrame {
  AppJFrame(){
    setSize(500,500);
    setResizable(false);
    setLocationRelativeTo(null);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
}
