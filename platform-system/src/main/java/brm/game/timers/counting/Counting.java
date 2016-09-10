package brm.game.timers.counting;
import brm.game.timers.GameTimers;
import brm.game.timers.counting.time.baseunit.Base;
import brm.game.timers.enums.TimeMode;


/**
 * A counter abstraction. This abstract class is the baseline for instantiating counters of various sorts: a game clock
 * which keeps track of game-time; counters which count up or down (either infinitely, or to a target value); "looping"
 * counters, which upon achieving a target value will reset the value and continue; and various other countable times.
 * @author Gregory
 */
abstract public class Counting {
  /**
   * All the bases. This is a reference to ALL default definitions of the day, week, month, season, and year values for
   * the game.
   * @see TimeCalendar
   */
  protected static final Base bases = Base.instance;

  /**
   * The timers.
   * @see Counting
   */
  protected final GameTimers timers;
  /**
   * The timer mode.
   * @see Counting
   */
  protected final TimeMode mode;
  /**
   * Whether done.
   * @see Counting
   */
  protected boolean done;
  /**
   * Whether paused.
   * @see Counting
   */
  protected boolean paused;

  /**
   * A public constructor.
   * @param tm A {@link TimeMode} instance, representing how the counter is used.
   * @see Counting
   */
  public Counting(TimeMode tm) {
    mode = tm;

    timers = GameTimers.instance;
    done = false;
    paused = false;
  }

  /**
   * Whether done. If the counter is considered "done" (i.e., the target value has been reached), AND the mode is not a
   * looping object, then this returns true.
   * @return A {@link Boolean} condition.
   * @see Counting
   */
  abstract public boolean isDone();

  /**
   * Whether paused. If the counter is paused, the value should not update.
   * @return A {@link Boolean} condition.
   * @see Counting
   */
  abstract public boolean isPaused();

  /**
   * Set paused. This takes a boolean value to specify whether the counter will set itself paused or not-paused.
   * @param b A {@link Boolean} condition, representing whether to pause the counter.
   * @see Counting
   */
  abstract public void setPaused(boolean b);

  /**
   * Update it. This performs the per-tick update methodology for this counting object. In most cases, the body of this
   * method will be wrapped in an "if" statement that tests whether it is currently paused and perhaps some methodology
   * to set itself un-paused as necessary. Something like this:
   * <pre>
   *   if(paused) {
   *     // determine if should be unpaused?
   *   } else {
   *     // process the un-paused state?
   *   }
   * </pre>
   * @see Counting
   */
  abstract public void update();
}
