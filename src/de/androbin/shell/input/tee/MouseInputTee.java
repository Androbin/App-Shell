package de.androbin.shell.input.tee;

import de.androbin.shell.input.*;
import java.util.*;

public final class MouseInputTee implements MouseInput {
  private final List<MouseInput> inputs;
  
  public MouseInputTee() {
    inputs = new ArrayList<>();
  }
  
  public void add( final MouseInput input ) {
    inputs.add( input );
  }
  
  @ Override
  public void mouseClicked( final int x, final int y, final int button ) {
    for ( final MouseInput input : inputs ) {
      input.mouseClicked( x, y, button );
    }
  }
  
  @ Override
  public void mousePressed( final int x, final int y, final int button ) {
    for ( final MouseInput input : inputs ) {
      input.mousePressed( x, y, button );
    }
  }
  
  @ Override
  public void mouseReleased( final int x, final int y, final int button ) {
    for ( final MouseInput input : inputs ) {
      input.mouseReleased( x, y, button );
    }
  }
}