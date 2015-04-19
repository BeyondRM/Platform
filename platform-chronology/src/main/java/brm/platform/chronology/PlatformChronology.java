package brm.platform.chronology;
import abc.cryptology.AbcCryptology;
import brm.platform.architecture.loadable.AModuleLoading;
import brm.platform.architecture.loadable.progress.ProgressBar;
import brm.platform.chronology.calendar.CalendarDefinition;
import java.io.File;
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
public class PlatformChronology extends AModuleLoading {
  /**
   * The default {@link PlatformChronology} instance.
   */
  public static final PlatformChronology instance;

  static {
    instance = new PlatformChronology();
  }

  private final List<String> timelock;
  private CalendarDefinition calendarDefinition;

  protected int currentDateYear;
  protected int currentDateMonth;
  protected int currentDateDay;
  protected int currentDateWeekday;
  protected int currentTimeHour;
  protected int currentTimeMin;
  protected int currentTimeSec;

  {
    timelock = new ArrayList<>(8);
  }

  private PlatformChronology() {
  }

  @Override
  public boolean isDataLoaded() {
    return dataLoaded;
  }

  @Override
  public boolean isDataValidated() {
    return dataValidated;
  }

  @Override
  public int getInitializedCount() {
    return initializedCount;
  }

  @Override
  public void beforeInitialization(long l, File f, String s) {
    sourcePath = f;
  }

  @Override
  public void initializeBefore(ProgressBar pb) {
    if(!dataLoaded && !dataValidated && sourcePath != null && sourcePath.exists()) {
      AbcCryptology.instance.performDecryption(currentDateDay,
                                               new LogicChronologyDefaults(),
                                               null,
                                               sourcePath,
                                               null);
    }
  }

  @Override
  public void initializeDuring(ProgressBar pb) {
  }

  @Override
  public void initializeFinish(ProgressBar pb) {
  }

  @Override
  public void validation() {
  }

  public boolean isTimelock() {
    return !timelock.isEmpty();
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
