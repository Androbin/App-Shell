package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;

public final class MouseMotionInputTee implements MouseMotionInput {
  private final Iterable<MouseMotionInput> inputs;
  public boolean mask;
  
  public MouseMotionInputTee( final Iterable<MouseMotionInput> inputs ) {
    this.inputs = inputs;
  }
  
  @ Override
  public boolean hasMouseMotionMask() {
    for ( final MouseMotionInput input : inputs ) {
      if ( input.hasMouseMotionMask() ) {
        return true;
      }
    }
    
    return false;
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    for ( final MouseMotionInput input : inputs ) {
      final boolean hasMask = input.hasMouseMotionMask();
      input.mouseDragged( x, y, button );
      
      if ( mask && hasMask ) {
        break;
      }
    }
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    for ( final MouseMotionInput input : inputs ) {
      final boolean hasMask = input.hasMouseMotionMask();
      input.mouseMoved( x, y );
      
      if ( mask && hasMask ) {
        break;
      }
    }
  }
}