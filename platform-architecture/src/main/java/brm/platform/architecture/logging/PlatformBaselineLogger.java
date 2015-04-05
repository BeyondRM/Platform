package brm.platform.architecture.logging;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * <h2>PlatformBaselineLogger</h2>
 * The platform baseline logger. This class contains static fields and methods for handling event-logging messages. Our
 * implementation is meant to allow for each user to specify in the game interface just how much will be logged.
 * <p/>
 * Note that we use static integer values as an analog to the logger's {@link Level} values; This merely provides some
 * simplification to shorten the method call.
 * @author Gregory
 * @see Level
 * @see Logger
 */
public class PlatformBaselineLogger {
  /**
   * A default logging level. This is set to {@link Level#INFO}, so that common information can be logged.
   * @see PlatformBaselineLogger
   * @see Level
   */
  private static final Level defaultLevel;
  /**
   * The active logger object. This is initialized as a logger object using the name "BeyondRM".
   * @see PlatformBaselineLogger
   */
  private static final Logger logger;
  /**
   * Logging level is 0. This is equivalent to {@link Level#OFF}, where nothing should be logged, all log events skip.
   * @see PlatformBaselineLogger
   */
  public static final int L0; // equal to Level.OFF
  /**
   * Logging level is 1. This is equivalent to {@link Level#SEVERE}, where only "show-stopper" events are logged, such
   * as for a game-crashing problem. (Hopefully, the event will be logged before the crash.)
   * @see PlatformBaselineLogger
   */
  public static final int L1; // equal to Level.SEVERE
  /**
   * Logging level is 2. This is equivalent to {@link Level#WARNING}, where any "warning" events will be logged, along
   * with {@link #L1 L1} events.
   * @see PlatformBaselineLogger
   */
  public static final int L2; // equal to Level.WARNING
  /**
   * Logging level is 3. This is equivalent to {@link Level#INFO}, where "informational" data and above will be logged
   * to the logger. The informational level is useful for common notes, such as when entering or exiting methods.
   * @see PlatformBaselineLogger
   */
  public static final int L3; // equal to Level.INFO
  /**
   * Logging level is 4. This is equivalent to {@link Level#FINE}, where slightly more detailed information is pushed.
   * It might include major operational parts inside of a larger method, especially where any number of "if ... else if
   * ... else" may change processing somewhat.
   * @see PlatformBaselineLogger
   */
  public static final int L4; // equal to Level.FINE
  /**
   * Logging level is 5. This is equivalent to {@link Level#FINER}, where even finer-grained information than above is
   * passed into the logging method. This is useful for when testing and debugging new classes and methodologies before
   * inclusion into the repository module.
   * @see PlatformBaselineLogger
   */
  public static final int L5; // equal to Level.FINER
  /**
   * Logging level is 6. This is equivalent to {@link Level#FINEST}, where the finest-grained informational data shall
   * be logged. We use this primarily within methods that we might want to be actively debugging and testing, such as
   * when we are diagnosing a problem in the code.
   * @see PlatformBaselineLogger
   */
  public static final int L6; // equal to Level.FINEST
  /**
   * Logging level is 7. This is equivalent to {@link Level#CONFIG}, where intricate output of field values and states
   * of operation is being performed.
   * @see PlatformBaselineLogger
   */
  public static final int L7; // equal to Level.CONFIG
  /**
   * Logging level is 8. This is equivalent to {@link Level#ALL}, where everything that can be logged, will be logged.
   * The actual log-files can grow quite large; care must be taken in paring down the log files or else the user's disk
   * may be filled with generated logging information after some time.
   * @see PlatformBaselineLogger
   */
  public static final int L8; // equal to Level.ALL

  static {
    defaultLevel = Level.INFO;
    logger = Logger.getLogger("BeyondRM");
    logger.setLevel(Level.ALL);
    L0 = Level.OFF.intValue();
    L1 = Level.SEVERE.intValue();
    L2 = Level.WARNING.intValue();
    L3 = Level.INFO.intValue();
    L4 = Level.FINE.intValue();
    L5 = Level.FINER.intValue();
    L6 = Level.FINEST.intValue();
    L7 = Level.CONFIG.intValue();
    L8 = Level.ALL.intValue();
  }

