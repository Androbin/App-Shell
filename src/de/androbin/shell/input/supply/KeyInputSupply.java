package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class KeyInputSupply implements KeyInput {
  private final Supplier< ? extends Shell> shell;
  
  public KeyInputSupply( final Supplier< ? extends Shell> shell ) {
    this.shell = shell;
  }
  
  @ Override
  public void keyPressed( final int keycode ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final KeyInput input = shell.getInputs().keyboard;
    
    if ( input != null ) {
      input.keyPressed( keycode );
    }
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final KeyInput input = shell.getInputs().keyboard;
    
    if ( input != null ) {
      input.keyReleased( keycode );
    }
  }
  
  @ Override
  public void keyTyped( final char keychar ) {
    final Shell shell = this.shell.get();
    
    if ( shell == null ) {
      return;
    }
    
    final KeyInput input = shell.getInputs().keyboard;
    
    if ( input != null ) {
      input.keyTyped( keychar );
    }
  }
}