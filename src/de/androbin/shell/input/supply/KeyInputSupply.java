package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class KeyInputSupply implements KeyInput {
  private final Supplier<KeyInput> input;
  
  public KeyInputSupply( final Supplier<KeyInput> input ) {
    this.input = input;
  }
  
  public static KeyInputSupply fromInputs( final Supplier<Inputs> inputs ) {
    return new KeyInputSupply( InputSupply.fromInputs( inputs, inputs1 -> inputs1.keyboard ) );
  }
  
  public static KeyInputSupply fromShell( final Supplier<Shell> shell ) {
    return fromInputs( InputSupply.fromShell( shell ) );
  }
  
  @ Override
  public boolean hasKeyMask() {
    final KeyInput input = this.input.get();
    
    if ( input == null ) {
      return false;
    }
    
    return input.hasKeyMask();
  }
  
  @ Override
  public void keyPressed( final int keycode ) {
    final KeyInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.keyPressed( keycode );
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    final KeyInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.keyReleased( keycode );
  }
  
  @ Override
  public void keyTyped( final char keychar ) {
    final KeyInput input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    input.keyTyped( keychar );
  }
}