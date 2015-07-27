package brm.platform.races.race;
import abc.cryptology.logics.ACryptoLogic;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The race definition. This is the platform definition of a race or species, as defined in the Editor UI.
 * <p/>
 * Both the Editor and Engine use this class; the editor uses it to write the game data from the project data, then the
 * engine uses this same class to load race data into memory. An editor does not typically need to decrypt an encrypted
 * file, and the engine does not typically need to write encrypted data.
 * <h1>From the XML</h1>
 * The BeyondRM Species definition. This is used to save the editable race-defining data from the editor. Race
 * definitions come before the individual character and class definitions, because it is supposed to provide the
 * unchanging properties that the class and the character depend upon.
 * <p/>
 * This includes the definitions of which types of equipable items, skills, and spell types a member of this race can
 * use; because these things are statically-defined, a game is improved by allowing only specific classes for certain
 * races, or created characters can only use certain armor or weapon types that are not "unallowed" by a race
 * definition. This can allow a more "strategic" creation of game characters and classes that actually keep actual
 * racial attributes in mind....
 * @author Gregory
 */
public class PlatformRace extends ACryptoLogic {
  private List<RaceGraphics> graphics;

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      int i = dis.readByte();
      graphics = new ArrayList<>(i);
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
    }
  }
}
