package brm.platform.architecture.callable;
import java.util.concurrent.Callable;


/**
 * <h2>CallableVersionGameCore</h2>
 * @author Gregory
 */
public class CallableVersionJavaVMVendor implements Callable<String> {
  @Override
  public String call() throws Exception {
    return String.format("%s (%s) %s",
                         System.getProperty("java.vm.name"),
                         System.getProperty("java.vm.info"),
                         System.getProperty("java.vm.vendor"));
  }
}
