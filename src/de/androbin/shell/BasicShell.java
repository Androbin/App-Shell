package de.androbin.shell;

import de.androbin.shell.input.*;
import de.androbin.shell.input.tee.*;
import java.awt.event.*;

public abstract class BasicShell extends AbstractShell {
  private KeyInputTee keyboardTee;
  private MouseInputTee mouseTee;
  private MouseMotionInputTee mouseMotionTee;
  private MouseWheelInputTee mouseWheelTee;
  
  public final void addKeyInput( final KeyInput input ) {
    if ( keyboardTee == null ) {
      keyboardTee = new KeyInputTee();
      getInputs().keyboard = keyboardTee;
    }
    
    keyboardTee.add( input );
  }
  
  public final void addMouseInput( final MouseInput input ) {
    if ( mouseTee == null ) {
      mouseTee = new MouseInputTee();
      getInputs().mouse = mouseTee;
    }
    
    mouseTee.add( input );
  }
  
  public final void addMouseMotionInput( final MouseMotionInput input ) {
    if ( mouseMotionTee == null ) {
      mouseMotionTee = new MouseMotionInputTee();
      getInputs().mouseMotion = mouseMotionTee;
    }
    
    mouseMotionTee.add( input );
  }
  
  public final void addMouseWheelInput( final MouseWheelInput input ) {
    if ( mouseWheelTee == null ) {
      mouseWheelTee = new MouseWheelInputTee();
      getInputs().mouseWheel = mouseWheelTee;
    }
    
    mouseWheelTee.add( input );
  }
  
  public final void exitOnEscape() {
    addKeyInput( new KeyInput() {
      @ Override
      public void keyReleased( final int keycode ) {
        if ( keycode == KeyEvent.VK_ESCAPE ) {
          setRunning( false );
        }
      }
    } );
  }
}