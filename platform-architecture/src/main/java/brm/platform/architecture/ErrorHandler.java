package brm.platform.architecture;


/**
 * <h2>ErrorHandler</h2>
 * @author Gregory
 * @see #instance instance
 * @see #ErrorHandler ErrorHandler
 */
public class ErrorHandler {
  /**
   * The default {@link ErrorHandler} instance.
   */
  public static final ErrorHandler instance;

  static {
    instance = new ErrorHandler();
  }

  private ErrorHandler() {
  }
}
