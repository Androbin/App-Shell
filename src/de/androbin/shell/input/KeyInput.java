package de.androbin.shell.input;

public interface KeyInput {
  default void keyPressed( int keycode ) {
  }
  
  default void keyReleased( int keycode ) {
  }
  
  default void keyTyped( char keychar ) {
  }
}