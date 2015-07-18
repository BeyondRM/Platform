package brm.platform.architecture.database;
import abc.cryptology.logics.ACryptoLogic;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Database object information. This class has fields and methods for managing a specific database object's information
 * (including name, notes, and miscellaneous descriptor fields).
 * @author Gregory
 */
abstract public class AInformation extends ACryptoLogic {
  /**
   * The object name.
   * @see AInformation
   */
  protected String infoName;
  /**
   * The object note.
   * @see AInformation
   */
  protected String infoNote;
  /**
   * The object text-description.
   * @see AInformation
   */
  protected String infoText;

  /**
   * A public constructor. This instantiates the string fields: name, note, and descriptive text.
   * @param s0 A {@link String} object, representing the {@link #infoName infoName} value.
   * @param s1 A {@link String} object, representing the {@link #infoNote infoNote} value.
   * @param s2 A {@link String} object, representing the {@link #infoText infoText} value.
   */
  public AInformation(String s0, String s1, String s2) {
    infoName = s0;
    infoNote = s1;
    infoText = s2;
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
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