  /**
   * A private constructor. Goes nowhere, does nothing...
   * @see PlatformBaselineLogger
   */
  private PlatformBaselineLogger() {
  }

  @Override
  public final String toString() {
    return getClass().getName();
  }

  /**
   * Get the logger level.
   * @return A {@link Level} instance.
   * @see PlatformBaselineLogger
   */
  public static final Level getLevel() {
    return logger.getLevel();
  }

  /**
   * Get the logger level. This method takes an integer value, presumably from one of the convenience fields herein, to
   * compare to known {@code Level} values. If nothing else matches, we return our {@link #defaultLevel defaultLevel}.
   * @param i An {@link Integer} value, representing the comparable logging level.
   * @return A {@link Level} instance.
   * @see PlatformBaselineLogger
   */
  public static final Level getLevel(int i) {
    if(i == Level.OFF.intValue()) {
      return Level.OFF;
    } else if(i >= Level.SEVERE.intValue()) {
      return Level.SEVERE;
    } else if(i >= Level.WARNING.intValue()) {
      return Level.WARNING;
    } else if(i >= Level.INFO.intValue()) {
      return Level.INFO;
    } else if(i >= Level.FINE.intValue()) {
      return Level.FINE;
    } else if(i >= Level.FINER.intValue()) {
      return Level.FINER;
    } else if(i >= Level.FINEST.intValue()) {
      return Level.FINEST;
    } else if(i >= Level.CONFIG.intValue()) {
      return Level.CONFIG;
    } else if(i >= Level.ALL.intValue()) {
      return Level.ALL;
    } else {
      return defaultLevel;
    }
  }

  /**
   * Get the logger. This remains as a convenience method, to obtain the current logger instance; we should use the new
   * static logging methods, also contained herein.
   * @return A {@link Logger} instance.
   * @see PlatformBaselineLogger
   */
  public static final Logger getLogger() {
    return logger;
  }

  /**
   * Log the message. This first tests if we can log (whether the logger's level is off, whether the integer value will
   * infer it is off, and whether the string is null or empty) before we actually pass the parameters to the logger.
   * @param i An {@link Integer} value, representing the proposed logging level.
   * @param s A {@link String} object, representing the text to log.
   * @see PlatformBaselineLogger
   */
  public static final void logThis(int i, String s) {
    if(logger.getLevel() != Level.OFF && i != L0 && s != null && !s.isEmpty()) {
      logger.log(Level.INFO, s);
    }
  }

  /**
   * Log the message. This first tests if we can log (whether the logger's level is off, whether the integer value will
   * infer it is off, and whether the string is null or empty) before we actually pass the parameters to the logger.
   * @param i An {@link Integer} value, representing the proposed logging level.
   * @param s A {@link String} object, representing the text to log.
   * @param t A {@link Throwable} object, representing a thrown error.
   * @see PlatformBaselineLogger
   */
  public static final void logThis(int i, String s, Throwable t) {
    if(logger.getLevel() != Level.OFF && i != L0 && s != null && !s.isEmpty()) {
      logger.log(Level.INFO, s, t);
    }
  }

  /**
   * Set the logger level. The expected logging values by default are:
   * <pre>
   *     LEVEL    VALUE
   *     =====    =====
   *     ALL      Integer.MIN_VALUE
   *     CONFIG   100
   *     FINEST   300
   *     FINER    400
   *     FINE     500
   *     INFO     800
   *     WARNING  900
   *     SEVERE   1000
   *     OFF      Integer.MAX_VALUE
   * </pre>
   * <p/>
   * From this, we can infer as the native logger examines whether the level's integer value being logged is greater or
   * equal to the logger's active level; if true, the event can be logged, and if false, the logging event is skipped.
   * @param l A {@link Level} instance.
   * @see PlatformBaselineLogger
   */
  public static final void setLevel(Level l) {
    logger.setLevel(l);
  }
}
