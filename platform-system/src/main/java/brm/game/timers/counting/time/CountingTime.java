package brm.game.timers.counting.time;
import brm.game.timers.counting.Counting;
import brm.game.timers.enums.TimeMode;


/**
 * A counter for timing.
 * @author Gregory
 */
abstract public class CountingTime extends Counting {

  public CountingTime() {
    super(TimeMode.COUNT_INFINITE);
  }

  @Override
  public void update() {
  }
}
