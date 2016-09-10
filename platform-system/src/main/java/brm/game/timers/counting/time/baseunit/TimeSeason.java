package brm.game.timers.counting.time.baseunit;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A season definition. This defines the properties of a subsection of a game year, which may span multiple months. The
 * season itself generally is defined by one or more weather patterns, such as snow in winter for colder climates, rain
 * through warmer climates or during the rest of the year, or even fantasy-inspired weather like "astral fire" or "star
 * dust".
 * @author Gregory
 */
public class TimeSeason extends Time {
  private byte days;
  private short dayBegin;

  @Override
  public final String getTitle() {
    return title;
  }

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      title = dis.readUTF();
      days = dis.readByte();
    }
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeUTF(title);
      dos.writeByte(days);
    }
  }

  public final byte getDays() {
    return days;
  }

  public final short getDayBegin() {
    return dayBegin;
  }
}
