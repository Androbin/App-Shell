package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class KeyInputSupply implements KeyInput {
  private final Supplier<? extends Shell> shell;
  
  public KeyInputSupply( final Supplier<? extends Shell> shell ) {
    this.shell = shell;
  }
  
  private KeyInput getInput() {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return null;
    }
    
    return shell.getInputs().keyboard;
  }
  
  @ Override
  public boolean hasKeyMask() {
    final KeyInput input = getInput();
    
    if ( input == null ) {
      return false;
    }
    
    return input.hasKeyMask();
  }
  
  @ Override
  public void keyPressed( final int keycode ) {
    final KeyInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.keyPressed( keycode );
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    final KeyInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.keyReleased( keycode );
  }
  
  @ Override
  public void keyTyped( final char keychar ) {
    final KeyInput input = getInput();
    
    if ( input == null ) {
      return;
    }
    
    input.keyTyped( keychar );
  }
}