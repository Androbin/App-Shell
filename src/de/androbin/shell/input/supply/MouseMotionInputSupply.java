package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseMotionInputSupply implements MouseMotionInput {
  private final Supplier<? extends Shell> shell;
  
  public MouseMotionInputSupply( final Supplier<? extends Shell> shell ) {
    this.shell = shell;
  }
  
  private MouseMotionInput getInput() {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return null;
    }
    
    return shell.getInputs().mouseMotion;
  }
  
  @ Override
  public boolean hasMouseMotionMask() {
    final MouseMotionInput input = getInput();
    
    if ( input == null ) {
      return false;
    }
    
    return input.hasMouseMotionMask();
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    final MouseMotionInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseDragged( x, y, button );
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    final MouseMotionInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseMoved( x, y );
  }
}