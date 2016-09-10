package brm.platform.architecture.logger;
import java.util.logging.Logger;


/**
 * PlatformArchitecture's logging handler. This interface is useful for providing the logger instance, and a few String
 * formatting fields for various information messages which may be logged. For ease of use, all the classes that use it
 * should perhaps statically-import the logger field.
 * @author Gregory
 * @see #logger logger
 * @see #message_throw_IOException message_throw_IOException
 */
public interface ArchitectureLogger {
  /**
   * The logger object. This is a logging instance which is obtained from calling
   * <pre>  Logger.getLogger("BeyondRM-PlatformArchitecture");</pre>
   * and is meant to be publicly-accessible, so that anything within the BeyondRM™ Platform Architecture should be able
   * to write logged data to it.
   * @see ArchitectureLogger
   * @see Logger
   * @see Logger#getLogger(String)
   */
  Logger logger = Logger.getLogger("BeyondRM-PlatformArchitecture");
  /**
   * A message format. The constructor has initialized fields to null or default values, nothing more needs to be done.
   * This is a standalone logging entry, to be placed before a logged "exiting" entry.
   * @see ArchitectureLogger
   * @see String
   */
  String message_class_ctor_default = "Class constructor has initialized fields to null or default values.";
  /**
   * A message format for IOExceptions. This field is used to show basic information on the class and method throwing a
   * basic IOException; the two parameters which must be supplied are the class-name and method-name, in precise order.
   * @see ArchitectureLogger
   * @see String
   */
  String message_throw_IOException = "Class %s method %s has thrown an IOException; please look into this.";
}
