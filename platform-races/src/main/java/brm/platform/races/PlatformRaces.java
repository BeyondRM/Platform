package brm.platform.races;
import abc.cryptology.AbcCryptology;
import brm.platform.architecture.loadable.AModuleLoading;
import brm.platform.architecture.loadable.progress.ProgressBar;
import brm.platform.races.race.Race;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.NoSuchPaddingException;


/**
 * The platform races handler. This singleton class allows loading species definitions, returning their properties to a
 * requesting class, and nothing more. We are not generally supporting players creating them in a game; race definition
 * must come from the game creator, made in the editor.
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

  private Races races;

  private PlatformRaces() {
  }

  @Override
  public final boolean isDataLoaded() {
    return dataLoaded;
  }

  @Override
  public final boolean isDataValidated() {
    return dataValidated;
  }

  @Override
  public final int getInitializedCount() {
    return initializedCount;
  }

  @Override
  public final void beforeInitialization(long l, File f, String s) {
    try {
      AbcCryptology.instance.performDecryption(l, races, s, f, "PBEWithMD5AndDES");
    } catch(NoSuchAlgorithmException | InvalidKeySpecException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IOException ex) {
      Logger.getLogger(PlatformRaces.class.getName()).log(Level.SEVERE, "Cannot decrypt game's race data.", ex);
    }
  }

  @Override
  public final void initializeBefore(ProgressBar pb) {
  }

  @Override
  public final void initializeDuring(ProgressBar pb) {
  }

  @Override
  public final void initializeFinish(ProgressBar pb) {
  }

  @Override
  public final void validation() {
  }

  public final Race getRace(int i) {
    return races.race[i];
  }
}
