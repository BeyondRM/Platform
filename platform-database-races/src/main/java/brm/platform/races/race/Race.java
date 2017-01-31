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
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
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
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeByte(graphics.length);
      for(RaceGraphics rg : graphics) {
        rg.performEncryption(dos);
      }
    }
  }

  /**
   * Get a race graphics array. This returns ALL graphics, as a cloned array of the {@code graphics} field.
   * @return A {@link RaceGraphics} array.
   * @see Race
   * @see #graphics graphics
   * @see RaceGraphics
   */
  public synchronized final RaceGraphics[] getGraphics() {
    return graphics.clone();
  }

  /**
   * Get a race graphics array. This returns a sublist of the graphics, selected by age category only.
   * @param b A {@link Byte} value, representing an age category to find.
   * @return A {@link RaceGraphics} array.
   * @see ArrayList
   * @see List
   * @see Race
   * @see RaceGraphics
   */
  public synchronized final RaceGraphics[] getGraphics(byte b) {
    List<RaceGraphics> list = new ArrayList<>(0);
    for(RaceGraphics rg : graphics) {
      if(rg.getAgeCategory() == AgeCat.fromId(b)) {
        list.add(rg);
      }
    }
    return list.isEmpty() ? null : (RaceGraphics[])list.toArray();
  }

  /**
   * Get a race graphics array. This returns a sublist of the graphics, selected by age category and gender type.
   * @param g A {@link GenderType} instance, representing a gender type to find.
   * @param b A {@link Byte} value, representing an age category to find.
   * @return A {@link RaceGraphics} array.
   * @see ArrayList
   * @see List
   * @see Race
   * @see RaceGraphics
   */
  public synchronized final RaceGraphics[] getGraphics(byte b, GenderType g) {
    List<RaceGraphics> list = new ArrayList<>(0);
    for(RaceGraphics rg : graphics) {
      if(rg.getGenderType() == g && rg.getAgeCategory() == AgeCat.fromId(b)) {
        list.add(rg);
      }
    }
    return list.isEmpty() ? null : (RaceGraphics[])list.toArray();
  }

  /**
   * Get a race graphics array. This returns a sublist of the graphics, selected by gender type only.
   * @param g A {@link GenderType} instance, representing a gender type to find.
   * @return A {@link RaceGraphics} array.
   * @see ArrayList
   * @see List
   * @see Race
   * @see RaceGraphics
   */
  public synchronized final RaceGraphics[] getGraphics(GenderType g) {
    List<RaceGraphics> list = new ArrayList<>(0);
    for(RaceGraphics rg : graphics) {
      if(rg.getGenderType() == g) {
        list.add(rg);
      }
    }
    return list.isEmpty() ? null : (RaceGraphics[])list.toArray();
  }
}
