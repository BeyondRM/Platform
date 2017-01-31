package brm.platform.resource.graphics.image.skinset;
import brm.platform.resource.graphics.image.Graphic;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;


/**
 * A skinset. This defines a "core" window-skin, which is a series of images used in creating a game's user-interfaces,
 * various menu-states, and other screen decorations.<p/>
 * In RPG Maker, the window skin is a single graphic sized 128x128 pixels, that is parsed into four quadrants, each one
 * potentially being parsed further.
 * <ul>
 * <li/>The upper-left quadrant is a menu-screen gradient background; it may be stretch as necessary to fit a screen or
 * menu-state's background.
 * <li/>The lower-left quadrant is a  classic-television-like "scan lines" graphic, which may be overlaid on top of the
 * above background image.
 * <li/>The upper-right quadrant is the message-box and window border graphic. It often has a "rolled edge" appearance,
 * slightly rounded corners, and is typically a bright color such as near-white, that can be multiplied by other colors
 * to produce a new colored border. The internal zone of this area contains four navigation arrows that are overlaid on
 * the borders as necessary, to "hint" at directions that the area can be scrolled or moved.
 * <li/>The lower-right quadrant can be parsed into three zones, as well. The upper-left is a command-cursor selection,
 * the upper-right is the message box pause or waiting-for-button-press icon, and the bottom half is an array of colors
 * (4 rows, eight columns, total 32 colors) that are used to change the tint or hue of other window skinning elements.
 * </ul>
 * @author Gregory
 */
public final class Skinset extends Graphic {
  public Skinset(File f) throws IOException {
    super(f);
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
  }
}
