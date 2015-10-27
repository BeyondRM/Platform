package brm.platform.architecture.callable;
import java.util.ResourceBundle;
import java.util.concurrent.Callable;


/**
 * A callable baseline introduction instance. This is for beginning an error log with a localizable message to send the
 * error report to the development team, or report it to the Github repository's issue tracker&hellip;.
 * @author Gregory
 */
public class CallableBaseIntroduction implements Callable<String> {
  private final ResourceBundle bundle;
  private final String[] message;

  public CallableBaseIntroduction() {
    bundle = ResourceBundle.getBundle("brm.platform.baseline.crashing.callable.bundles.Callable");
    message = new String[] {
      "callable.intro0", "callable.intro1", "callable.intro2",
      "callable.intro3", "callable.intro4", "callable.intro5",
      "callable.intro6", "callable.intro7", "callable.intro8",
      "callable.intro9", "callable.introA", "callable.introB"
    };
  }

  @Override
  public String call() {
    String s = "";
    for(String string : message) {
      s += bundle.getString(string);
      s += "\n";
    }
    s += "========================================\n";
    return s;
  }
}
