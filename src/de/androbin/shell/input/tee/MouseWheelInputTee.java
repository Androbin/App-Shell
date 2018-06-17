package de.androbin.shell.input.tee;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.*;
import java.util.function.*;

public final class MouseWheelInputTee<T> extends InputTee<T, MouseWheelInput>
    implements MouseWheelInput {
  public MouseWheelInputTee( final Iterable<T> sources,
      final Function<T, MouseWheelInput> resolver ) {
    super( sources, resolver );
  }
  
  public static MouseWheelInputTee<MouseWheelInput> from( final MouseWheelInput ... inputs ) {
    return from( Arrays.asList( inputs ) );
  }
  
  public static MouseWheelInputTee<MouseWheelInput> from( final Iterable<MouseWheelInput> inputs ) {
    return new MouseWheelInputTee<>( inputs, input -> input );
  }
  
  public static <T extends Shell> MouseWheelInputTee<T> fromShell( final Iterable<T> inputs ) {
    return new MouseWheelInputTee<>( inputs, shell -> shell.getInputs().mouseWheel );
  }
  
  @ Override
  public void mouseWheelMoved( final int x, final int y, final int iclicks, final float fclicks ) {
    process( input -> input.mouseWheelMoved( x, y, iclicks, fclicks ) );
  }
}