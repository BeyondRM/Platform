package brm.platform.resource.graphics.image.tileset.tilesheet.tile;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.IOException;


/**
 *
 * @author Gregory
 */
public final class TileAnim extends Tile {
  private final BufferedImage[] image;
  // do we need another field or two in specifying the animation speed? might be another 4 bits (values 0 to 15) used

  public TileAnim(DataInputStream dis, BufferedImage... bis) throws IOException {
    super(dis);
    image = bis;
  }

  @Override
  protected BufferedImage get(int i) {
    return image[i];
  }
}
