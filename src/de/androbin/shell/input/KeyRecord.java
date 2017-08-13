package de.androbin.shell.input;

import java.util.*;

public final class KeyRecord implements KeyInput {
  private final Set<Integer> keys;
  
  public KeyRecord() {
    keys = new HashSet<>();
  }
  
  public boolean check( final int keycode ) {
    return keys.contains( keycode );
  }
  
  @ Override
  public void keyPressed( final int keycode ) {
    keys.add( keycode );
  }
  
  @ Override
  public void keyReleased( final int keycode ) {
    keys.remove( keycode );
  }
}