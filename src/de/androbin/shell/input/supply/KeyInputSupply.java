package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class KeyInputSupply extends InputSupply<KeyInput> implements KeyInput {
  public KeyInputSupply( final Supplier<KeyInput> input ) {
    super( input );
  }
  
  public static KeyInputSupply fromInputs( final Supplier<Inputs> inputs ) {
    return new KeyInputSupply( InputSupplies.fromInputs(
        inputs, inputs1 -> inputs1.keyboard ) );
  }
  
  public static KeyInputSupply fromShell( final Supplier<Shell> shell ) {
    return fromInputs( InputSupplies.fromShell( shell ) );
  }
  
  @ Override
  public void keyPressed( final int keycode ) {
    process( input -> input.keyPressed( keycode ) );
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    process( input -> input.keyReleased( keycode ) );
  }
  
  @ Override
  public void keyTyped( final char keychar ) {
    process( input -> input.keyTyped( keychar ) );
  }
}