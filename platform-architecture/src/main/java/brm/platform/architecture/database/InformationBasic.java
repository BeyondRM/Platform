package brm.platform.architecture.database;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.IOException;


/**
 * Information basics.
 * @author Gregory
 */
public class InformationBasic extends AInformation {
  public InformationBasic() {
    super(null, null, null);
  }

  public InformationBasic(DataInputStream dis) throws IOException {
    super(dis);
  }

  public InformationBasic(String s0, String s1, String s2) {
    super(s0, s1, s2);
  }

  @Override
  public boolean isWritable() {
    return PlatformArchitecture.mode.devOnly;
  }
}
