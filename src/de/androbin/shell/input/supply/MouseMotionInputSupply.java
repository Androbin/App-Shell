package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseMotionInputSupply implements MouseMotionInput {
  private final Supplier<MouseMotionInput> input;
  
  public MouseMotionInputSupply( final Supplier<MouseMotionInput> input ) {
    this.input = input;
  }
  
  public static MouseMotionInputSupply fromInputs( final Supplier<Inputs> inputs ) {
    return new MouseMotionInputSupply( () -> {
      final Inputs inputs1 = inputs.get();
      return inputs1 == null ? null : inputs1.mouseMotion;
    } );
  }
  
  public static MouseMotionInputSupply fromShell( final Supplier<Shell> shell ) {
    return fromInputs( InputSupply.fromShell( shell ) );
  }
  
  @ Override
  public boolean hasMouseMotionMask() {
    final MouseMotionInput input = this.input.get();
    
    if ( input == null ) {
      return false;
    }
    
    return input.hasMouseMotionMask();
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    final MouseMotionInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseDragged( x, y, button );
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    final MouseMotionInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.mouseMoved( x, y );
  }
}