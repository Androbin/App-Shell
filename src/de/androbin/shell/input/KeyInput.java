package de.androbin.shell.input;

public interface KeyInput {
  default boolean hasKeyMask() {
    return false;
  }
  
  default void keyPressed( int keycode ) {
  }
  
  default void keyReleased( int keycode ) {
  }
  
  default void keyTyped( char keychar ) {
  }
}