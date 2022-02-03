package de.androbin.shell;

public interface Context {
  default void onAfterResumed() {
  }
  
  default void onBeforePaused() {
  }
  
  default void onConfig( Object value ) {
  }
  
  default void onPaused() {
  }
  
  default void onResumed() {
  }
  
  default void onStarted() {
  }
  
  default void onStopped() {
  }
}