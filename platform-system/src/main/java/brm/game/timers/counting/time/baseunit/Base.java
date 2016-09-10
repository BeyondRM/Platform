package brm.game.timers.counting.time.baseunit;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The base time definitions.
 * @author Gregory
 * @see #instance instance
 * @see #Bases() Base()
 */
public class Base extends Crypto {
  /**
   * The default instance.
   * @see Base
   */
  public static final Base instance;

  static {
    instance = new Base();
  }

  // the bases: weekdays, months, seasons, years,
  /**
   * The year.
   * @see Base
   */
  private TimeYear year;
  /**
   * The seasons.
   * @see Base
   */
  private TimeSeason[] seasons;
  /**
   * The months.
   * @see Base
   */
  private TimeMonth[] months;
  /**
   * The weekdays.
   * @see Base
   */
  private TimeWeekday[] weekdays;
  /**
   * The day time-parts.
   * @see Base
   */
  private TimeDay day;

  /**
   * A private constructor. Goes nowhere, does nothing.
   * @see Base
   */
  private Base() {
  }

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {

    }
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
    }
  }

  /**
   * Get a day.
   * @return A {@link TimeDay} object.
   * @see Base
   * @see Time
   */
  public final TimeDay getDay() {
    return day;
  }

  /**
   * Get a month.
   * @param b A {@link Byte} value, representing the array index to find.
   * @return A {@link TimeMonth} object.
   * @see Base
   * @see Time
   */
  public final TimeMonth getMonth(byte b) {
    return months[b];
  }

  /**
   * Get the months.
   * @return A {@link TimeMonth} array.
   * @see Base
   * @see Time
   */
  public final TimeMonth[] getMonths() {
    return months.clone();
  }

  /**
   * Get a season.
   * @param b A {@link Byte} value, representing the array index to find.
   * @return A {@link TimeSeason} object.
   * @see Base
   * @see Time
   */
  public final TimeSeason getSeason(byte b) {
    return seasons[b];
  }

  /**
   * Get the seasons.
   * @return A {@link TimeSeason} array.
   * @see Base
   * @see Time
   */
  public final TimeSeason[] getSeasons() {
    return seasons.clone();
  }

  /**
   * Get a weekday.
   * @param b A {@link Byte} value, representing the array index to find.
   * @return A {@link TimeWeekday} object.
   * @see Base
   * @see Time
   */
  public final TimeWeekday getWeekday(byte b) {
    return weekdays[b];
  }

  /**
   * Get the weekdays.
   * @return A {@link TimeYear} array.
   * @see Base
   * @see Time
   */
  public final TimeWeekday[] getWeekdays() {
    return weekdays.clone();
  }

  /**
   * Get the year definition.
   * @return A {@link TimeYear} object.
   * @see Base
   * @see Time
   */
  public final TimeYear getYear() {
    return year;
  }
}
