package de.androbin.shell.input.supply;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class InputSupply {
  private InputSupply() {
  }
  
  public static <T> Supplier<T> fromInputs( final Supplier<Inputs> inputs,
      final Function<Inputs, T> func ) {
    return () -> {
      final Inputs inputs1 = inputs.get();
      return inputs1 == null ? null : func.apply( inputs1 );
    };
  }
  
  public static Supplier<Inputs> fromShell( final Supplier<Shell> shell ) {
    return () -> {
      final Shell shell1 = shell.get();
      return shell1 == null ? null : shell1.getInputs();
    };
  }
}