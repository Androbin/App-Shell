package de.androbin.shell.env;

public interface Env {
  void run();
  
  void runParallel();
  
  void setFPS( int fps );
}