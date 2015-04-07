package brm.platform.window.skinning.skin;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;


/**
 * <h2>ASkinnable</h2>
 * The "skinnable" definition. This abstract class defines the common attributes of an graphical "skin", or decoration,
 * for rendering components and containers which are displayed. A container may be the "message box" which displays the
 * various texts representing an inner-monologue or spoken-conversation line.
 * <p/>
 * In Enterbrain's RPG Maker (notably, in VX Ace), a "window skin" is a graphic that is 128x128, parsed into four basic
 * quadrants of 64x64, each being used for something specific. The upper-left part is the background linear gradient as
 * a monochromatic gray-scale. Below that, the lower-right is the background overlay pattern, by default representing a
 * series of lines. The upper-right is a complex grid of container bordering, as well as navigation-markers to show the
 * player which ways the container contents can be shifted for the view. Finally, the lower-right is further subdivided
 * into various container-decoration like message-continuation arrows, and up to 32 colors.
 * <p/>
 * Breaking from that simple standard, we are designing a window-skinning system that will use separate graphics images
 * (one for containers, one for components, and one for whatever else is necessary), breaking apart its various aspects
 * into something relevant. Both the container and component skins, like the RPG Maker equivalents, will have quadrants
 * for normal, selected, disabled, and "ghosted" (almost-invisible) aspects, but allowing for much higher resolutions.
 * @author Gregory
 */
abstract public class ASkinnable {
  private final File file;
  private final BufferedImage image;
  // For each buffered image array, the four indices are in the order of: normal, selected, disabled, and ghosted.
  /**
   * Background images, part one. This image array contains simple background gradients or hues, which provide baseline
   * patterns for the hind-most part of the container background.
   * <p/>
   * This is typically either a flat monochromic hue, or a linear or radial gradient. The precise color of these images
   * depend upon the nature of the game and-or the desired effect, including full 32-bit colors, with opacity; but, for
   * most games, this part can usually be a simple color, such as a shade of {@link Color#gray gray}.
   * @see ASkinnable
   * @see BufferedImage
   * @see #background2 background2
   */
  protected final BufferedImage[] background1;
  /**
   * Background images, part two. This image array contains simple background supplements, such as random compositional
   * overlay graphics; these may be "multiplied" against the contents of {@link #background1 background1} before being
   * displayed.
   * <p/>
   * A prime example of this might be in a girl's dating-simulation; the menu screens might have some moving pattern of
   * heart-shaped images that slowly move across the background. Of course, this may require a tweak in the menu class,
   * in order to "move" this layer, but it is possible...
   * @see ASkinnable
   * @see BufferedImage
   * @see #background1 background1
   */
  protected final BufferedImage[] background2;
  /**
   * Border clamp mask images. This image array provides the image-mask that "cuts off" pixels which should not be seen
   * outside of the actual border &mdash; essentially, this makes the actual container "look pretty" while constraining
   * the composite background to within the actual bordering and edging elements. This depends upon the per-pixel usage
   * of alpha-channel transparency, to either cull or display the background underneath.
   * <p/>
   * Borders can be as complex as necessary; by making this "clamp" cut out everything behind and beyond the border, an
   * edge-decoration will look as if it sits "outside" of the background; conversely, the edging can be made to look as
   * if it "sits inside of" the container (which it does, but the apparent border and actual border are not always this
   * equal).
   * @see ASkinnable
   * @see BufferedImage
   * @see #borderDecor borderDecor
   */
  protected final BufferedImage[] borderClamp;
  /**
   * Border decoration images. Containers have typically had borders four or more pixels wide, a rounded radius to each
   * corner, in order to visually separate aspects of a menu screen or contain a message box. In this implementation, a
   * border decoration can be quite a bit more elaborate, perhaps being made up like a fancy wrought-iron decoration or
   * elaborate woodworking edging of some earlier days.
   * @see ASkinnable
   * @see BufferedImage
   * @see #borderClamp borderClamp
   */
  protected final BufferedImage[] borderDecor;
  /**
   * Color multipliers. Each of the above buffered-image arrays can be "multiplied" against a base color, to provide an
   * extra level of window-skin customization. A player should be able to select from a list, a color to skew the given
   * image layer.
   * @see ASkinnable
   * @see BufferedImage
   * @see Color
   */
  protected Color[] colors;

  //We need some ints for the widths and heights of each sub-image of the window skin; such as, the size of corners and
  //borders, and any insets, et cetera.

