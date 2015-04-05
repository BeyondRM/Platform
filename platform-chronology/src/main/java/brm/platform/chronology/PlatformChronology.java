package brm.platform.chronology;
import brm.platform.chronology.calendar.CalendarDefinition;
import java.util.ArrayList;
import java.util.List;


/**
 * <h2>PlatformChronology</h2>
 * The singleton platform chronology instance. This static class is used to contain default chronological definitions a
 * game may depend upon. This allows setting the speed at which time passes in a game, such as while not paused from in
 * a menu state, a cutscene, or an event.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformChronology PlatformChronology
 */
public class PlatformChronology {
  /**
   * The default {@link PlatformChronology} instance.
   */
  public static final PlatformChronology instance;

  static {
    instance = new PlatformChronology();
  }

  private final List<String> timelock;
  private CalendarDefinition calendarDefinition;

  {
    timelock = new ArrayList<>(8);
  }

  private PlatformChronology() {
  }

  public void addTimelock(String s) {
    timelock.add(s);
  }

  public void delTimelock(String s) {
    timelock.remove(s);
  }

  public void setCalendarDefinition(String s) {
    //TODO: This should implement a setter methodology to set the calendarDefinition field. The object this is set to,
    // may likely come from a static method in the CalendarDefinition class.
  }

  public void update() {
    // Update the basic clock, if not timelocked...

    // Update the calendar, if the clock has rolled over past midnight...
  }
}
