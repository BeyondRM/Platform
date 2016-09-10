package brm.game.timers.counting.time;
import brm.game.timers.counting.Counting;
import brm.game.timers.enums.TimeMode;


/**
 * A "Game Time" counter. This is a core-level counter, which functions to control the in-game time, calculated from an
 * incrementing set of values, and constraining each value to a maximum.
 * @author Gregory
 */
public class TimeCalendar extends Counting {
  /**
   * The game clock;
   * @see TimeCalendar
   */
  private TimeElapsingClock clock;
  /**
   * The tick increment.
   * @see TimeCalendar
   */
  private byte increments;
  // the current values: day, weekday, month, year,
  /**
   * The current day in the week.
   * @see TimeCalendar
   */
  private byte currDyInWk;
  /**
   * The current day in the month.
   * @see TimeCalendar
   */
  private byte currDyInMo;
  /**
   * The current day in the season.
   * @see TimeCalendar
   */
  private byte currDyInSn;
  /**
   * The current day in the year.
   * @see TimeCalendar
   */
  private short currDyInYr;
  /**
   * The current month in the year.
   * @see TimeCalendar
   */
  private byte currMoInYr;
  /**
   * The current season.
   * @see TimeCalendar
   */
  private byte currSeason;
  /**
   * @see TimeCalendar
   */
  private byte currYrInGm;

  /**
   * @see TimeCalendar
   */
  public TimeCalendar() {
    super(TimeMode.COUNT_INFINITE);
  }

  @Override
  public final boolean isDone() {
    return false; // the calendar and clock are NEVER done, so long as a game is still being played...
  }

  @Override
  public final boolean isPaused() {
    return paused;
  }

  @Override
  public final void setPaused(boolean b) {
    paused = b;
  }

  @Override
  public final void update() {
    clock.update(increments);
    // Increment days if we can do so:
    while(clock.isNewDay()) {
      // Increment day in week:
      currDyInWk = (byte)(currDyInWk++ % bases.getWeekdays().length);
      // Increment day in month:
      currDyInMo++;
      while(currDyInMo > bases.getMonth(currMoInYr).getDays()) {
        currDyInMo -= bases.getMonth(currMoInYr).getDays();
        currMoInYr++;
      }
      // Increment day in season:
      currDyInSn++;
      while(currDyInSn > bases.getSeason(currSeason).getDays()) {
        currDyInSn -= bases.getSeason(currSeason).getDays();
        currSeason++;
        // do we also need to post-update check whether the season is still in range?
      }
      // Increment day in year:
      currDyInYr++;
      while(currDyInYr > bases.getYear().getDays()) {
        currDyInYr -= bases.getYear().getDays();
        currYrInGm++;
      }
      // Decrement day from clock instance:
      clock.currentDiem--;
    }
  }

  /**
   * Set the tick increment. This controls how fast the game will progress through the game-time. Larger values mean an
   * increased time-lapse; lower values mean a slower time-lapse, which takes more "real time" to play "game time".
   * @see TimeCalendar
   */
  public final void setIncrements(byte b) {
    increments = b;
  }

  /**
   * Get the current year. This is the in-game year as is accumulated by a game's beginning date, plus all elapsed time
   * up to this point.
   * @see TimeCalendar
   */
  public final byte getCurrYrInGm() {
    return currYrInGm;
  }
}
