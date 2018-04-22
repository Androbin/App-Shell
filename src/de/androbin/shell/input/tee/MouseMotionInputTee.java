package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;
import java.util.*;

public final class MouseMotionInputTee implements MouseMotionInput {
  private final List<MouseMotionInput> inputs;
  public boolean mask;
  
  public MouseMotionInputTee() {
    inputs = new ArrayList<>();
  }
  
  public void add( final MouseMotionInput input ) {
    inputs.add( input );
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
      input.mouseDragged( x, y, button );
      
      if ( mask && input.hasMouseMotionMask() ) {
        break;
      }
    }
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    for ( final MouseMotionInput input : inputs ) {
      input.mouseMoved( x, y );
      
      if ( mask && input.hasMouseMotionMask() ) {
        break;
      }
    }
  }
  
  public int size() {
    return inputs.size();
  }
}