package brm.platform.architecture;
import brm.platform.architecture.enumtype.OperatorMode;


/**
 * <h2>PlatformArchitecture</h2>
 * @author Gregory
 * @see #instance instance
 * @see #mode mode
 */
public class PlatformArchitecture {
  /**
   * The default {@link PlatformArchitecture} instance.
   */
  public static final PlatformArchitecture instance;
  // static, non-final fields:
  public static OperatorMode mode;

  static {
    instance = new PlatformArchitecture();
    mode = OperatorMode.editorDataOnly;
  }

  private PlatformArchitecture() {
  }
}
