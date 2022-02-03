package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseWheelInputSupply extends InputSupply<MouseWheelInput>
    implements MouseWheelInput {
  public MouseWheelInputSupply( final Supplier<MouseWheelInput> input ) {
    super( input );
  }
  
  public static MouseWheelInputSupply fromInputs( final Supplier<Inputs> inputs ) {
    return new MouseWheelInputSupply( InputSupplies.fromInputs(
        inputs, inputs1 -> inputs1.mouseWheel ) );
  }
  
  public static MouseWheelInputSupply fromShell( final Supplier<Shell> shell ) {
    return fromInputs( InputSupplies.fromShell( shell ) );
  }
  
  @ Override
  public void mouseWheelMoved( final int x, final int y, final int iclicks, final float fclicks ) {
    process( input -> input.mouseWheelMoved( x, y, iclicks, fclicks ) );
  }
}