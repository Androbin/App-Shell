package de.androbin.shell.input.tee;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class InputTees {
  private InputTees() {
  }
  
  public static <T extends Shell> void putShellTee( final Inputs inputs,
      final Iterable<T> source ) {
    putShellTee( inputs, source, shell -> false );
  }
  
  public static <T extends Shell> void putShellTee( final Inputs inputs,
      final Iterable<T> source, final Predicate<T> mask ) {
    final KeyInputTee<T> keyInput = KeyInputTee.fromShell( source );
    keyInput.mask = mask;
    inputs.keyboard = keyInput;
    
    final MouseInputTee<T> mouseInput = MouseInputTee.fromShell( source );
    mouseInput.mask = mask;
    inputs.mouse = mouseInput;
    
    final MouseMotionInputTee<T> mouseMotionInput = MouseMotionInputTee.fromShell( source );
    mouseMotionInput.mask = mask;
    inputs.mouseMotion = mouseMotionInput;
    
    final MouseWheelInputTee<T> mouseWheelInput = MouseWheelInputTee.fromShell( source );
    mouseWheelInput.mask = mask;
    inputs.mouseWheel = mouseWheelInput;
  }
}