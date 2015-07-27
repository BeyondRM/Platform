package brm.platform.races;
import brm.platform.architecture.loadable.AModuleLoading;
import brm.platform.architecture.loadable.progress.ProgressBar;
import java.io.File;


/**
 * <h2>PlatformRaces</h2>
 * The platform species handler.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformSpeciesPlatformRaces
 */
public class PlatformRaces extends AModuleLoading {
  /**
   * The default {@link PlatformRaces} instance.
   */
  public static final PlatformRaces instance;

  static {
    instance = new PlatformRaces();
  }

  private PlatformRaces() {
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
