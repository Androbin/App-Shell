package de.androbin.shell.input.lock;

import de.androbin.shell.*;
import de.androbin.shell.input.*;
import java.util.function.*;

public final class InputLocks {
  private InputLocks() {
  }
  
  public static <T extends Shell> void apply( final Inputs inputs, final BooleanSupplier condition ) {
    if ( inputs.keyboard != null ) {
      inputs.keyboard = new KeyInputLock( inputs.keyboard, condition );
    }
    
    if ( inputs.mouse != null ) {
      inputs.mouse = new MouseInputLock( inputs.mouse, condition );
    }
    
    if ( inputs.mouseMotion != null ) {
      inputs.mouseMotion = new MouseMotionInputLock( inputs.mouseMotion, condition );
    }
    
    if ( inputs.mouseWheel != null ) {
      inputs.mouseWheel = new MouseWheelInputLock( inputs.mouseWheel, condition );
    }
  }
}