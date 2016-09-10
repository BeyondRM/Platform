package brm.platform.system;
import brm.platform.architecture.loadable.Loadable;
import brm.platform.architecture.loadable.progress.ProgressBar;
import java.io.File;


/**
 * The Platform System singleton.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformSystem() PlatformSystem()
 */
public final class PlatformSystem extends Loadable {
  /**
   * The default instance.
   * @see #PlatformSystem
   */
  public static final PlatformSystem instance;

  static {
    instance = new PlatformSystem();
  }

  // system fields: window skins, game chronology/timing, things that are statically-defined for this game instance....

  private PlatformSystem() {
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
