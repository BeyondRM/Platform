package brm.platform.vocabulary.instance;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;


/**
 * A vocabulary definition. This abstract class is used to manage localization of text objects among platform or engine
 * modules in a controlled manner. It allows a game player to set or reset the locale for internationalization.
 * @author Gregory
 */
abstract public class Vocab {
  /**
   * The resource bundle base name. This is used to instantiate the resource bundle by converting the string to a path.
   * <p/>
   * This should only be set in the constructor, and does not need to be returned in any method.
   * @see Vocab
   */
  private transient final String basename;
  /**
   * The resource bundle locale. This is used to control which language locale the vocabulary unit use.
   * <p/>
   * This should only be set in the constructor, and does not need to be returned in any method.
   * @see Vocab
   */
  protected transient Locale locale;
  /**
   * The resource bundle instance. This is the resource bundle which is used to obtain localized texts.
   * <p/>
   * This should only be set in the constructor, and does not need to be returned in any method.
   * @see Vocab
   */
  protected transient ResourceBundle bundle;

  /**
   * A public constructor. This takes a String path and loads the target resource bundle.
   * @param s A {@link String} object, representing the baseline resource name.
   * @see Vocab
   */
  public Vocab(String s) {
    basename = s;
    bundle = ResourceBundle.getBundle(basename);
    locale = Locale.getDefault();
  }

  /**
   * Reset the locale for the vocabulary object. This method is overridden to set the locale, typically by calling this
   * parent class method {@link Vocab#setLocale(Locale)}, which also resets the bundle to read the internationalized
   * strings. (The platform vocabulary singleton should also call {@link ResourceBundle#clearCache()}, to force this.
   * <p/>
   * As a default implementation of this method is not provided, override methods may perhaps code their implementation
   * starting with this code:
   * <pre>
   *     setLocale(locale);
   * </pre> and finish off with performing any actions as necessary. For example, various modules may implement a Vocab
   * class to "pre-load" various localizable strings into memory, such as texts for menus and battle systems, that will
   * be commonly used.
   * <p/>
   * The overridden method automatically inherits the thrown exceptions for the above reason. Any properly-instantiated
   * vocabulary subclass should almost never need to encounter NullPointerException errors; so the only real concern is
   * in handling MissingResourceException cases, which are only a problem if no such localization bundle exists.
   * @param l A {@link Locale} instance, representing a target localization type.
   * @see Vocab
   * @throws MissingResourceException if no resource can be found for the base name.
   * @throws NullPointerException     if the base name or the locale are null.
   */
  abstract public void resetLocale(Locale l) throws MissingResourceException, NullPointerException;

  /**
   * Get the resource bundle.
   * @return A {@link ResourceBundle} object.
   * @see Vocab
   */
  protected final ResourceBundle getBundle() {
    return bundle;
  }

  /**
   * Set the locale and reset the bundle. This method is declared protected and final, meaning it cannot be overridden;
   * for changing the locale, please use {@link #resetLocale(Locale) resetLocale(Locale)} instead.
   * @param l A {@link Locale} instance, representing a target localization type.
   * @see Vocab
   * @throws MissingResourceException if no resource can be found for the base name.
   * @throws NullPointerException     if the base name or the locale are null.
   */
  protected final void setLocale(Locale l) throws MissingResourceException, NullPointerException {
    locale = l;
    bundle = ResourceBundle.getBundle(basename, locale);
  }
}
