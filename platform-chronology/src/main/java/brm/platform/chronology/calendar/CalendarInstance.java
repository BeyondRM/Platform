package brm.platform.chronology.calendar;


/**
 * <h2>CalendarInstance</h2>
 * The calendar instance. This class handles the current values of year, month, week, and day.
 * @author Gregory
 */
public class CalendarInstance {
  protected int year;
  protected int month;
  protected int week;
  protected int day;
  protected int weekday;

  public CalendarInstance(int i, int j, int k, int l, int m) {
    year = i;
    month = j;
    week = k;
    day = l;
    weekday = m;
  }
}
