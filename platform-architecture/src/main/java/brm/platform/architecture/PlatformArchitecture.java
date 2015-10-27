package brm.platform.architecture;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.enumtype.OperatorMode;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Platform Architecture. This singleton class provides an entry point for the entire platform and its modules.
 * @author Gregory
 * @see #instance instance
 * @see #mode mode
 */
public class PlatformArchitecture extends Crypto {
  /**
   * The default {@link PlatformArchitecture} instance.
   */
  public static final PlatformArchitecture instance;
  // static, non-final fields:
  public static OperatorMode mode;
  public static boolean dbInfoExtra;

  static {
    instance = new PlatformArchitecture();
    mode = OperatorMode.editorDataOnly;
    dbInfoExtra = false;
  }

  private PlatformArchitecture() {
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    PlatformArchitecture.mode = OperatorMode.engineGamePlay;
    PlatformArchitecture.dbInfoExtra = dis.readBoolean();
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
  }
}
