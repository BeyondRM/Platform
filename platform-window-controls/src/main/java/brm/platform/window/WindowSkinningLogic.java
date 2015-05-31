package brm.platform.window;
import abc.cryptology.logics.ACryptoLogic;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Window Skinning Logic.
 * @author Gregory
 */
public class WindowSkinningLogic extends ACryptoLogic {
  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
    }
  }
}
