package brm.platform.database.mappables;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.maps.map.Mappable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Maps object. This class holds the arrays of actual mappable data.
 * @author Gregory
 */
public final class Maps extends Crypto {
  private final transient String s1; // crypto
  private final transient long l1;   // crypto seed
  /**
   * Mappable array.
   * @see Maps
   */
  private transient Mappable[] mappable;
  /**
   * Whether loaded.
   * @see Maps
   */
  private transient boolean loaded = false;

  /**
   * A constructor.
   * @param l the seed.
   * @param s the code.
   * @see Maps
   */
  Maps(long l, String s) {
    l1 = l;
    s1 = s;
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly && !loaded) {
      loaded = true;
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly && loaded) {
    }
  }

  public Mappable mappable(int i) {
    return null; // <--- for now... Fix it.
    //TODO: This should return a mappable instance.
    // But perhaps the `mappable` field should be an array of String objects, being the file reference to the map data.
    // This method should obtain the String at the given index, construct a File reference, and then actively load that
    // mappable data. Or, something.
  }

  String s1() {
    return s1;
  }

  long l1() {
    return l1;
  }
}
