package brm.platform.window.skinning.skin;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


/**
 * <h2>SkinnableContainer</h2>
 * A "skinnable container". This class defines a particular window-skin that is to be used for containers.
 * @author Gregory
 * @see ASkinnable
 * @see BufferedImage
 */
public class SkinnableContainer extends ASkinnable {

  public SkinnableContainer(File f) throws IOException {
    super(f);
    //TODO: parse the subimages for the container corners, edges, and interiors...
  }
}
