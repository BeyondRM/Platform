package brm.platform.species;
import brm.platform.architecture.loadable.IPlatformLoading;
import brm.platform.architecture.loadable.progress.ProgressBar;
import java.io.File;


/**
 * <h2>PlatformSpecies</h2>
 * The platform species handler.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformSpecies PlatformSpecies
 */
public class PlatformSpecies extends IPlatformLoading {
  /**
   * The default {@link PlatformSpecies} instance.
   */
  public static final PlatformSpecies instance;

  static {
    instance = new PlatformSpecies();
  }

  private PlatformSpecies() {
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
  public void beforeInitialization(File f) {
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
