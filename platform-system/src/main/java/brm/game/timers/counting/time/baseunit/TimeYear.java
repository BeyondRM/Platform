package brm.game.timers.counting.time.baseunit;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The year definition. This allows defining how many days in a normal year and the list of "special days" in the year.
 * Note that if we handle any "leap years", we may need more fields here; also, any leap-year days(s) are considered in
 * the list of special days.
 * @author Gregory
 */
public class TimeYear extends Time {
  private short days;
  private short[] specials;
  //TODO: If we handle "leap years", we may need more fields here...

  @Override
  public final String getTitle() {
    return title;
  }

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      title = dis.readUTF();
      days = dis.readShort();
      byte b = dis.readByte(); // Eh, *probably* not more than 127 "special days" per year....
      specials = (b > 0) ? new short[b] : null;
      if(specials != null) {
        for(short s : specials) {
          specials[s] = dis.readByte();
        }
      }
    }
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeUTF(title);
      dos.writeShort(days);
      if(specials == null) {
        dos.writeByte(0);
      } else {
        dos.writeByte(specials.length);
        for(short s : specials) {
          dos.writeShort(s);
        }
      }
    }
  }

  /**
   * Whether the day is "special".
   * @return A {@link Boolean} condition.
   * @deprecated This may be better for the engine-side handling of the days of the year....
   */
  @Deprecated
  public final boolean isDaySpecial(short s) {
    boolean b = specials != null;
    if(b) {
      for(short special : specials) {
        if(special == s) {
          return true;
        }
      }
    }
    return false;
  }

  public final short getDays() {
    return days;
  }
}
