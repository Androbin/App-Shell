package de.androbin.shell.input.lock;

import de.androbin.shell.input.*;
import java.util.function.*;

public final class MouseInputLock extends InputLock<MouseInput> implements MouseInput {
  public MouseInputLock( final MouseInput input, final BooleanSupplier condition ) {
    super( input, condition );
  }
  
  @ Override
  public void mouseClicked( final int x, final int y, final int button ) {
    process( input -> input.mouseClicked( x, y, button ) );
  }
  
  @ Override
  public void mousePressed( final int x, final int y, final int button ) {
    process( input -> input.mousePressed( x, y, button ) );
  }
  
  @ Override
  public void mouseReleased( final int x, final int y, final int button ) {
    process( input -> input.mouseReleased( x, y, button ) );
  }
}