package brm.platform.chronology.defaults;


/**
 * <h2>LimitsCalendar</h2>
 * The calendar limits. This provides the static defaults for all aspects of a calendar system, for day lengths greater
 * than a day.
 * <p/>
 * A new game will start with the calendar beginning year, month, week, day, and weekday values; it can continue to run
 * normally, until the game time advances, to be greater than or equal to the ending year, month, and day values. Also,
 * game advancement uses the limits for months-per-year, weeks-per-year, day-per-week, and days-per-year
 * @author Gregory
 * @see #beginYear beginYear
 * @see #beginMonth beginMonth
 * @see #beginWeek beginWeek
 * @see #beginDay beginDay
 * @see #beginWeekday beginWeekday
 * @see #finalYear finalYear
 * @see #finalMonth finalMonth
 * @see #finalDay finalDay
 * @see #limitMonthPerYear limitMonthPerYear
 * @see #limitWeekPerYear limitWeekPerYear
 * @see #limitDayPerWeek limitDayPerWeek
 * @see #limitDayPerYear limitDayPerYear
 */
public class LimitsCalendar {
  public final String[] nameMonth;
  public final String[] nameWeekday;
  /**
   * The beginning year.
   * @see LimitsCalendar
   */
  public final int beginYear;
  /**
   * The beginning month.
   * @see LimitsCalendar
   */
  public final int beginMonth;
  /**
   * The beginning week.
   * @see LimitsCalendar
   */
  public final int beginWeek;
  /**
   * The beginning day.
   * @see LimitsCalendar
   */
  public final int beginDay;
  /**
   * The beginning weekday.
   * @see LimitsCalendar
   */
  public final int beginWeekday;
  /**
   * The final year.
   * @see LimitsCalendar
   */
  public final int finalYear;
  /**
   * The final month.
   * @see LimitsCalendar
   */
  public final int finalMonth;
  /**
   * The final day.
   * @see LimitsCalendar
   */
  public final int finalDay;
  /**
   * The limit month-per-year.
   * @see LimitsCalendar
   */
  public final int limitMonthPerYear;
  /**
   * The limit week-per-year.
   * @see LimitsCalendar
   */
  public final int limitWeekPerYear;
  /**
   * The limit day-per-week.
   * @see LimitsCalendar
   */
  public final int limitDayPerWeek;
  /**
   * The limit day-per-year.
   * @see LimitsCalendar
   */
  public final int limitDayPerYear;

  /**
   * A protected constructor. This is visible only to this package, so that our {@link Defaults} class has a reference
   * field to share access. Sets the begin, final, and limit to year, month, week, day, weekday, and more values.
   * @param b0 A {@link Byte} array, representing the begin .
   * @param b1 A {@link Byte} array, representing the final .
   * @param b2 A {@link Byte} array, representing the limit to above fields.
   * @see LimitsCalendar
   */
  protected LimitsCalendar(byte[] b0, byte[] b1, byte[] b2) {
    // the 'begin' values:
    beginYear = 0;
    beginMonth = 0;
    beginWeek = 0;
    beginDay = 0;
    beginWeekday = 0;
    // the 'final' values:
    finalYear = 0;
    finalMonth = 0;
    finalDay = 0;
    // the 'limit' values:
    limitMonthPerYear = 0;
    limitWeekPerYear = 0;
    limitDayPerWeek = 0;
    limitDayPerYear = 0;
    // the names of months and weekdays:
    nameMonth = null;
    nameWeekday = null;
  }
}
