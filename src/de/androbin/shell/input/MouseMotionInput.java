package de.androbin.shell.input;

public interface MouseMotionInput {
  default void mouseDragged( int x, int y, int button ) {
  }
  
  default void mouseMoved( int x, int y ) {
  }
}