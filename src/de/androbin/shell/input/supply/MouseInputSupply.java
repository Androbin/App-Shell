package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseInputSupply implements MouseInput {
  private final Supplier< ? extends Shell> shell;
  
  public MouseInputSupply( final Supplier< ? extends Shell> shell ) {
    this.shell = shell;
  }
  
  @ Override
  public void mouseClicked( final int x, final int y, final int button ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final MouseInput input = shell.getInputs().mouse;
    
    if ( input != null ) {
      input.mouseClicked( x, y, button );
    }
  }
  
  @ Override
  public void mousePressed( final int x, final int y, final int button ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final MouseInput input = shell.getInputs().mouse;
    
    if ( input != null ) {
      input.mousePressed( x, y, button );
    }
  }
  
  @ Override
  public void mouseReleased( final int x, final int y, final int button ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final MouseInput input = shell.getInputs().mouse;
    
    if ( input != null ) {
      input.mouseReleased( x, y, button );
    }
  }
}