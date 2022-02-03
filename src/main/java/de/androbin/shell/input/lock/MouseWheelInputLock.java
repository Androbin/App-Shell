package de.androbin.shell.input.lock;

import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseWheelInputLock extends InputLock<MouseWheelInput>
    implements MouseWheelInput {
  public MouseWheelInputLock( final MouseWheelInput input, final BooleanSupplier condition ) {
    super( input, condition );
  }
  
  @ Override
  public void mouseWheelMoved( final int x, final int y, final int iclicks, final float fclicks ) {
    process( input -> input.mouseWheelMoved( x, y, iclicks, fclicks ) );
  }
}