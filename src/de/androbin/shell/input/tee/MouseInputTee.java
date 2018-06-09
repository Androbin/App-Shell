package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;

public final class MouseInputTee implements MouseInput {
  private final Iterable<MouseInput> inputs;
  public boolean mask;
  
  public MouseInputTee( final Iterable<MouseInput> inputs ) {
    this.inputs = inputs;
  }
  
  @ Override
  public boolean hasMouseMask() {
    for ( final MouseInput input : inputs ) {
      if ( input.hasMouseMask() ) {
        return true;
      }
    }
    
    return false;
  }
  
  @ Override
  public void mouseClicked( final int x, final int y, final int button ) {
    for ( final MouseInput input : inputs ) {
      final boolean hasMask = input.hasMouseMask();
      input.mouseClicked( x, y, button );
      
      if ( mask && hasMask ) {
        break;
      }
    }
  }
  
  @ Override
  public void mousePressed( final int x, final int y, final int button ) {
    for ( final MouseInput input : inputs ) {
      final boolean hasMask = input.hasMouseMask();
      input.mousePressed( x, y, button );
      
      if ( mask && hasMask ) {
        break;
      }
    }
  }
  
  @ Override
  public void mouseReleased( final int x, final int y, final int button ) {
    for ( final MouseInput input : inputs ) {
      final boolean hasMask = input.hasMouseMask();
      input.mouseReleased( x, y, button );
      
      if ( mask && hasMask ) {
        break;
      }
    }
  }
}