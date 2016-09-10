package brm.game.timers.counting.time.baseunit;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A weekday definition. This allows defining the name of a weekday, whether it is considered a "weekend" day,
 * @author Gregory
 */
public class TimeWeekday extends Time {
  private boolean weekend;
  private boolean workday;

  @Override
  public final String getTitle() {
    return title;
  }

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      title = dis.readUTF();
      weekend = dis.readBoolean();
      workday = dis.readBoolean();
    }
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeUTF(title);
      dos.writeBoolean(weekend);
      dos.writeBoolean(workday);
    }
  }

  public final boolean isWeekend() {
    return weekend;
  }

  public final boolean isWorkday() {
    return workday;
  }
}
