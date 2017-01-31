package brm.platform.database.chronology.gametime;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * <h2>Defaults</h2>
 * Chronology defaults. This is for providing the beginning and ending values for both the calendar and the clock, then
 * the limits for days, weeks, and months of a year, and the hours, minutes, and seconds in a day.
 * @author Gregory
 * @see #instance instance
 * @see #file file
 * @see #calendar calendar
 */
public class Defaults {
  /**
   * The default instance.
   */
  public static final Defaults instance;

  static {
    instance = new Defaults();
  }

  private File file;
  private LimitsCalendar calendar;

  private Defaults() {
  }

  public final LimitsCalendar getCalendar() {
    return calendar;
  }

  public final boolean isFinishDateTime() {
    // This method examines passed in parameters to see whether the current date and time is after the finish date and
    // time for the current game instance. This method is called once per game tick, and should only ever return true
    // if all current date values and all current time values would be greater than the default ending time.
    return false;
  }

  public final void initialize(File f) {
    file = f;
    // if 'file' is a valid compressed volume thaat contains our binary calendar and clock values, get the subfiles....

    try(FileReader fr = new FileReader(file);) {
    } catch(FileNotFoundException ex) {
      Logger.getLogger(Defaults.class.getName()).log(Level.SEVERE, null, ex);
    } catch(IOException ex) {
      Logger.getLogger(Defaults.class.getName()).log(Level.SEVERE, null, ex);
    }
  }
}
