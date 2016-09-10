package brm.game.timers.counting.time.baseunit;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A date+time instance. This class object may be used to contain a date (year, month, day) and time (hour, minute, and
 * second) for later comparison.
 * @author Gregory
 */
public class DateTime extends Crypto implements Comparable<DateTime> {
  /**
   * A year.
   * @see DateTime
   */
  protected short year;
  /**
   * A month.
   * @see DateTime
   */
  protected byte month;
  /**
   * A day.
   * @see DateTime
   */
  protected byte day;
  /**
   * An hour.
   * @see DateTime
   */
  protected byte hour;
  /**
   * A minute.
   * @see DateTime
   */
  protected byte minute;
  /**
   * A second.
   * @see DateTime
   */
  protected byte second;

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      // readable values:
    }
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      // writable values:
    }
  }

  @Override
  public int compareTo(DateTime dt) {
    return dt.year >= year
        && dt.month >= month
        && dt.day >= day
        && dt.hour >= hour
        && dt.minute >= minute
        && dt.second >= second
            ? 1
            : -1;
  }
}
