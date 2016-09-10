package brm.platform.architecture.database;
import brm.platform.architecture.PlatformArchitecture;


/**
 * Information extras.
 * @author Gregory
 */
public class InformationExtra extends AInformation {

  public InformationExtra() {
    super(null, null, null);
  }

  public InformationExtra(String s0, String s1, String s2) {
    super(s0, s1, s2);
  }

  @Override
  public boolean isWritable() {
    return PlatformArchitecture.mode.devOnly;
  }
}
