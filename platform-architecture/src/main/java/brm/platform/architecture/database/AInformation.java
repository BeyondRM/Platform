package brm.platform.architecture.database;
import abc.cryptology.logics.ICryptoWriter;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static brm.platform.architecture.logger.ArchitectureLogger.logger;


/**
 * Database object information. This class has fields and methods for managing a specific database object's information
 * (including name, notes, and miscellaneous descriptor fields).
 * @author Gregory
 */
abstract public class AInformation implements ICryptoWriter {
  /**
   * The object name.
   * @see AInformation
   */
  protected final String infoName;
  /**
   * The object note.
   * @see AInformation
   */
  protected final String infoNote;
  /**
   * The object text-description.
   * @see AInformation
   */
  protected final String infoText;

  /**
   * A public constructor. This instantiates the string fields to default messages depicting that this is for a default
   * information body.
   * @see AInformation
   */
  public AInformation() {
    logger.entering(AInformation.class.getName(), "AInformation");
    logger.finer("  ... no parameters given; using default texts....");
    infoName = "Default Name";
    infoNote = "Default information note goes here.";
    infoText = "This is a default text body. If this had been a real information object, relevant text would be here.";
    logger.exiting(AInformation.class.getName(), "AInformation");
  }

  /**
   * A public constructor. This instantiates the string fields via reading from a data input stream.
   * @param dis A {@link DataInputStream} object, representing the input stream.
   * @throws java.io.IOException
   * @see AInformation
   */
  public AInformation(DataInputStream dis) throws IOException {
    logger.entering(AInformation.class.getName(), "AInformation", new Object[]{dis});
    if(PlatformArchitecture.mode.devOnly) {
      logger.finer("  ... setting empty text because not a game instance.");
      infoName = "";
      infoNote = "";
      infoText = "";
    } else {
      logger.finer("  ... reading the data input stream.");
      infoName = dis.readUTF();
      infoNote = dis.readUTF();
      infoText = dis.readUTF();
    }
    logger.exiting(AInformation.class.getName(), "AInformation");
  }

  /**
   * A public constructor. This instantiates the string fields: name, note, and descriptive text.
   * @param s0 A {@link String} object, representing the {@link #infoName infoName} value.
   * @param s1 A {@link String} object, representing the {@link #infoNote infoNote} value.
   * @param s2 A {@link String} object, representing the {@link #infoText infoText} value.
   * @see AInformation
   */
  public AInformation(String s0, String s1, String s2) {
    logger.entering(AInformation.class.getName(), "AInformation", new Object[]{s0, s1, s2});
    logger.finer("  ... reading given parameters.");
    infoName = s0;
    infoNote = s1;
    infoText = s2;
    logger.exiting(AInformation.class.getName(), "AInformation");
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeUTF(infoName);
      dos.writeUTF(infoNote);
      dos.writeUTF(infoText);
    }
  }

  /**
   * Get the name.
   * @return A {@link String} object.
   * @see AInformation
   */
  public String getInfoName() {
    return infoName;
  }

  /**
   * Get the note.
   * @return A {@link String} object.
   * @see AInformation
   */
  public String getInfoNote() {
    return infoNote;
  }

  /**
   * Get the text description.
   * @return A {@link String} object.
   * @see AInformation
   */
  public String getInfoText() {
    return infoText;
  }
}
