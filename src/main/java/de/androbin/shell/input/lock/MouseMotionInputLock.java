package de.androbin.shell.input.lock;

import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseMotionInputLock extends InputLock<MouseMotionInput>
    implements MouseMotionInput {
  public MouseMotionInputLock( final MouseMotionInput input, final BooleanSupplier condition ) {
    super( input, condition );
  }
  
  @ Override
  public void mouseDragged( final int x, final int y, final int button ) {
    process( input -> input.mouseDragged( x, y, button ) );
  }
  
  @ Override
  public void mouseMoved( final int x, final int y ) {
    process( input -> input.mouseMoved( x, y ) );
  }
}