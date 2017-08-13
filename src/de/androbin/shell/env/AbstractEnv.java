package de.androbin.shell.env;

import de.androbin.func.*;
import de.androbin.shell.*;
import de.androbin.thread.*;

public abstract class AbstractEnv implements Env {
  public final Shell shell;
  
  private final Timer timer;
  
  public AbstractEnv( final Shell shell, final int fps ) {
    this.shell = shell;
    
    timer = new Timer();
    timer.running = shell::isRunning;
    timer.active = shell::isActive;
    
    setFPS( fps );
  }
  
  public final void runTimed( final FloatConsumer action ) {
    timer.run( action );
  }
  
  @ Override
  public void setFPS( final int fps ) {
    timer.setFPS( fps );
  }
  
  public final void start( final String name ) {
    new Thread( this::run, name ).start();
  }
  
  public final void startParallel( final String name ) {
    new Thread( this::runParallel, name ).start();
  }
}