package de.androbin.shell;

import de.androbin.shell.input.*;
import de.androbin.shell.input.tee.*;
import java.awt.event.*;
import java.util.*;

public abstract class BasicShell extends AbstractShell {
  protected final KeyInputTee keyboardTee;
  protected final MouseInputTee mouseTee;
  protected final MouseMotionInputTee mouseMotionTee;
  protected final MouseWheelInputTee mouseWheelTee;
  
  protected final List<KeyInput> keyInputs;
  protected final List<MouseInput> mouseInputs;
  protected final List<MouseMotionInput> mouseMotionInputs;
  protected final List<MouseWheelInput> mouseWheelInputs;
  
  public BasicShell() {
    keyInputs = new ArrayList<>();
    mouseInputs = new ArrayList<>();
    mouseMotionInputs = new ArrayList<>();
    mouseWheelInputs = new ArrayList<>();
    
    keyboardTee = new KeyInputTee( keyInputs );
    mouseTee = new MouseInputTee( mouseInputs );
    mouseMotionTee = new MouseMotionInputTee( mouseMotionInputs );
    mouseWheelTee = new MouseWheelInputTee( mouseWheelInputs );
    
    getInputs().keyboard = keyboardTee;
    getInputs().mouse = mouseTee;
    getInputs().mouseMotion = mouseMotionTee;
    getInputs().mouseWheel = mouseWheelTee;
  }
  
  public final void exitOnEscape() {
    keyInputs.add( new KeyInput() {
      @ Override
      public void keyReleased( final int keycode ) {
        if ( keycode == KeyEvent.VK_ESCAPE ) {
          setRunning( false );
        }
      }
    } );
  }
}