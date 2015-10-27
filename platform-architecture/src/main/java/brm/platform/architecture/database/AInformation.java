package brm.platform.architecture.database;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * Database object information. This class has fields and methods for managing a specific database object's information
 * (including name, notes, and miscellaneous descriptor fields).
 * @author Gregory
 */
abstract public class AInformation extends Crypto {
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
    if(!PlatformArchitecture.mode.devOnly) {
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
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

  /**
   * Set the item name. This is the default name for an item of this specification, without embellishment.
   * @see AInformation
   */
  public void setInfoName(String s) {
    if(PlatformArchitecture.mode.devOnly) {
      infoName = s;
    }
  }

  /**
   * Set the item note. This is the default note for an item of this specification, generally a sentence or two.
   * @see AInformation
   */
  public void setInfoNote(String s) {
    if(PlatformArchitecture.mode.devOnly) {
      infoNote = s;
    }
  }

  /**
   * Set the item text. This is the default informational text, up to a small paragraph of description.
   * @see AInformation
   */
  public void setInfoText(String s) {
    if(PlatformArchitecture.mode.devOnly) {
      infoText = s;
    }
  }
}
