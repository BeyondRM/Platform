package brm.platform.resource.graphics.image.balloon;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.resource.graphics.image.GraphicTileable;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;


/**
 * Balloon graphics. In BeyondRM, a "balloon" is much like its parallel from RPG Maker VX Ace; except that this version
 * has more images in the animation than RM would allow.
 * @author Gregory
 */
public final class Balloon extends GraphicTileable {
  /**
   * The images. This is an array of graphic images, parsed out of a larger balloon graphic, where each image equals an
   * animation frame graphic.
   * @see Balloon
   */
  private final BufferedImage[] images;

  /**
   * A public constructor.
   * @param f A {@link File} object, representing the source file.
   * @param bis
   * @throws java.io.IOException
   * @see Balloon
   */
  public Balloon(File f, BufferedImage... bis) throws IOException {
    super(f);
    images = bis;
  }

  @Override
  public BufferedImage getSubimage(int i) {
    return images[i];
  }

  @Override
  public synchronized void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      super.performDecryption(dis);
    }
  }

  @Override
  public synchronized void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      super.performEncryption(dos);
    }
  }
}
