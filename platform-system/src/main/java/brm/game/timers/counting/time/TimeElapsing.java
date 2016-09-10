package brm.game.timers.counting.time;
import brm.game.timers.counting.Counting;
import brm.game.timers.enums.TimeMode;


/**
 * Elapsing time.
 * @author Gregory
 */
public class TimeElapsing extends Counting {
  protected long cumulative;
  private int incrSecs;

  public TimeElapsing() {
    super(TimeMode.COUNT_INFINITE);
  }

  @Override
  public boolean isDone() {
    return false;
  }

  @Override
  public boolean isPaused() {
    return paused;
  }

  @Override
  public void setPaused(boolean b) {
  }

  @Override
  public void update() {
  }
}
