package brm.platform.window;
import abc.cryptology.logics.ACryptoLogic;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Logic for loading window and control definitions.
 * @author Gregory
 */
public class WindowControlsLogic extends ACryptoLogic {
  //TODO: Define the fields for various aspects of the windowing and component system....
  public String cipher;
  public String versions;
  public long seedCore;
  public long seedSkinning;
  public long seedFontDefs;
  public long seed3;

  public WindowControlsLogic(long l, String s) {
    seedCore = l;
    cipher = s;
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    // iteratively read the metadata of the various window-skins, graphic fonts, and components
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      // only the developer modes should be able to encrypt the data.
    }
  }
}
