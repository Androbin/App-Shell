package de.androbin.shell.input.supply;

import java.util.function.*;

public class InputSupply<T> {
  private final Supplier<T> input;
  
  public InputSupply( final Supplier<T> input ) {
    this.input = input;
  }
  
  public void process( final Consumer<T> consumer ) {
    final T input = this.input.get();
    
    if ( input == null ) {
      return;
    }
    
    consumer.accept( input );
  }
}