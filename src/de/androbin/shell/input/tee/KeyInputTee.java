package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;
import java.util.*;

public final class KeyInputTee implements KeyInput {
  private final List<KeyInput> inputs;
  public boolean mask;
  
  public KeyInputTee() {
    inputs = new ArrayList<>();
  }
  
  public void add( final KeyInput input ) {
    inputs.add( input );
  }
  
  @ Override
  public boolean hasKeyMask() {
    for ( final KeyInput input : inputs ) {
      if ( input.hasKeyMask() ) {
        return true;
      }
    }
    
    return false;
  }
  
  @ Override
  public void keyPressed( final int keycode ) {
    for ( final KeyInput input : inputs ) {
      input.keyPressed( keycode );
      
      if ( mask && input.hasKeyMask() ) {
        break;
      }
    }
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    for ( final KeyInput input : inputs ) {
      input.keyReleased( keycode );
      
      if ( mask && input.hasKeyMask() ) {
        break;
      }
    }
  }
  
  @ Override
  public void keyTyped( final char keychar ) {
    for ( final KeyInput input : inputs ) {
      input.keyTyped( keychar );
      
      if ( mask && input.hasKeyMask() ) {
        break;
      }
    }
  }
  
  public int size() {
    return inputs.size();
  }
}