package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseMotionInputSupply implements MouseMotionInput {
  private final Supplier< ? extends Shell> shell;
  
  public MouseMotionInputSupply( final Supplier< ? extends Shell> shell ) {
    this.shell = shell;
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final MouseMotionInput input = shell.getInputs().mouseMotion;
    
    if ( input != null ) {
      input.mouseDragged( x, y, button );
    }
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final MouseMotionInput input = shell.getInputs().mouseMotion;
    
    if ( input != null ) {
      input.mouseMoved( x, y );
    }
  }
}