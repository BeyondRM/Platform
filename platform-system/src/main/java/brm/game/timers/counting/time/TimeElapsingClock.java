package brm.game.timers.counting.time;
import brm.game.timers.counting.time.baseunit.Base;

/**
 * <h2>TimeElapsingClock</h2>
 * something
 * @author Gregory
 */
public class TimeElapsingClock {
  private static final String CLOCK_AMPM;
  private static final String CLOCK_FULL;

  static {
    CLOCK_AMPM = "";
    CLOCK_FULL = "";
  }

  private volatile byte temp;
  protected byte currentDiem;
  protected byte currentHour;
  protected byte currentMinute;
  protected byte currentSecond;

  public TimeElapsingClock() {
  }

  public final String asTime(boolean b) {
    return b
        ? ""
        : "";
  }

  public final boolean isNewDay() {
    return currentDiem > 0;
  }

  /**
   * Update the clock. This method is used to increment the various fields to keep appropriate relative game-time.
   * <p/>
   * First, increment the current second with the byte-based parameter value each tick. If the game FPS is 60 ticks per
   * second, and we add one second per update, then we blast through 60 seconds per "real-time" second. Now, the actual
   * <i>game time</i> might be different per each game; but, we also might want either faster or slower time increments
   * per game-tick, such as whether in the overworld map or in a town, or inside a building map.
   * <p/>
   * There is a bit of analysis as to how long a "day" or "year" in game should be, in terms of "real time". If we plug
   * Earth-equivalent values into our game calendar and clock system, then an in-game day will be 86,400 seconds of the
   * game ticks; which, if executing 60 ticks per real second, takes 1,440 real seconds, which equates to 24 minutes in
   * an in-game "day". This is the least we can do at one game-second per tick, but if we "speed up" the tick-increment
   * value for larger-scaled maps (such as the overworld map) we <i>could</i> speed through that game time, just moving
   * from a town map to the overworld; building-interiors should perhaps progress at a minimum value of one per update,
   * while towns could pass time two or three times normal, and on the overworld perhaps as fast as five or six times a
   * normal speed. What the individual game author chooses is their choice; but allowing scalable time progressions per
   * map lends to a richer, more satisfying variation of gaming experiences, for the end-user.
   * @param b
   */
  public final void update(byte b) {
    currentSecond += b;
    temp = Base.instance.getDay().getSecondsPerMinute();
    while(currentSecond >= temp) {
      currentSecond -= temp;
      currentMinute++;
    }
    temp = Base.instance.getDay().getMinutesPerHour();
    while(currentMinute >= temp) {
      currentMinute -= temp;
      currentHour++;
    }
    temp = Base.instance.getDay().getHoursPerDay();
    while(currentHour >= temp) {
      currentHour -= temp;
      currentDiem++;
    }
  }

  public synchronized final void modifyTime(short s) {
    // A method for the strange case if a game-time should "regress" or flow backward; this is the approximate total of
    // game-seconds that will be "subtracted" from the current time; this method should also balance the time to a real
    // set of values, so everything else should work as normal.
  }
}
