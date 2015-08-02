package brm.platform.races.enums;
import java.util.ResourceBundle;


/**
 * The gender types. This enumeration defines the different types of gender that a biological being is identified with;
 * it does not represent a choice of sexuality, only of which sex organs and traits the individual has. It also defines
 * basic default attributes to address a member of this race by gender: using the gender as a name, adjective, pronoun,
 * or possessive term.
 * <p/>
 * This allows for defining more than just the default "male" and "female" genders; it contains a "neuter" (non-gender)
 * and "hermaphrodite" gender roles, for just a little more variety. A hermaphrodite is an individual that contains the
 * sexual organs and traits of both male and female
 * @author Gregory
 * @see #g0 g0
 * @see #g1 g1
 * @see #g2 g2
 * @see #g3 g3
 */
public enum GenderType {
  /**
   * Gender is female, or feminine. The individual has the gender traits for bearing young, and nurturing them.
   * @see GenderType
   */
  g0((byte)1, "Female"),
  /**
   * Gender is male, or masculine. The individual has the gender traits for being a female's procreative partner, which
   * means fertilizing the ova that become a new biological being.
   * @see GenderType
   */
  g1((byte)2, "Male"),
  /**
   * Gender is neuter (non-gender). It's possible a neuter being exhibits gender traits of either males or females with
   * a greater or lesser degree of prominence; without getting <i>too</i> technical, races having a neuter gender would
   * either not reproduce via sexual means or the neuter individuals would have no function for reproduction.
   * <p/>
   * The former above case means that if all members of the race are neuter, the race inherently reproduces via asexual
   * means &mdash; by growing buds or shoots on their own body, which at some point "break off" to become a tinier body
   * that grows up to its own being. Or, in some cases, in advanced societies, cloning is the method used. (Essentially
   * the Asgard in the StarGate canon had become sexless/gender-less some thousands of years before, so ... yeah. Could
   * this become part of your game?
   * @see GenderType
   */
  g2((byte)4, "Neuter"),
  /**
   * Gender is hermaphroditic. A hermaphrodite is somewhat unusual; technically, it's when a being has gender traits of
   * both male and female together, which happens so infrequently that it's referred to as a biological aberration.
   * @see GenderType
   */
  g3((byte)7, "Hermaphrodite");
  /**
   * The ID of the gender. This is used in storing the gender-identity as a byte-based value instead of a Character or
   * String object; a single Byte is guaranteed to take only eight bits, with values in the range of -128 to 127, which
   * means up to 255 "genders" could be possible (but too complex, so the smallest native type is used).
   * @see GenderType
   */
  protected final byte id;
  /**
   * The gender I18N name-part. This is used in localization of the gender texts.
   * @see GenderType
   */
  public final String base;
  /**
   * The gender name. Things like: 'female', 'male', and 'neuter'.
   * @see GenderType
   */
  public final String name;
  /**
   * The gender note. A general note is sufficient, or perhaps only a descriptive word or two.
   * @see GenderType
   */
  public final String note;
  /**
   * The gender adjective. Things like: 'feminine', 'masculine', and 'neutral'.
   * @see GenderType
   */
  public final String adj;
  /**
   * The gender address pronoun. Things like: 'she', 'he', and 'it'.
   * @see GenderType
   */
  public final String pro;
  /**
   * The gender pronoun possessive. Things like: 'hers', 'his', and 'its'.
   * @see GenderType
   */
  public final String pos;

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @param b A {@link Byte} value, representing the gender type as a value.
   * @param s A {@link String} object, representing an internationalization name.
   * @see GenderType
   */
  private GenderType(byte b, String s) {
    id = b;
    base = s;
    ResourceBundle rb = ResourceBundle.getBundle("brm/platform/races/i18n/GenderType.properties");
    name = rb.getString(String.format("gender.%s.base.name", base));
    note = rb.getString(String.format("gender.%s.base.note", base));
    adj = rb.getString(String.format("gender.%s.desc.adjective", base));
    pro = rb.getString(String.format("gender.%s.desc.pronoun", base));
    pos = rb.getString(String.format("gender.%s.desc.possessive", base));
  }

  /**
   * Get the gender type from a byte. This takes a byte value and iterates through the enumeration values. If finding a
   * match, it is returned; if nothing matches, the female gender is returned by default. (Perhaps it could be 'neuter'
   * instead; although in games where the edge-case is returned, it might appear odd if one character refers to another
   * as 'it'.)
   * @param b A {@link Byte} value, representing the gender type as a value.
   * @return A {@link GenderType} instance.
   * @see GenderType
   */
  public static final GenderType fromByte(byte b) {
    for(GenderType gt : values()) {
      if(gt.id == b) {
        return gt;
      }
    }
    return GenderType.g0;
  }
}
