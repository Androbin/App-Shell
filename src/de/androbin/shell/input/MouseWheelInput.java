package de.androbin.shell.input;

public interface MouseWheelInput {
  MouseWheelInput MASKING = new MouseWheelInput() {
    @ Override
    public boolean hasMouseWheelMask() {
      return true;
    }
  };
  
  default boolean hasMouseWheelMask() {
    return false;
  }
  
  default void mouseWheelMoved( int x, int y, int iclicks, float fclicks ) {
  }
}