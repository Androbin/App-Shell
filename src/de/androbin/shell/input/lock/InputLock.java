package de.androbin.shell.input.lock;

import java.util.function.*;

public class InputLock<T> {
  private final T input;
  private final BooleanSupplier condition;
  
  public InputLock( final T input, final BooleanSupplier condition ) {
    this.input = input;
    this.condition = condition;
  }
  
  public void process( final Consumer<T> consumer ) {
    if ( !condition.getAsBoolean() ) {
      return;
    }
    
    consumer.accept( input );
  }
}