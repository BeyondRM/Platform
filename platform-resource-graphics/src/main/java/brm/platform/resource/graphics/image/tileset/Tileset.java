package brm.platform.resource.graphics.image.tileset;
import brm.platform.resource.graphics.image.tileset.tilesheet.ImageTilesheet;
import java.io.DataInputStream;
import java.io.IOException;


public final class Tileset {
  public String name;
  public byte mode; // really only need 4 modes: field type, area type, VX-compatible, and other (unknown)
  public ImageTilesheet[] tilesheets;
  public String notebox; // either a string, or a scriptable/eventable object. I don't like scripting in noteboxes!!!!

  public Tileset() {
  }

  public Tileset(DataInputStream dis) throws IOException {
  }
}
