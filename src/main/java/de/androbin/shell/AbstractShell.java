package de.androbin.shell;

import de.androbin.shell.input.*;

public abstract class AbstractShell implements Shell {
  private final Inputs inputs;
  
  private boolean active;
  private boolean deadly;
  private boolean running;
  
  private int width;
  private int height;
  
  public AbstractShell() {
    this.inputs = new Inputs();
    
    active = true;
    deadly = true;
  }
  
  @ Override
  public final int getHeight() {
    return height;
  }
  
  @ Override
  public final Inputs getInputs() {
    return inputs;
  }
  
  @ Override
  public final int getWidth() {
    return width;
  }
  
  @ Override
  public final boolean isActive() {
    return active;
  }
  
  @ Override
  public final boolean isDeadly() {
    return deadly;
  }
  
  @ Override
  public final boolean isRunning() {
    return running;
  }
  
  protected abstract void onResized( int width, int height );
  
  protected final void setActive( final boolean active ) {
    this.active = active;
  }
  
  protected final void setDeadly( final boolean deadly ) {
    this.deadly = deadly;
  }
  
  @ Override
  public final void setRunning( final boolean running ) {
    this.running = running;
  }
  
  @ Override
  public final void setSize( final int width, final int height ) {
    if ( width != this.width || height != this.height ) {
      this.width = width;
      this.height = height;
      
      onResized( width, height );
    }
  }
}