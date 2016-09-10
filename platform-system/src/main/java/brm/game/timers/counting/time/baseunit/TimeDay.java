package brm.game.timers.counting.time.baseunit;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A day definition.
 * @author Gregory
 */
public class TimeDay extends Crypto {
  private byte hoursPerDay;
  private byte minutesPerHour;
  private byte secondsPerMinute;

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      hoursPerDay = dis.readByte();
      minutesPerHour = dis.readByte();
      secondsPerMinute = dis.readByte();
    }
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeByte(hoursPerDay);
      dos.writeByte(minutesPerHour);
      dos.writeByte(secondsPerMinute);
    }
  }

  public final byte getHoursPerDay() {
    return hoursPerDay;
  }

  public final byte getMinutesPerHour() {
    return minutesPerHour;
  }

  public final byte getSecondsPerMinute() {
    return secondsPerMinute;
  }
}
