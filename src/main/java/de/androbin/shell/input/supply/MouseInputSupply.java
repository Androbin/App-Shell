package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseInputSupply extends InputSupply<MouseInput> implements MouseInput {
  public MouseInputSupply( final Supplier<MouseInput> input ) {
    super( input );
  }
  
  public static MouseInputSupply fromInputs( final Supplier<Inputs> inputs ) {
    return new MouseInputSupply( InputSupplies.fromInputs(
        inputs, inputs1 -> inputs1.mouse ) );
  }
  
  public static MouseInputSupply fromShell( final Supplier<Shell> shell ) {
    return fromInputs( InputSupplies.fromShell( shell ) );
  }
  
  @ Override
  public void mouseClicked( final int x, final int y, final int button ) {
    process( input -> input.mouseClicked( x, y, button ) );
  }
  
  @ Override
  public void mousePressed( final int x, final int y, final int button ) {
    process( input -> input.mousePressed( x, y, button ) );
  }
  
  @ Override
  public void mouseReleased( final int x, final int y, final int button ) {
    process( input -> input.mouseReleased( x, y, button ) );
  }
}