package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseWheelInputSupply implements MouseWheelInput {
  private final Supplier< ? extends Shell> shell;
  
  public MouseWheelInputSupply( final Supplier< ? extends Shell> shell ) {
    this.shell = shell;
  }
  
  @ Override
  public void mouseWheelMoved( final int x, final int y, final int iclicks, final float fclicks ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final MouseWheelInput input = shell.getInputs().mouseWheel;
    
    if ( input != null ) {
      input.mouseWheelMoved( x, y, iclicks, fclicks );
    }
  }
}