package makeitwhite;
import javax.swing.JFrame;

public class AppJFrame extends JFrame {
  AppJFrame(){
    add(new AppJPanel());
    setResizable(false);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    pack();
    setVisible(true);
    setLocationRelativeTo(null);

  }
}
