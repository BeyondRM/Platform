package brm.platform.races.enums;
import java.util.ResourceBundle;

/**
 * The gender types. This enumeration defines the different types of gender that a biological being is identified with;
 * it does not represent a choice of sexuality, only of which sex organs and traits the individual has.
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
  g0("Female"),
  g1("Male"),
  g2("Neuter"),
  g3("Hermaphrodite");
  public final String name;
  public final String note;
  public final String adj;
  public final String pro;
  public final String pos;

  private GenderType(String s) {
    ResourceBundle rb = ResourceBundle.getBundle("brm/platform/species/i18n/GenderType.properties");
    name = rb.getString(String.format("gender.%s.base.name", s));
    note = rb.getString(String.format("gender.%s.base.note", s));
    adj = rb.getString(String.format("gender.%s.desc.adjective", s));
    pro = rb.getString(String.format("gender.%s.desc.pronoun", s));
    pos = rb.getString(String.format("gender.%s.desc.possessive", s));
  }
}
