package brm.platform.resource.graphics.image.balloon;
import brm.platform.resource.graphics.image.GraphicTileable;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;


/**
 * An animated balloon auto-tile.
 * @author Gregory
 */
public class TileableBalloon extends GraphicTileable {
  public TileableBalloon(File f) throws IOException {
    super(f);
  }

  @Override
  public BufferedImage getSubimage(int i) {
    return null;
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    super.performDecryption(dis);
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    super.performEncryption(dos);
  }
}
