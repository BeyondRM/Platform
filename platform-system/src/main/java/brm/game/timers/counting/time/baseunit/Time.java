package brm.game.timers.counting.time.baseunit;
import abc.cryptology.logics.Crypto;


/**
 * A base time unit.
 * @author Gregory
 */
abstract class Time extends Crypto {
  protected static final Base bases;

  static {
    bases = Base.instance;
  }

  protected String title;

  protected Time() {
    this("unknown");
  }

  protected Time(String s) {
    title = s;
  }

  abstract public String getTitle();
}
