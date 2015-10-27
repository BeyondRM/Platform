package brm.platform.architecture.callable;
import java.util.concurrent.Callable;


/**
 * The callable version of the game core.
 * @author Gregory
 */
public class CallableVersionGameCore implements Callable<String> {
  @Override
  public String call() throws Exception {
    //TODO: This should be the version of the platform modules!
    return "versions";
  }
}
