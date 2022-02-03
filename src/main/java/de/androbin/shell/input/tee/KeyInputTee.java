package de.androbin.shell.input.tee;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.*;
import java.util.function.*;

public final class KeyInputTee<T> extends InputTee<T, KeyInput> implements KeyInput {
  public KeyInputTee( final Iterable<T> sources, final Function<T, KeyInput> resolver ) {
    super( sources, resolver );
  }
  
  public static KeyInputTee<KeyInput> from( final KeyInput ... inputs ) {
    return from( Arrays.asList( inputs ) );
  }
  
  public static KeyInputTee<KeyInput> from( final Iterable<KeyInput> inputs ) {
    return new KeyInputTee<>( inputs, input -> input );
  }
  
  public static <T extends Shell> KeyInputTee<T> fromShell( final Iterable<T> inputs ) {
    return new KeyInputTee<>( inputs, shell -> shell.getInputs().keyboard );
  }
  
  @ Override
  public void keyPressed( final int keycode ) {
    process( input -> input.keyPressed( keycode ) );
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    process( input -> input.keyReleased( keycode ) );
  }
  
  @ Override
  public void keyTyped( final char keychar ) {
    process( input -> input.keyTyped( keychar ) );
  }
}