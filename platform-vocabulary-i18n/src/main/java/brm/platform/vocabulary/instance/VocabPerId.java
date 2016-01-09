package brm.platform.vocabulary.instance;
import java.util.Locale;
import java.util.MissingResourceException;


/**
 * A vocabulary instance of per-ID tracked values. This class is useful to use if desiring to keep "global" strings in
 * memory during a game; such as for the menu and scene strings that may be needed at any time.
 * @author Gregory
 */
abstract public class VocabPerId extends Vocab {
  /**
   * A public constructor.
   * @param s A {@link String object, representing the baseline resource name.
   * @see VocabPerId
   */
  public VocabPerId(String s) {
    super(s);
  }

  /**
   * Get a localized text, per identifier. In this case, the identifier is an integer-based value equating to the class
   * fields in an extended vocabulary class.
   * <p/>
   * For instance, say the override class contains the localizable strings for our engine system menus; the class would
   * also define public static integer fields for each string, and a private String field for each text to be returned.
   * Then, within this method, a developer could either make a complex "if: else if: else" branching, or just create an
   * easier "switch - case" construct (I prefer this method) to simplify things.
   * <p><i><b>WARNING:</b> When creating the method {@code resetLocale(Locale)}, it may be important to reload each of
   * the localized texts again, so that localizations are maintained for the active locale.</i></p>
   * @param i An {@link Integer} value, representing a source text ID to return.
   * @return A {@link String} object.
   * @see VocabPerId
   */
  abstract public String getString(int i);

  @Override
  public void resetLocale(Locale l) throws MissingResourceException, NullPointerException {
    setLocale(l);
  }
}
