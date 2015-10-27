package brm.platform.races.race;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.races.enums.AgeCat;
import brm.platform.races.enums.GenderType;
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
 * <h1>From the XML.</h1>
 * The BeyondRM Species definition. This is used to save the editable race-defining data from the editor. Race
 * definitions come before the individual character and class definitions, because it is supposed to provide the
 * unchanging properties that the class and the character depend upon.
 * <p/>
 * This includes the definitions of which types of equipable items, skills, and spell types a member of this race can
 * use; because these things are statically-defined, a game is improved by allowing only specific classes for certain
 * races, or created characters can only use certain armor or weapon types that are not "non-allowed" by a race
 * definition. This can allow a more "strategic" creation of game characters and classes that actually keep actual
 * racial attributes in mind....
 * @author Gregory
 */
public class Race extends Crypto {
  /**
   * The race graphics array. This is an array of <i>all</i> race graphics for this race; it should include one or more
   * instances of each age category and gender type. If a game will have a kind of "encyclopedia" of sorts, the getters
   * would be useful for finding the relevant images....
   * @see Race
   */
  private RaceGraphics[] graphics;

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @see Race
   */
  public Race() {
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      int i = dis.readByte();
      graphics = new RaceGraphics[i];
      for(int j = 0; j == i; j++) {
        RaceGraphics raceGraphics = new RaceGraphics();
        raceGraphics.performDecryption(dis);
      }
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeByte(graphics.length);
      for(RaceGraphics rg : graphics) {
        rg.performEncryption(dos);
      }
    }
  }

  public final RaceGraphics[] getGraphics(GenderType gt) {
    List<RaceGraphics> rg = new ArrayList<>(0);
    for(RaceGraphics rg1 : graphics) {
      if(rg1.getGenderType() == gt) {
        rg.add(rg1);
      }
    }
    //TODO: This method should return an array of graphics from the gender classification.
    return rg.isEmpty() ? null : (RaceGraphics[])rg.toArray();
  }

  public final RaceGraphics[] getGraphics(byte b) {
    List<RaceGraphics> rg = new ArrayList<>(0);
    for(RaceGraphics rg1 : graphics) {
      if(rg1.getAgeCategory() == AgeCat.fromId(b)) {
        rg.add(rg1);
      }
    }
    //TODO: This method should return an array of graphics from the age-category index.
    return rg.isEmpty() ? null : (RaceGraphics[])rg.toArray();
  }
}
