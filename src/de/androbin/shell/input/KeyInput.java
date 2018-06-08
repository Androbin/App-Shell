package de.androbin.shell.input;

public interface KeyInput {
  KeyInput MASKING = new KeyInput() {
    @ Override
    public boolean hasKeyMask() {
      return true;
    }
  };
  
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