package de.androbin.shell.input.lock;

import de.androbin.shell.input.*;
import java.util.function.*;

public final class KeyInputLock extends InputLock<KeyInput> implements KeyInput {
  public KeyInputLock( final KeyInput input, final BooleanSupplier condition ) {
    super( input, condition );
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