package makeitwhite;  
public class Box{
  private boolean state;
  Box(boolean s){
    state = s;
  }
  public void setState (boolean s){
    state = s;
  }
  public boolean getState (){
    return state;
  }
  public void reverseState(){
    if(state) {
      state = false;
    } else {
      state = true;
    }
  }
}
