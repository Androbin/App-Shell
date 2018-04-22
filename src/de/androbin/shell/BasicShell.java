package de.androbin.shell;

import de.androbin.shell.input.*;
import de.androbin.shell.input.tee.*;
import java.awt.event.*;

public abstract class BasicShell extends AbstractShell {
  public final KeyInputTee keyboardTee;
  public final MouseInputTee mouseTee;
  public final MouseMotionInputTee mouseMotionTee;
  public final MouseWheelInputTee mouseWheelTee;
  
  public BasicShell() {
    keyboardTee = new KeyInputTee();
    mouseTee = new MouseInputTee();
    mouseMotionTee = new MouseMotionInputTee();
    mouseWheelTee = new MouseWheelInputTee();
  }
  
  public final void addKeyInput( final KeyInput input ) {
    if ( keyboardTee.size() == 0 ) {
      getInputs().keyboard = keyboardTee;
    }
    
    keyboardTee.add( input );
  }
  
  public final void addMouseInput( final MouseInput input ) {
    if ( mouseTee.size() == 0 ) {
      getInputs().mouse = mouseTee;
    }
    
    mouseTee.add( input );
  }
  
  public final void addMouseMotionInput( final MouseMotionInput input ) {
    if ( mouseMotionTee.size() == 0 ) {
      getInputs().mouseMotion = mouseMotionTee;
    }
    
    mouseMotionTee.add( input );
  }
  
  public final void addMouseWheelInput( final MouseWheelInput input ) {
    if ( mouseWheelTee.size() == 0 ) {
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