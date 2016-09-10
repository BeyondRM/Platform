package brm.platform.items;
import brm.platform.architecture.loadable.Loadable;
import brm.platform.architecture.loadable.progress.ProgressBar;
import java.io.File;


/**
 * The Platform Items. This static-instanced class is the baseline platform module that contains all the definable item
 * objects in a game; it allows arranging the objects into their proper categories and subtypes.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformItems() PlatformItems()
 */
public final class PlatformItems extends Loadable {
  /**
   * The default instance.
   * @see #PlatformItems
   */
  public static final PlatformItems instance;

  static {
    instance = new PlatformItems();
  }

  private final Items items = new Items();

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @see PlatformItems
   */
  private PlatformItems() {
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
    sourcePath = f;
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

  public Items getItems() {
    return items;
  }
}
