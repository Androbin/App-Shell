package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;
import java.util.*;

public final class MouseWheelInputTee implements MouseWheelInput {
  private final List<MouseWheelInput> inputs;
  public boolean mask;
  
  public MouseWheelInputTee() {
    inputs = new ArrayList<>();
  }
  
  public void add( final MouseWheelInput input ) {
    inputs.add( input );
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
  
  public int size() {
    return inputs.size();
  }
}