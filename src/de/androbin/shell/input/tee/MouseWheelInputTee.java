package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;

public final class MouseWheelInputTee implements MouseWheelInput {
  private final Iterable<MouseWheelInput> inputs;
  public boolean mask;
  
  public MouseWheelInputTee( final Iterable<MouseWheelInput> inputs ) {
    this.inputs = inputs;
  }
  
  @ Override
  public boolean hasMouseWheelMask() {
    for ( final MouseWheelInput input : inputs ) {
      if ( input.hasMouseWheelMask() ) {
        return true;
      }
    }
    
    return false;
  }
  
  @ Override
  public void mouseWheelMoved( final int x, final int y, final int iclicks, final float fclicks ) {
    for ( final MouseWheelInput input : inputs ) {
      input.mouseWheelMoved( x, y, iclicks, fclicks );
      
      if ( mask && input.hasMouseWheelMask() ) {
        break;
      }
    }
  }
}