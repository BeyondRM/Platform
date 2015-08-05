package brm.platform.vocabulary.instance;
import java.util.Locale;
import java.util.MissingResourceException;


/**
 * A basic vocabulary instance.
 * @author Gregory <gregory.cheyney@gmail.com>
 */
public class VocabBasic extends Vocab {
  public VocabBasic(String s) {
    super(s);
  }

  @Override
  public void resetLocale(Locale l) throws MissingResourceException, NullPointerException {
    setLocale(l);
  }
}
