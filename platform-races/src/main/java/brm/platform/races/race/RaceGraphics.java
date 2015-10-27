package brm.platform.races.race;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.races.enums.AgeCat;
import brm.platform.races.enums.GenderType;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The race-specific template graphics. Define basic template graphics for this race, by age, gender, or even sub-race.
 * @author Gregory
 */
public class RaceGraphics extends Crypto {
  /**
   * The gender type. For most races, this is generally either "male" or "female" to specify the appearance. The female
   * individual generally has softer face and body features; the male generally has harsher or harder features, such as
   * more developed musculature, facial hair (beards, mustaches), and a tendency to go bald as age progresses.
   * <p/>
   * A race's gender-types may contain neuter as well as hermaphrodite pseudo-genders. The former case, gender-neutral,
   * is useful for non-reproducing members such as in hive-colonies of drones supporting a queen or hierarchy; a latter
   * case of hermaphroditism may still be biologically (genetically speaking) predisposed to be either males or females
   * of this race, with perhaps a bias to being whichever gender-features are more prominent (unless surgical selection
   * could override this &mdash; not something the typical RPG will deal with, though). See Wikipedia for more details.
   */
  private GenderType genderType;
  /**
   * The abbreviation. This might be a two-to-six-character text string that is used to detail the specific graphic. No
   * specific methodology is mandated for the abbreviation; however, it might be easiest to have two characters for the
   * race, two characters for the gender, and two or more characters for the age category. Additional characters in the
   * string may specify if it is for a sub-race or specialization of the race.
   * <ul>
   * <li/>Assuming the image is for a teenage female human, the abbreviation might be "HuFeTn".
   * <li/>Assuming the image is for a male ancient wood-elf, the abbreviation might be "HuFeTn".
   * </ul>
   * An abbreviation is only used in the editor to help identify which graphic to use, either for character generation,
   * or for in-game encyclopedic lore; it is replaced with an ordinal reference if it is to be included in the game, at
   * all&hellip;.
   */
  private String abbreviation;
  /**
   * The age category. This specifies what age or time-period in the species life-span this image appears to relate to.
   * Unless you are defining an elemental being or a god that sprang forth fully-formed, age may be less important; but
   * <p/>
   * Generic age-categories may be one of the following (with equivalent information to a human lifespan):
   * <pre>
   * infant         -  0-2? post-birth life and experiences
   * toddler        -  2-5? after infancy, before elementary school
   * child          -  5-9? elementary school through middle school
   * preadolescent  -  9-13? middle school years
   * adolescent     - 13-18? high school years, puberty, dating, romance
   * early adult    - 19-25? collegiate schooling / traditional employment
   * middle adult   - 25-40? advancement to stable career/relationships
   * mature adult   - 40-60? the peak of a career
   * elderly adult  - 60-80? a person respected for accomplishments, age
   * ancient adult  - 80s++? a person venerated for accomplishments, age, knowledge
   * </pre>
   * Not all of the above need include an image; they are merely listed for generalization. Anything up to "adolescent"
   * probably will not be characters in a game; and characters that are "elderly" or older will probably be few and far
   * between in a game, perhaps literally reserved for the few respected and venerated masters of their realm.
   * @see RaceGraphics
   */
  private AgeCat ageCategory;
  /**
   * The image URL. This is the file reference for the literal image.
   * @see RaceGraphics
   */
  private String imageUrl;

  /**
   * A public constructor.
   * @see RaceGraphics
   */
  public RaceGraphics() {
  }

  /**
   * A public constructor. This constructor instantiates a new race graphics item, with the following parameters.
   * @param gt
   * @param s0 A {@link String} object, representing the {@link #abbreviation abbreviation}.
   * @param s1 A {@link String} object, representing the {@link #ageCategory age category}.
   * @param s2 A {@link String} object, representing the {@link #imageUrl image URL}.
   * @see RaceGraphics
   */
  public RaceGraphics(GenderType gt, String s0, AgeCat s1, String s2) {
    genderType = gt;
    abbreviation = s0;
    ageCategory = s1;
    imageUrl = s2;
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      byte b;
      String s;
      // read gendertype
      genderType = GenderType.fromByte(dis.readByte());
      // read abbreviation
      b = dis.readByte();
      s = "";
      for(int i = 0; i < b; i++) {
        s += dis.readChar();
      }
      abbreviation = s;
      // read age category
      ageCategory = AgeCat.fromId(dis.readByte());
      // read image url
      b = dis.readByte();
      s = "";
      for(int i = 0; i < b; i++) {
        s += dis.readChar();
      }
      imageUrl = s;
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeByte(genderType.name.length());
      dos.writeChars(genderType.name);
      dos.writeChars(abbreviation);
      dos.writeByte(ageCategory.ordinal());
      dos.writeChars(imageUrl);
    }
  }

  public GenderType getGenderType() {
    return genderType;
  }

  public String getAbbreviation() {
    return abbreviation;
  }

  public AgeCat getAgeCategory() {
    return ageCategory;
  }

  public String getImageUrl() {
    return imageUrl;
  }
}
