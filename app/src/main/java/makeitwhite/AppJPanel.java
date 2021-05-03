package makeitwhite;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AppJPanel extends JPanel implements ActionListener{
  static final int ScreenWidth = 600;
  static final int ScreenHeight = 600;
  static final int WUnits = 5;
  static final int HUnits = 5;
  static final int UnitSize = ScreenWidth/WUnits;
  Box boxes[][] = new Box[WUnits][HUnits];
  Timer timer;
  AppJPanel(){
    setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
    setBackground(Color.black);
    setFocusable(true);
    addMouseListener(new MyMouseAdpter());
    startGame();
  }
  public void startGame(){
    for(int i = 0; i<WUnits; i++){
      for(int j = 0; j<HUnits; j++){     
        boxes[i][j] = new Box(false);
      }
    }
    timer = new Timer(75,this);
    timer.start();
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    draw(g);
  }
  public void draw(Graphics g){
    for(int i = 0; i<WUnits; i++){
      for(int j = 0; j<HUnits; j++){     
        if(boxes[i][j].getState()) {
          g.setColor(Color.white);
        } else {
          g.setColor(Color.black);
        }
        g.fillRect(i*UnitSize,j*UnitSize,UnitSize,UnitSize);
      } 
    }
    g.setColor(Color.white);
    for(int i = 0; i<= WUnits; i++){
      g.drawLine(i*UnitSize,0,i*UnitSize,ScreenHeight);
      g.drawLine(0,i*UnitSize,ScreenWidth,i*UnitSize);
    }
  }
  @Override
  public void actionPerformed(ActionEvent e){
    repaint();
  }
  public class MyMouseAdpter extends MouseAdapter{
    @Override
    public void mouseClicked(MouseEvent e){
      int x = (WUnits*e.getX())/ScreenWidth;
      int y = (HUnits*e.getY())/ScreenHeight;
      boxes[x][y].reverseState();
    }
  }
}

