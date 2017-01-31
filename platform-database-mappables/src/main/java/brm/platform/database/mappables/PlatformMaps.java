package brm.platform.database.mappables;
import brm.platform.architecture.loadable.Loadable;
import brm.platform.architecture.loadable.progress.ProgressBar;
import java.io.File;


/**
 * The platform maps handler. This provides the definition of all the maps created in the editor; a map, in this sense,
 * is defined by its size (width, height, and depth), the tiles array, various events (characters/NPCs, static events),
 * and map attributes that are defined in the editor.
 * <p>
 * When the game is running, the engine's map object contains a link back to this class, so that it can receive the map
 * data and execute certain functionality based upon other qualifiers. For example, a map that a player enters could be
 * overridden or switched to a different map if the game time has progressed beyond a certain game time or other global
 * event or variable value.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformMaps() PlatformMaps()
 */
public final class PlatformMaps extends Loadable {
  /**
   * The default {@link PlatformMaps} instance.
   * @see #PlatformMaps
   */
  public static final PlatformMaps instance;

  static {
    instance = new PlatformMaps();
  }

  private Maps maps;

  private PlatformMaps() {
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
    maps = new Maps(l, s);
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
