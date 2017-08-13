package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;
import java.util.*;

public final class MouseMotionInputTee implements MouseMotionInput {
  private final List<MouseMotionInput> inputs;
  
  public MouseMotionInputTee() {
    inputs = new ArrayList<>();
  }
  
  public void add( final MouseMotionInput input ) {
    inputs.add( input );
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    for ( final MouseMotionInput input : inputs ) {
      input.mouseDragged( x, y, button );
    }
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    for ( final MouseMotionInput input : inputs ) {
      input.mouseMoved( x, y );
    }
  }
}