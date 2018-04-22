package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseInputSupply implements MouseInput {
  private final Supplier<? extends Shell> shell;
  
  public MouseInputSupply( final Supplier<? extends Shell> shell ) {
    this.shell = shell;
  }
  
  private MouseInput getInput() {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return null;
    }
    
    return shell.getInputs().mouse;
  }
  
  @ Override
  public boolean hasMouseMask() {
    final MouseInput input = getInput();
    
    if ( input == null ) {
      return false;
    }
    
    return input.hasMouseMask();
  }
  
  @ Override
  public void mouseClicked( final int x, final int y, final int button ) {
    final MouseInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseClicked( x, y, button );
  }
  
  @ Override
  public void mousePressed( final int x, final int y, final int button ) {
    final MouseInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.mousePressed( x, y, button );
  }
  
  @ Override
  public void mouseReleased( final int x, final int y, final int button ) {
    final MouseInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseReleased( x, y, button );
  }
}