package brm.game.timers.counting.time.baseunit;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A month definition.
 * @author Gregory
 */
public class TimeMonth extends Time {
  private byte days;

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
}
