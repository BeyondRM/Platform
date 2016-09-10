package brm.game.timers;


/**
 * The game timers.
 * @author Gregory
 * @see #instance instance
 * @see #GameTimers() GameTimers()
 */
public class GameTimers {
  /**
   * The default instance.
   * @see GameTimers
   */
  public static final GameTimers instance;

  static {
    instance = new GameTimers();
  }

  private GameTimers() {
  }
}
