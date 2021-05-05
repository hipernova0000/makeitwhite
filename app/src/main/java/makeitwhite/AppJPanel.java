package makeitwhite;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class AppJPanel extends JPanel implements ActionListener{
  static final int startBox = 1;
  static final int ScreenWidth = 600;
  static final int ScreenHeight = 600;
  static int WUnits = 5;
  static int HUnits = 5;
  static int UnitSize;
  int level = 1 ;
  Box boxes[][];
  Timer timer;
  Random random;
  AppJPanel(){
    setPreferredSize(new Dimension(ScreenWidth,ScreenHeight));
    setBackground(Color.black);
    setFocusable(true);
    addMouseListener(new MyMouseAdpter());
    startGame();
  }
  public void startGame(){
    boxes = new Box[WUnits][HUnits];
    UnitSize = ScreenWidth/WUnits;
    for(int i = 0; i<WUnits; i++){
      for(int j = 0; j<HUnits; j++){     
        boxes[i][j] = new Box(true);
      }
    }
    timer = new Timer(75,this);
    timer.start();
    random = new Random();
    makeLevel();
  }
  public void makeLevel(){
    for(int i = 0; i < level; i++){
      reverseState(random.nextInt(WUnits),random.nextInt(HUnits));
    }
  }
  public void paintComponent(Graphics g){
    super.paintComponent(g);
    draw(g);
  }
  public void draw(Graphics g){
    for(int i = 0; i<WUnits; i++){
      for(int j = 0; j<HUnits; j++){
        //draw boxes
        g.setColor(Color.black);
        if(boxes[i][j].getState()) 
          g.setColor(Color.white);
        g.fillRect(i*UnitSize,j*UnitSize,UnitSize,UnitSize);
        //draw grids
        g.setColor(Color.white);
        if(boxes[i][j].getState())
          g.setColor(Color.black);
        g.drawRect(i*UnitSize,j*UnitSize,UnitSize,UnitSize);
      }
    }
  }
  @Override
  public void actionPerformed(ActionEvent e){
    repaint();
  }
  public void reverseState(int x, int y){
    for(int i = x-1; i <= x+1; i++){
      for(int j = y-1; j <= y+1; j++){
        if(i >= 0 && i < WUnits && j >= 0 && j < HUnits){
          boxes[i][j].reverseState();
        }
      }
    }
  }
  public boolean checkWin(){
    for(int i = 0; i<WUnits; i++){
      for(int j = 0; j<HUnits; j++){     
        if(!boxes[i][j].getState()) return false;
      }
    }
    return true;
  }
  public void makeBigger(){
    WUnits++;
    HUnits++;
    level = 1;
    startGame();
  }
  public void upLevel(){
    if(level==WUnits*HUnits) makeBigger();
    level++;
    makeLevel();
  }
  public class MyMouseAdpter extends MouseAdapter{
    @Override
    public void mouseClicked(MouseEvent e){
      int x = (WUnits*e.getX())/ScreenWidth;
      int y = (HUnits*e.getY())/ScreenHeight;
      reverseState(x,y);
      if(checkWin()) upLevel();
    }
  }
}
