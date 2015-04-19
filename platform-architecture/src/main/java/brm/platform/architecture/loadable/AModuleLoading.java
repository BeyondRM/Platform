package brm.platform.architecture.loadable;
import brm.platform.architecture.loadable.progress.ProgressBar;
import java.io.File;


/**
 * <h2>AModuleLoading</h2>
 * Module-loading method declarations. This abstract class allows loading the default and instanced chronological data,
 * from their respective data-streams.
 * <p/>
 * This is for any platform-level content class that provides object collections that can be iterated through on module
 * initialization. The Platform modules are contained in a number of projects, and this provides an interface to define
 * the initialization steps in common.
 * <p/>
 * One thing to note: everything may still load, even on a "battle test" play, even if not needed; this is a little bit
 * memory-inefficient, but for purposes of battle testing should not be a problem. This is only a concern if developing
 * and play-testing on low-memory systems (yeah, I know, hard to find anymore).
 * <h3>Using a Progress Bar.</h3>
 * The use of a "progress bar" allows us to visually show the iteration step we are doing; in most cases, with a modern
 * computer and the recent Java version, we can iterate these steps quite rapidly, often finishing within just a couple
 * seconds (depending upon the complexity of a game).
 * @author Gregory
 * @see #sourcePath sourcePath
 * @see #dataLoaded dataLoaded
 * @see #dataValidated dataValidated
 * @see #initializedCount initializedCount
 * @see #isDataLoaded() isDataLoaded()
 * @see #isDataValidated() isDataValidated()
 * @see #getInitializedCount() getInitializedCount()
 * @see #initializeBefore(ProgressBar) initializeBefore(ProgressBar)
 * @see #initializeDuring(ProgressBar) initializeDuring(ProgressBar)
 * @see #initializeFinish(ProgressBar) initializeFinish(ProgressBar)
 * @see #validation() validation()
 */
abstract public class AModuleLoading {
  /**
   * The source path. This is the starting path where we should be able to find our game content. Typically it contains
   * a number of subdirectories which organize the file objects we want.
   * <p/>
   * For the most part, as mentioned in the class javadoc, many of the files will actually be instances of binary data,
   * parsed as pictures, so that we can convert each pixel's red-green-blue-alpha values into byte-based characters and
   * into the destination values.
   * @see AModuleLoading
   */
  protected File sourcePath = null;
  /**
   * Whether data is loaded. This might be set in the initialization before, during, or finish phases.
   * @see AModuleLoading
   * @see #isDataLoaded() isDataLoaded()
   */
  protected boolean dataLoaded = false;
  /**
   * Whether data is validated.
   * @see AModuleLoading
   * @see #isDataValidated() isDataValidated()
   */
  protected boolean dataValidated = false;
  /**
   * The collection size. This is for holding the count of objects that will be iterated through.
   * <p/>
   * This value is used within initialization, but likely not needed thereafter.
   * @see AModuleLoading
   * @see #initializeBefore(ProgressBar) initializeBefore(ProgressBar)
   * @see #initializeDuring(ProgressBar) initializeDuring(ProgressBar)
   * @see #initializeFinish(ProgressBar) initializeFinish(ProgressBar)
   */
  protected int initializedCount = 0;

  /**
   * Whether data is loaded. This determines if the platform module is considered "stable" for use in a game.
   * @return A {@link Boolean} condition.
   * @see AModuleLoading
   * @see #dataLoaded dataLoaded
   */
  abstract public boolean isDataLoaded();

  /**
   * Whether data is validated.
   * @return A {@link Boolean} condition.
   * @see AModuleLoading
   * @see #dataValidated dataValidated
   */
  abstract public boolean isDataValidated();

  /**
   * Get the initialization count. This is a getter method to obtain the total number of items in the target collection
   * to be used in the progress bar. Normally, we only need to use the following for the implementation body:
   * <pre>
   *    public int getInitializedCount() {
   *      return initializedCount;
   *    }
   * </pre>
   *
   * @return An {@link Integer} value.
   * @see AModuleLoading
   * @see #initializedCount initializedCount
   */
  abstract public int getInitializedCount();

