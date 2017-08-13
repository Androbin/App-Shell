package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;
import java.util.*;

public final class KeyInputTee implements KeyInput {
  private final List<KeyInput> inputs;
  
  public KeyInputTee() {
    inputs = new ArrayList<>();
  }
  
  public void add( final KeyInput input ) {
    inputs.add( input );
  }
  
  @ Override
  public void keyPressed( final int keycode ) {
    for ( final KeyInput input : inputs ) {
      input.keyPressed( keycode );
    }
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    for ( final KeyInput input : inputs ) {
      input.keyReleased( keycode );
    }
  }
  
  @ Override
  public void keyTyped( final char keychar ) {
    for ( final KeyInput input : inputs ) {
      input.keyTyped( keychar );
    }
  }
}