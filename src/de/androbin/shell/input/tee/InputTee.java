package de.androbin.shell.input.tee;

import java.util.function.*;

public class InputTee<T, S> {
  private final Iterable<T> sources;
  private final Function<T, S> resolver;
  public Predicate<T> mask;
  
  public InputTee( final Iterable<T> sources, final Function<T, S> resolver ) {
    this.sources = sources;
    this.resolver = resolver;
    mask = source -> false;
  }
  
  public final boolean hasMask() {
    for ( final T source : sources ) {
      if ( mask.test( source ) ) {
        return true;
      }
    }
    
    return false;
  }
  
  protected final void process( final Consumer<S> consumer ) {
    for ( final T source : sources ) {
      final boolean hasMask = mask.test( source );
      final S input = resolver.apply( source );
      
      if ( input != null ) {
        consumer.accept( input );
      }
      
      if ( hasMask ) {
        break;
      }
    }
  }
}