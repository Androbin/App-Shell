package de.androbin.shell.input;

public interface MouseInput {
  MouseInput MASKING = new MouseInput() {
    @ Override
    public boolean hasMouseMask() {
      return true;
    }
  };
  
  default boolean hasMouseMask() {
    return false;
  }
  
  default void mouseClicked( int x, int y, int button ) {
  }
  
  default void mousePressed( int x, int y, int button ) {
  }
  
  default void mouseReleased( int x, int y, int button ) {
  }
}