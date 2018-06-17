package de.androbin.shell.input.tee;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.*;
import java.util.function.*;

public final class MouseInputTee<T> extends InputTee<T, MouseInput> implements MouseInput {
  public MouseInputTee( final Iterable<T> sources, final Function<T, MouseInput> resolver ) {
    super( sources, resolver );
  }
  
  public static MouseInputTee<MouseInput> from( final MouseInput ... inputs ) {
    return from( Arrays.asList( inputs ) );
  }
  
  public static MouseInputTee<MouseInput> from( final Iterable<MouseInput> inputs ) {
    return new MouseInputTee<>( inputs, input -> input );
  }
  
  public static <T extends Shell> MouseInputTee<T> fromShell( final Iterable<T> inputs ) {
    return new MouseInputTee<>( inputs, shell -> shell.getInputs().mouse );
  }
  
  @ Override
  public void mouseClicked( final int x, final int y, final int button ) {
    process( input -> input.mouseClicked( x, y, button ) );
  }
  
  @ Override
  public void mousePressed( final int x, final int y, final int button ) {
    process( input -> input.mousePressed( x, y, button ) );
  }
  
  @ Override
  public void mouseReleased( final int x, final int y, final int button ) {
    process( input -> input.mouseReleased( x, y, button ) );
  }
}