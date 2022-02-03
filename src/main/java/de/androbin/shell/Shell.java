package de.androbin.shell;

import de.androbin.shell.input.*;

public interface Shell extends Context {
  default void destroy() {
  }
  
  default void exit() {
    setRunning( false );
  }
  
  int getHeight();
  
  Inputs getInputs();
  
  int getWidth();
  
  default boolean isActive() {
    return true;
  }
  
  default boolean isDeadly() {
    return false;
  }
  
  boolean isRunning();
  
  void setRunning( boolean running );
  
  void setSize( int width, int height );
  
  default void update( float delta ) {
  }
  
  default void updateUI( float delta ) {
  }
}