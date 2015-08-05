package brm.platform.vocabulary;
import brm.platform.vocabulary.instance.Vocab;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ConcurrentHashMap;


/**
 * Platform Vocabulary management. This singleton class handles the internationalization of textual data for the game.
 * @author Gregory <gregory.cheyney@gmail.com>
 * @see #instance instance
 * @see #PlatformVocabulary() PlatformVocabulary()
 */
public class PlatformVocabulary {
  /**
   * The default instance.
   * @see #PlatformVocabulary
   */
  public static final PlatformVocabulary instance;

  static {
    instance = new PlatformVocabulary();
  }

  private transient final Map<String, Vocab> map;

  {
    map = new ConcurrentHashMap<>(0);
  }

  private PlatformVocabulary() {
  }

  public synchronized final void addVocab(String s, Vocab v) {
    if(!s.isEmpty() && !map.containsKey(s) && v != null) {
      map.put(s, v);
    }
  }

  public synchronized final void delVocab(String s) {
    if(!s.isEmpty() && map.containsKey(s)) {
      map.remove(s);
    }
  }

  public synchronized final void setLocale(Locale l) {
    if(l != null) {
      ResourceBundle.clearCache();
      for(Map.Entry<String, Vocab> entry : map.entrySet()) {
        String key = entry.getKey();
        Vocab vocab = entry.getValue();
        //
        vocab.resetLocale(l);
      }
    }
  }

  public final Vocab getVocab(String s) {
    return (!s.isEmpty() && map.containsKey(s))
        ? map.get(s)
        : null;
  }
}
