package brm.game.timers.enums;


/**
 * The timer modes. This defines whether the timer mode is one that counts down, up, or looping, as well as whether the
 * timer is "done" once it hits the target value.
 * @author Gregory
 */
public enum TimeMode {
  /**
   * Count infinitely. This is useful for such timers as the main game clock (for in-game timekeeping) or keeping track
   * of ticks elapsed in some methodology.
   * @see TimeMode
   */
  COUNT_INFINITE,
  /**
   * Decrement until done. This is a "countdown" timer, useful for keeping track of time remaining, until another event
   * will take place.
   * @see TimeMode
   */
  DECREMENT_DONE,
  /**
   * Decrement then loop. This is a decrementing counter which loops
   * @see TimeMode
   */
  DECREMENT_LOOP,
  /**
   * Increment until done.
   * @see TimeMode
   */
  INCREMENT_DONE,
  /**
   * Decrement then loop.
   * @see TimeMode
   */
  INCREMENT_LOOP,
  /**
   * Loop down then up.
   * @see TimeMode
   */
  LOOPED_DOWN_UP,
  /**
   * Loop up then down.
   * @see TimeMode
   */
  LOOPED_UP_DOWN,
  /**
   * Loop rebounded. This is perhaps unneeded, if LOOPED_DOWN_UP and LOOPED_UP_DOWN would otherwise take care of all of
   * the usages of this instance....
   * @see TimeMode
   */
  LOOPED_REBOUND;

  /**
   * @see TimeMode
   */
  private TimeMode() {
  }
}
