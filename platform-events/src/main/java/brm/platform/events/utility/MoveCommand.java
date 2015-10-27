package brm.platform.events.utility;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A movement command. This class contains fields and methods that control a single entry of an entity's movement in an
 * active map. It is used by the {@link MoveRoute} class in an array of orderly movement directions.
 * @author Gregory
 */
public class MoveCommand extends Crypto {
  /**
   * The movement command code.
   * @see MoveCommand
   */
  public int code;
  /**
   * The movement command parameters.
   * @see MoveCommand
   */
  public String[] parameters;

  /**
   * A public constructor. This constructor calls the other one, passing in the parameters code {@code 0} and a simple
   * string array of a single empty string object.
   * @see MoveCommand
   */
  public MoveCommand() {
    this(0, new String[1]);
  }

  /**
   * A public constructor. This constructor sets the movement command fields.
   * @param i An {@link Integer} value, representing the movement {@link #code code}.
   * @param s A {@link String} object, representing the movement {@link #parameters parameters}.
   * @see MoveCommand
   * @see #code code
   * @see #parameters parameters
   * @see Integer
   * @see String
   */
  public MoveCommand(int i, String[] s) {
    code = i;
    parameters = s;
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    code = dis.readInt();
    int i = dis.readInt();
    for(int j = i; j > 0; j--) {
      parameters[j] = dis.readUTF();
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeInt(code);
      dos.writeInt(parameters.length);
      for(String s : parameters) {
        dos.writeUTF(s);
      }
    }
  }
}
