package makeitwhite;
import javax.swing.*;

public class AppJFrame extends JFrame {
  AppJFrame(){
    add(new AppJPanel());
    setUndecorated(true);
    pack();
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setVisible(true);
  }
}
