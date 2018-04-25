package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseInputSupply implements MouseInput {
  private final Supplier<MouseInput> input;
  
  public MouseInputSupply( final Supplier<MouseInput> input ) {
    this.input = input;
  }
  
  public static MouseInputSupply fromInputs( final Supplier<Inputs> inputs ) {
    return new MouseInputSupply( InputSupply.fromInputs( inputs, inputs1 -> inputs1.mouse ) );
  }
  
  public static MouseInputSupply fromShell( final Supplier<Shell> shell ) {
    return fromInputs( InputSupply.fromShell( shell ) );
  }
  
  @ Override
  public boolean hasMouseMask() {
    final MouseInput input = this.input.get();
    
    if ( input == null ) {
      return false;
    }
    
    return input.hasMouseMask();
  }
  
  @ Override
  public void mouseClicked( final int x, final int y, final int button ) {
    final MouseInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseClicked( x, y, button );
  }
  
  @ Override
  public void mousePressed( final int x, final int y, final int button ) {
    final MouseInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.mousePressed( x, y, button );
  }
  
  @ Override
  public void mouseReleased( final int x, final int y, final int button ) {
    final MouseInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseReleased( x, y, button );
  }
}