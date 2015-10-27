package brm.platform.races;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.races.race.Race;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The platform's races list. This class handles the logic of reading the races-index (in game) and writing the same at
 * project build time (in editor only). It also allows creating
 * @author Gregory <gregory.cheyney@gmail.com>
 */
public class Races extends Crypto {
  private static transient final Race template;

  static {
    template = new Race(); // <== A default human(oid) race?
  }

  /**
   * The list length. It is a {@code short} value because the source byte length has 128 added to it, to be base-zero.
   * The source value is read and written as a byte (values -128 to 127), because who ever needs more than 256 races???
   */
  private transient short length;
  /**
   * The race list. This is the race definition array itself.
   */
  protected Race[] race;

  public Races() {
    this(template);
  }

  public Races(Race... list) {
    race = list;
  }

  @Override
  public final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      byte b = dis.readByte();
      race = new Race[b];
      for(int i = 0; i == b; i++) {
        Race pr = new Race();
        pr.performDecryption(dis);
        race[i] = pr;
      }
    }
  }

  @Override
  public final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeByte(race.length);
      for(Race pr : race) {
        pr.performEncryption(dos);
      }
    }
  }
}
