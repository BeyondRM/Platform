package brm.platform.graphics;
import brm.platform.architecture.loadable.Loadable;
import brm.platform.architecture.loadable.progress.ProgressBar;
import java.io.File;


/**
 * The platform graphics handler. This singleton class is the entry point for loading and managing the various buffered
 * image files in a game platform.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformGraphics() PlatformGraphics()
 */
public final class PlatformGraphics extends Loadable {
  /**
   * The default instance.
   * @see PlatformGraphics
   */
  public static final PlatformGraphics instance;

  static {
    instance = new PlatformGraphics();
  }

  /**
   * The loader object. This is used to assist in reading the binary index that contains the graphics properties of the
   * whole game.
   * @see PlatformGraphics
   */
  private PlatformGraphicsLoader loader;

  /**
   * TODO: Add various graphics arrays.
   * <p/>
   * For each graphic-type, we need a specific array of a graphic parser data; as our data is accessed, we want to grab
   * the correct graphic type to be displayed. The types:
   * <pre>
   *   Abstract (ordinary pictures, non-parsed)
   *   Animations (generic, for battlers, special-effects, or otherwise)
   *   Balloons (animated)
   *   Facesets (character faces and bio pics)
   *   Iconsets (not animated, but may have a glint)
   *   Skinsets (window skinning)
   *   Tilesets (animated and not animated)
   * </pre>
   */

  /**
   * A private constructor.
   * @see PlatformGraphics
   */
  private PlatformGraphics() {
  }

  @Override
  public boolean isDataLoaded() {
    return dataLoaded;
  }

  @Override
  public boolean isDataValidated() {
    return dataValidated;
  }

  @Override
  public int getInitializedCount() {
    return initializedCount;
  }

  @Override
  public void beforeInitialization(long l, File f, String s) {
  }

  @Override
  public void initializeBefore(ProgressBar pb) {
  }

  @Override
  public void initializeDuring(ProgressBar pb) {
  }

  @Override
  public void initializeFinish(ProgressBar pb) {
  }

  @Override
  public void validation() {
  }
}
