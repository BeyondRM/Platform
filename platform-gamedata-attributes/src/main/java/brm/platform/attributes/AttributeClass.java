package brm.platform.attributes;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The attribute class. This class handles the logic of reading or writing attribute classes into the game engine.
 * @author Gregory
 */
public class AttributeClass extends Crypto {
  /**
   * The abbreviation.
   * @see AttributeClass
   */
  private String abbr;
  /**
   * The class name.
   * @see AttributeClass
   */
  private String name;

  /**
   * A protected constructor. This calls the other constructor with empty string parameters.
   * @see AttributeClass
   */
  protected AttributeClass() {
    this("", "");
  }

  /**
   * A protected constructor. This sets an initial class abbreviation and name, so the editor can write them.
   * @param s A {@link String} object, representing the {@link #abbr abbr}eviation.
   * @param t A {@link String} object, representing the {@link #name name}.
   * @see AttributeClass
   */
  protected AttributeClass(String s, String t) {
    abbr = s;
    name = t;
  }

  @Override
  public final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      abbr = dis.readUTF();
      name = dis.readUTF();
    }
  }

  @Override
  public final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeUTF(abbr);
      dos.writeUTF(name);
    }
  }

  /**
   * Set the abbreviation.
   * @param s A {@link String} object, representing the {@link #abbr abbr}eviation.
   * @see AttributeClass
   */
  protected final void setAbbr(String s) {
    abbr = s;
  }

  /**
   * Set the name.
   * @param s A {@link String} object, representing the {@link #name name}.
   * @see AttributeClass
   */
  protected final void setName(String s) {
    name = s;
  }

  /**
   * Get the abbreviation.
   * @return A {@link String} object.
   * @see AttributeClass
   */
  public final String getAbbr() {
    return abbr;
  }

  /**
   * Get the name.
   * @return A {@link String} object.
   * @see AttributeClass
   */
  public final String getName() {
    return name;
  }

  public final boolean valid() {
    return abbr != null && !abbr.isEmpty() && name != null && !name.isEmpty();
  }
}
