package de.androbin.shell;

public interface Context {
  default void onPaused() {
  }
  
  default void onResumed() {
  }
  
  default void onStarted() {
  }
  
  default void onStopped() {
  }
}