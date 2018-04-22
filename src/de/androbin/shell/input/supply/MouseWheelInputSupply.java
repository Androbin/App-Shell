package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseWheelInputSupply implements MouseWheelInput {
  private final Supplier<? extends Shell> shell;
  
  public MouseWheelInputSupply( final Supplier<? extends Shell> shell ) {
    this.shell = shell;
  }
  
  private MouseWheelInput getInput() {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return null;
    }
    
    return shell.getInputs().mouseWheel;
  }
  
  @ Override
  public boolean hasMouseWheelMask() {
    final MouseWheelInput input = getInput();
    
    if ( input == null ) {
      return false;
    }
    
    return input.hasMouseWheelMask();
  }
  
  @ Override
  public void mouseWheelMoved( final int x, final int y, final int iclicks, final float fclicks ) {
    final MouseWheelInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseWheelMoved( x, y, iclicks, fclicks );
  }
}