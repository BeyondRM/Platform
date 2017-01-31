package brm.platform.database.chronology.gametime;


/**
 * <h2>LimitsClock</h2>
 * @author Gregory
 */
public class LimitsClock {
  public final int beginHour;
  public final int beginMinute;
  public final int beginSecond;
  public final int finalHour;
  public final int finalMinute;
  public final int finalSecond;
  public final int limitHourPerDay;
  public final int limitMinutePerHour;
  public final int limitSecondPerMinute;

  /**
   * A protected constructor. This is visible only to this package, so that our {@link Defaults} class has a reference
   * field to share access. Sets the begin, final, and limit to hour, minute, and second values.
   * @param b0 A {@link Byte} array, representing the begin hour, minute, second.
   * @param b1 A {@link Byte} array, representing the final hour, minute, second.
   * @param b2 A {@link Byte} array, representing the limit to above fields.
   * @see LimitsClock
   */
  protected LimitsClock(byte[] b0, byte[] b1, byte[] b2) {
    // the 'begin' values:
    beginHour = 0;
    beginMinute = 0;
    beginSecond = 0;
    // the 'final' values:
    finalHour = 0;
    finalMinute = 0;
    finalSecond = 0;
    // the 'limit' values:
    limitHourPerDay = 0;
    limitMinutePerHour = 0;
    limitSecondPerMinute = 0;
  }
}
