package brm.platform.architecture;
import brm.platform.architecture.enumtype.OperatorMode;


/**
 * Platform Architecture. This singleton class provides an entry point for the entire platform and its modules.
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