  /**
   * Before initialization begins.
   * <p/>
   * This is a "meta-step" for starting things correctly, by preparing the source path where to look for files to read,
   * as well as the module's individual cryptology keys and values.
   * @param l A {@link Long} value, representing the cryptological initialization value.
   * @param f A {@link File} object, representing the base path to use.
   * @param s A {@link String} object, representing the cryptological key value.
   * @see AModuleLoading
   */
  abstract public void beforeInitialization(long l, File f, String s);

  /**
   * Before the initialization loading. Count the possible items to be loaded.
   * <p/>
   * Typical method implementation includes:
   * <ul>
   * <li/>Check that the {@link File} path is valid, and has the content we are looking for.
   * <li/>Count the actual file objects, as may be necessary.
   * <li/>Set our {@code initializedCount} field to the above total.
   * </ul>
   * For most modules, this step is meant to be completed quickly.
   * <p/>
   * We return to our initialization state to iterate through the next object. After all objects have finished this
   * step, we call {@link #initializeDuring(ProgressBar) initializeDuring(ProgressBar)} to perform any remaining tasks
   * necessary.
   * @param pb A {@link ProgressBar} object, representing an updating progress bar.
   * @see AModuleLoading
   * @see #initializedCount initializedCount
   * @see #initializeDuring(ProgressBar) initializeDuring(ProgressBar)
   */
  abstract public void initializeBefore(ProgressBar pb);

  /**
   * During the initialization loading. Load each object into the collection, parsing if necessary.
   * <p/>
   * Typical method implementation includes:
   * <ul>
   * <li/>Ensure our collection size is large enough to hold all collection items without needing to resize. We should
   * already have obtained our {@link #initializedCount initializedCount} value; this is used to initialize the array
   * size.
   * <li/>Get the file(s) for each collection object, then read them in as data. Any erroneous data may be discarded or
   * possibly reported through some means. Some data error might be minor enough to play through, so we don't need to
   * make it a "show stopper" for just any error.
   * <li/>Shrink (re-size) the collection size, if different from the specified size; this could happen if we found and
   * discarded any null or non-valid objects when iterating through the above step.
   * </ul>
   * The implementation of this method definition in each module is dependent upon the complexity of the data stored in
   * the files. In the editor, we read and save in plain-text resources where possible; but in order to not just simply
   * deliver our games with the game assets as plain-text, we can make much of it encoded as the RGBA byte values of a
   * graphics pixel. If security is a concern for some, the game maker could possibly wrap the data files in additional
   * encryption.
   * <p/>
   * We return to our initialization state to iterate through the next object. After all objects have finished this
   * step, we call {@link #initializeFinish(ProgressBar) initializeFinish(ProgressBar)} to perform any remaining tasks
   * necessary.
   * @param pb A {@link ProgressBar} object, representing an updating progress bar.
   * @see AModuleLoading
   * @see #initializedCount initializedCount
   * @see #initializeFinish(ProgressBar) initializeFinish(ProgressBar)
   */
  abstract public void initializeDuring(ProgressBar pb);

  /**
   * Finish the initialization loading.
   * <p/>
   * Typical method implementation includes:
   * <ul>
   * <li/>Basic "sanity check" to make sure values are within valid ranges. This could mean we must iterate through the
   * collection items and checking values.
   * <li/>anything else I haven't thought of yet.
   * </ul>
   * <p/>
   * We return to our initialization state to iterate through the next module object. After all objects have finished
   * this step, we would be considered "loaded" and "validated". The final step, if this is not a battle test instance,
   * is going to the title screen and handling any menu selection; battle tests go straight into the initialized battle
   * scene.
   * @param pb A {@link ProgressBar} object, representing an updating progress bar.
   * @see AModuleLoading
   * @see #initializedCount initializedCount
   */
  abstract public void initializeFinish(ProgressBar pb);

  /**
   * Perform data validation.
   * <p/>
   * "Validation" may be dependent upon the module instance, and intent of loading; but, for most reasons, a validation
   * method will attempt to ensure that the object is present and usable, and its object members can be also validated.
   * @see AModuleLoading
   */
  abstract public void validation();
}
