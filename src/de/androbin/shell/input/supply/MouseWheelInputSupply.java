package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseWheelInputSupply implements MouseWheelInput {
  private final Supplier<MouseWheelInput> input;
  
  public MouseWheelInputSupply( final Supplier<MouseWheelInput> input ) {
    this.input = input;
  }
  
  public static MouseWheelInputSupply fromInputs( final Supplier<Inputs> inputs ) {
    return new MouseWheelInputSupply( InputSupply.fromInputs(
        inputs, inputs1 -> inputs1.mouseWheel ) );
  }
  
  public static MouseWheelInputSupply fromShell( final Supplier<Shell> shell ) {
    return fromInputs( InputSupply.fromShell( shell ) );
  }
  
  @ Override
  public boolean hasMouseWheelMask() {
    final MouseWheelInput input = this.input.get();
    
    if ( input == null ) {
      return false;
    }
    
    return input.hasMouseWheelMask();
  }
  
  @ Override
  public void mouseWheelMoved( final int x, final int y, final int iclicks, final float fclicks ) {
    final MouseWheelInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseWheelMoved( x, y, iclicks, fclicks );
  }
}