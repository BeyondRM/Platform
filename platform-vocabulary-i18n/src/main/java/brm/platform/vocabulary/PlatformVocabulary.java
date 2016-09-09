package brm.platform.vocabulary;
import brm.platform.architecture.loadable.Loadable;
import brm.platform.architecture.loadable.progress.ProgressBar;
import brm.platform.vocabulary.instance.Vocab;
import java.io.File;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Platform Vocabulary management. This singleton class handles the internationalization of textual data for the game.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformVocabulary() PlatformVocabulary()
 */
public final class PlatformVocabulary extends Loadable {
  /**
   * The default instance.
   * @see PlatformVocabulary
   */
  public static final PlatformVocabulary instance;

  static {
    instance = new PlatformVocabulary();
  }

  /**
   * The vocabulary map. This contains references to module vocabulary which are maintained for the purpose of managing
   * hot-swapping of locales in all vocabularies at once. It should allow testing and debugging of translations while a
   * live instance is running.
   * @see PlatformVocabulary
   * @see #addVocab(String,Vocab) addVocab(String,Vocab)
   * @see #delVocab(String) delVocab(String)
   * @see #getVocab(String) getVocab(String)
   * @see #setLocale(Locale) setLocale(Locale)
   */
  private transient final Map<String, Vocab> map;

  {
    map = new ConcurrentHashMap<>(0);
  }

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @see PlatformVocabulary
   */
  private PlatformVocabulary() {
  }

  @Override
  public boolean isDataLoaded() {
    return dataLoaded;
  }

  @Override
  public boolean isDataValidated() {
    return dataValidated;
  }

  @Override
  public int getInitializedCount() {
    return initializedCount;
  }

  @Override
  public void beforeInitialization(long l, File f, String s) {
  }

  @Override
  public void initializeBefore(ProgressBar pb) {
  }

  @Override
  public void initializeDuring(ProgressBar pb) {
  }

  @Override
  public void initializeFinish(ProgressBar pb) {
  }

  @Override
  public void validation() {
  }

  /**
   * Get a vocabulary object.
   * @param s A {@link String} object, representing a map key.
   * @return A {@link Vocab} object.
   * @see PlatformVocabulary
   */
  public synchronized Vocab getVocab(String s) {
    return (!s.isEmpty() && map.containsKey(s)) ? map.get(s) : null;
  }

  /**
   * Add a vocabulary object.
   * @param s A {@link String} object, representing a map key.
   * @param v A {@link Vocab} object, representing a vocabulary.
   * @see PlatformVocabulary
   */
  public synchronized void addVocab(String s, Vocab v) {
    if(!s.isEmpty() && !map.containsKey(s) && v != null) {
      map.put(s, v);
    }
  }

  /**
   * Delete a vocabulary object.
   * @param s A {@link String} object, representing a map key.
   * @see PlatformVocabulary
   */
  public synchronized void delVocab(String s) {
    if(!s.isEmpty() && map.containsKey(s)) {
      map.remove(s);
    }
  }

  /**
   * Set the locale. This sets the current localization to the specified Locale instance.
   * @param l A {@link Locale} object, representing a language localization code.
   * @see PlatformVocabulary
   * @see ResourceBundle#clearCache()
   * @see Vocab
   * @see Vocab#resetLocale(Locale)
   */
  public synchronized void setLocale(Locale l) {
    if(l != null) {
      ResourceBundle.clearCache();
      for(Map.Entry<String, Vocab> entry : map.entrySet()) {
        Vocab vocab = entry.getValue();
        vocab.resetLocale(l);
      }
    }
  }
}
