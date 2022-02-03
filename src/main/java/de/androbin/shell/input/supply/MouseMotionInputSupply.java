package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseMotionInputSupply extends InputSupply<MouseMotionInput>
    implements MouseMotionInput {
  public MouseMotionInputSupply( final Supplier<MouseMotionInput> input ) {
    super( input );
  }
  
  public static MouseMotionInputSupply fromInputs( final Supplier<Inputs> inputs ) {
    return new MouseMotionInputSupply( InputSupplies.fromInputs(
        inputs, inputs1 -> inputs1.mouseMotion ) );
  }
  
  public static MouseMotionInputSupply fromShell( final Supplier<Shell> shell ) {
    return fromInputs( InputSupplies.fromShell( shell ) );
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    process( input -> input.mouseDragged( x, y, button ) );
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    process( input -> input.mouseMoved( x, y ) );
  }
}