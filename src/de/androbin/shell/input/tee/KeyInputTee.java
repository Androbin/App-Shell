package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;

public final class KeyInputTee implements KeyInput {
  private final Iterable<KeyInput> inputs;
  public boolean mask;
  
  public KeyInputTee( final Iterable<KeyInput> inputs ) {
    this.inputs = inputs;
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
      final boolean hasMask = input.hasKeyMask();
      input.keyPressed( keycode );
      
      if ( mask && hasMask ) {
        break;
      }
    }
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    for ( final KeyInput input : inputs ) {
      final boolean hasMask = input.hasKeyMask();
      input.keyReleased( keycode );
      
      if ( mask && hasMask ) {
        break;
      }
    }
  }
  
  @ Override
  public void keyTyped( final char keychar ) {
    for ( final KeyInput input : inputs ) {
      final boolean hasMask = input.hasKeyMask();
      input.keyTyped( keychar );
      
      if ( mask && hasMask ) {
        break;
      }
    }
  }
}