package de.androbin.shell.input;

public interface MouseWheelInput {
  default boolean hasMouseWheelMask() {
    return false;
  }
  
  default void mouseWheelMoved( int x, int y, int iclicks, float fclicks ) {
  }
}