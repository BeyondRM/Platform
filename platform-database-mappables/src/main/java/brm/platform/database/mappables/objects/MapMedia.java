package brm.platform.database.mappables.objects;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The map media.
 * @author Gregory
 */
public class MapMedia extends Crypto {
  /**
   * The background music. This originally used RGSS class BGM; but should this be an integer index into the platform's
   * media lists?
   * @see MappableMedias
   */
  public Object bgm;
  /**
   * The background sound. This originally used RGSS class BGS; but should this be an integer index into the platform's
   * media lists?
   * @see MappableMedias
   */
  public Object bgs;
  /**
   * Whether BGM auto-plays. This shows whether or not a background music will automatically play for this map.
   * @see MappableMedias
   */
  public boolean autoplay_bgm;
  /**
   * Whether BGM auto-plays. This shows whether or not a background sound will automatically play for this map.
   * @see MappableMedias
   */
  public boolean autoplay_bgs;

  {
    autoplay_bgm = false;
    autoplay_bgs = false;
    bgm = null;
    bgs = null;
  }

  public MapMedia() {
  }

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly && dis != null) {
      autoplay_bgm = dis.readBoolean();
      autoplay_bgs = dis.readBoolean();
      // then, read the bgm and bgs properties...
    }
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly && dos != null) {
      dos.writeBoolean(autoplay_bgm);
      dos.writeBoolean(autoplay_bgs);
      // then, write the bgm and bgs properties...
    }
  }
}
