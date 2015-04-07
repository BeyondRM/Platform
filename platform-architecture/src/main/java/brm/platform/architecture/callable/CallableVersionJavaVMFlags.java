package brm.platform.architecture.callable;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;


/**
 * <h2>CallableVersionGameCore</h2>
 * @author Gregory
 */
public class CallableVersionJavaVMFlags implements Callable<String> {
  @Override
  public String call() throws Exception {
    RuntimeMXBean runtimemxbean = ManagementFactory.getRuntimeMXBean();
    List<String> list = runtimemxbean.getInputArguments();
    int i = 0;
    StringBuilder sb = new StringBuilder(0);
    Iterator<String> iterator = list.iterator();
    while(iterator.hasNext()) {
      String s = iterator.next();
      if(s.startsWith("-X")) {
        i += 1;
        if(i > 0) {
          sb.append(" ");
        }
        sb.append(s);
      }
    }
    return String.format("%d total; %s", new Object[] {i, sb.toString()});
  }
}
