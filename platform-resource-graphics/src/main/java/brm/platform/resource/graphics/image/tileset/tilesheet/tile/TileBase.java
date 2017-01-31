package brm.platform.resource.graphics.image.tileset.tilesheet.tile;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.IOException;


/**
 *
 * @author Gregory
 */
public final class TileBase extends Tile {
  private final BufferedImage image;

  public TileBase(DataInputStream dis, BufferedImage bis) throws IOException {
    super(dis);
    image = bis;
  }

  @Override
  protected BufferedImage get(int i) {
    return image;
  }
}
