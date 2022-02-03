package de.androbin.shell.input.tee;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.*;
import java.util.function.*;

public final class MouseMotionInputTee<T> extends InputTee<T, MouseMotionInput>
    implements MouseMotionInput {
  public MouseMotionInputTee( final Iterable<T> sources,
      final Function<T, MouseMotionInput> resolver ) {
    super( sources, resolver );
  }
  
  public static MouseMotionInputTee<MouseMotionInput> from( final MouseMotionInput ... inputs ) {
    return from( Arrays.asList( inputs ) );
  }
  
  public static MouseMotionInputTee<MouseMotionInput> from(
      final Iterable<MouseMotionInput> inputs ) {
    return new MouseMotionInputTee<>( inputs, input -> input );
  }
  
  public static <T extends Shell> MouseMotionInputTee<T> fromShell( final Iterable<T> inputs ) {
    return new MouseMotionInputTee<>( inputs, shell -> shell.getInputs().mouseMotion );
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    process( input -> input.mouseDragged( x, y, button ) );
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    process( input -> input.mouseMoved( x, y ) );
  }
}