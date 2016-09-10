package brm.platform.graphics.graphic;
import abc.cryptology.logics.Crypto;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * Abstract graphic definition. This abstract class provides the baseline definition that all the platform graphics can
 * depend upon.
 * <p/>
 * Graphics objects exist in one of two modes: those that are used whole, and those which are parsed as tileable images
 * from a root graphic. The former are kept as a file reference and the image will be copied wholesale into our screen.
 * The latter, a parsed graphic, may be used for animations, or merely for tile-sheets, such as what tile-maps are made
 * from.
 * @author Gregory
 */
abstract public class Graphic extends Crypto {
  // final fields, set in the constructor:
  /**
   * The source file. This is the file reference to the graphic image, to be read or parsed as necessary.
   * @see Graphic
   */
  protected final File file;
  /**
   * Whether it exist. This is true if the object actually is a file and can be read.
   * @see Graphic
   */
  protected final boolean exists;
  /**
   * The X size. This is the width of the image.
   * @see Graphic
   */
  protected final int sizeX;
  /**
   * The Y size. This is the height of the image.
   * @see Graphic
   */
  protected final int sizeY;
  // non-final fields, can be set anywhere:
  /**
   * The image source. This is the image as a readable Java object.
   * @see Graphic
   */
  protected BufferedImage image;
  /**
   * Whether loaded. The image is loaded if it {@link #exists exists} and {@link #image image} is not null; we presume
   * that the image binary bits can be read and rendered to the screen device.
   * @see Graphic
   */
  protected boolean loaded = false;

  /**
   * A public constructor. This first sets the file source, computes whether it exists, loads the image, and then finds
   * the X and Y sizes of the image.
   * @param f A {@link File} object, representing the {@link #file file} object.
   * @throws IOException
   * @see Graphic
   */
  public Graphic(File f) throws IOException {
    file = f;
    exists = file != null && file.exists() && file.isFile();
    Graphic.this.imageLoad();
    sizeX = exists && loaded ? image.getWidth() : 0;
    sizeY = exists && loaded ? image.getHeight() : 0;
  }

  /**
   * Try to load the image.
   * @throws IOException
   * @see Graphic
   */
  public final void imageLoad() throws IOException {
    if(image == null && exists) {
      image = exists ? ImageIO.read(file) : null;
      loaded = exists && image != null;
    }
  }

  /**
   * @see Graphic
   */
  public final void imageUnload() {
    if(image != null) {
      image = null;
      loaded = false;
    }
  }

  /**
   * Get the image.
   * @return A {@link BufferedImage} object.
   * @see Graphic
   */
  public BufferedImage getImage() {
    return image;
  }
}
