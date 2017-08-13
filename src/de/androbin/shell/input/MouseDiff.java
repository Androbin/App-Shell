package de.androbin.shell.input;

public final class MouseDiff implements MouseMotionInput {
  private boolean init;
  
  private int x0;
  private int y0;
  
  private int x1;
  private int y1;
  
  public int consumeDX() {
    final int dx = x1 - x0;
    x0 = x1;
    return dx;
  }
  
  public int consumeDY() {
    final int dy = y1 - y0;
    y0 = y1;
    return dy;
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    update( x, y );
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    update( x, y );
  }
  
  private void update( final int x, final int y ) {
    if ( !init ) {
      x0 = x;
      y0 = y;
      
      init = true;
    }
    
    x1 = x;
    y1 = y;
  }
}