  /**
   * A public constructor. This takes a single {@link File} reference, and parses it into various sub-images.
   * <p/>
   * The {@link WindowSkin} class must handle exceptions thrown from this class; for the most part, a game might still
   * continue from a single skin not being present; however, if no window skins exist, then the game should likely shut
   * down with a hard error &hellip; to let the game developer know something is VERY wrong in the window skins.
   * @param f A {@link File} object, representing the abstract file object.
   * @throws IOException if the image cannot be read from the file.
   */
  public ASkinnable(File f) throws IOException {
    file = f;
    image = ImageIO.read(file);
    BufferedImage bi;
    // setup the buffered image arrays, as their respective quadrants of the overall source image....
    bi = image.getSubimage(0, 0, 256, 256);
    background1 = new BufferedImage[] {
      bi.getSubimage(0, 0, 128, 128),
      bi.getSubimage(0, 128, 128, 128),
      bi.getSubimage(128, 0, 128, 128),
      bi.getSubimage(128, 128, 128, 128)
    };
    bi = image.getSubimage(0, 256, 256, 256);
    background2 = new BufferedImage[] {
      bi.getSubimage(0, 0, 128, 128),
      bi.getSubimage(0, 128, 128, 128),
      bi.getSubimage(128, 0, 128, 128),
      bi.getSubimage(128, 128, 128, 128)
    };
    bi = image.getSubimage(256, 0, 256, 256);
    borderClamp = new BufferedImage[] {
      bi.getSubimage(0, 0, 128, 128),
      bi.getSubimage(0, 128, 128, 128),
      bi.getSubimage(128, 0, 128, 128),
      bi.getSubimage(128, 128, 128, 128)
    };
    bi = image.getSubimage(256, 256, 256, 256);
    borderDecor = new BufferedImage[] {
      bi.getSubimage(0, 0, 128, 128),
      bi.getSubimage(0, 128, 128, 128),
      bi.getSubimage(128, 0, 128, 128),
      bi.getSubimage(128, 128, 128, 128)
    };
  }

  /**
   * Get the hindmost background. This image is used to lay down the basic background, which will get additional images
   * put upon it.
   * @param i An {@link Integer} value, representing the array index.
   * @return A {@link BufferedImage} object.
   * @see ASkinnable
   * @see #background1 background1
   * @see #background2 background2
   * @see #getBackground2(int) getBackground2(int)
   */
  public final BufferedImage getBackground1(int i) {
    // http://stackoverflow.com/questions/2318020/merging-two-images for "adding" images together
    return background1[i];
  }

  /**
   * Get the foremost background. This image is used to "accent" the hindmost graphic layer, with some kind of pattern,
   * such as using an alternating on-off row of lines, to simulate the old computer monitor "v-sync" mode.
   * @param i An {@link Integer} value, representing the array index.
   * @return A {@link BufferedImage} object.
   * @see ASkinnable
   */
  public final BufferedImage getBackground2(int i) {
    // http://stackoverflow.com/questions/2318020/merging-two-images for "adding" images together
    return background2[i];
  }

  /**
   * Get the border-clamp mask. This is the border-clamping mask, or filter, that defines what is "sliced off" from our
   * view of the skinnable object. Afterward, the decoration may occur.
   * @param i An {@link Integer} value, representing the array index.
   * @return A {@link BufferedImage} object.
   * @see ASkinnable
   * @see #borderClamp borderClamp
   * @see #borderDecor borderDecor
   * @see #getBorderDecor(int) getBorderDecor(int)
   */
  public final BufferedImage getBorderClamp(int i) {
    // http://stackoverflow.com/questions/2318020/merging-two-images for "adding" images together
    return borderClamp[i];
  }

  /**
   * Get the border decoration. This is an actual border graphic that will be laid on top of everything else, including
   * after the masking operation.
   * @param i An {@link Integer} value, representing the array index.
   * @return A {@link BufferedImage} object.
   * @see ASkinnable
   * @see #borderClamp borderClamp
   * @see #borderDecor borderDecor
   * @see #getBorderClamp(int) getBorderClamp(int)
   */
  public final BufferedImage getBorderDecor(int i) {
    // http://stackoverflow.com/questions/2318020/merging-two-images for "adding" images together
    return borderDecor[i];
  }

  /**
   * Get the color multipliers.
   * @return A {@link Color} array.
   * @see ASkinnable
   */
  public final Color[] getColors() {
    return colors.clone();
  }

  /**
   * Get the source location.
   * @return A {@link File} object.
   * @see ASkinnable
   */
  public final File getFile() {
    return file;
  }

  /**
   * Set the color multipliers.
   * @param cs A {@link Color} array, representing the new color multipliers.
   * @see ASkinnable
   */
  public final void setColors(Color[] cs) {
    colors = cs.clone();
  }
}
