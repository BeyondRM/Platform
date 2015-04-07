package brm.platform.architecture.callable;
import java.util.concurrent.Callable;


/**
 * <h2>CallableAppVer</h2>
 * @author Gregory
 */
public class CallableSystem implements Callable<String> {
  @Override
  public String call() throws Exception {
    String osname = System.getProperty("os.name");
    String osarch = System.getProperty("os.arch");
    String osvers = System.getProperty("os.version");
    String s = String.format("%s (%s) version %s", osname, osarch, osvers);
    return String.format("OPERATING SYSTEM:\n  %s", s);
  }
}
