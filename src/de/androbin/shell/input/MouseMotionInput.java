package de.androbin.shell.input;

public interface MouseMotionInput {
  MouseMotionInput MASKING = new MouseMotionInput() {
    @ Override
    public boolean hasMouseMotionMask() {
      return true;
    }
  };
  
  default boolean hasMouseMotionMask() {
    return false;
  }
  
  default void mouseDragged( int x, int y, int button ) {
  }
  
  default void mouseMoved( int x, int y ) {
  }
}