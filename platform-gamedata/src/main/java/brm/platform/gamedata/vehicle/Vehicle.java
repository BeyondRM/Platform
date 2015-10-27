package brm.platform.gamedata.vehicle;
import abc.cryptology.logics.CryptoReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A vehicle data. This class contains the static vehicle data which defines things about a game vehicle which does not
 * change at all.
 * <h1>Vehicle Data.</h1>
 * A vehicle definition includes enough baseline information for a {@code Game_Vehicle} instance to work. Aside from a
 * typical name field, we have properties linking to the precise map location (usually some tile on the overworld), and
 * properties of the music and sounds that play while the vehicle moves.
 * <p/>
 * The map location includes the map number, the sub-map number, and the map X, Y, and Z coordinates; the last field in
 * this set is the layer within the map object.
 * <p/>
 * In the sounds department, this class object does not link to the actual music or sound effect but rather provide the
 * index into the musical lists for the background music and three sound effects. The background music is a generalized
 * "traveling music" that plays as the vehicle is moving. The sound effects are for the leaving (take-off), moving, and
 * landing (stopping) actions; only the moving operation is repeatable for the duration of the journey.
 * @author Gregory <gregory.cheyney@gmail.com>
 * @see CryptoReader
 * @see #i18n i18n
 * @see #name name
 * @see #mapW mapW
 * @see #mapZ mapZ
 * @see #id id
 * @see #mapI mapI
 * @see #mapX mapX
 * @see #mapY mapY
 * @see #mus1 mus1
 * @see #snd1 snd1
 * @see #snd2 snd2
 * @see #snd3 snd3
 * @see #Vehicle() Vehicle()
 * @see #Vehicle(DataInputStream) Vehicle(DataInputStream)
 * @see #Vehicle(String,short,short,byte,short,short,byte,short,short,short,short)
 * Vehicle(String,short,short,byte,short,short,byte,short,short,short,short)
 */
public class Vehicle extends CryptoReader {
  /**
   * The I18N key. This is used for obtaining the vehicle's name from a bundle of localized strings.
   * @see Vehicle
   */
  private final String i18n;
  /**
   * The vehicle name. This name is shown in the Editor infrastructure, as well as possibly can be shown in the running
   * Engine instance.
   * @see Vehicle
   */
  public final String name;
  /**
   * The map sub-map. This will be used to determine on which sub-map of a loaded map object this vehicle will be found
   * upon.
   * @see Vehicle
   */
  public final byte mapW;
  /**
   * The map Z layer. This defines which map layer the
   * @see Vehicle
   */
  public final byte mapZ;
  /**
   * The vehicle index. Is this needed? Perhaps this should function more as a "vehicle type" rather than as an ordinal
   * value; any external class which has obtained a reference to this object, does not need an index....
   * @see Vehicle
   */
  public final short id;
  /**
   * The starting map ID. This is the map that contains this vehicle by default in a new game. Of course, throughout an
   * active game, the player could move vehicles to other locations, but that isn't the function of this class: this is
   * only to setup the initial values and static defaults for a vehicle.
   * @see Vehicle
   */
  public final short mapI;
  /**
   * The starting map X. This is the initial map X location for this vehicle.
   * @see Vehicle
   */
  public final short mapX;
  /**
   * The starting map Y. This is the initial map Y location for this vehicle.
   * @see Vehicle
   */
  public final short mapY;
  /**
   * The vehicle music. This is the music which should play when the vehicle is embarked by the party. "traveling"
   * background
   * @see Vehicle
   */
  public final short mus1;
  /**
   * The leaving sound. This is the sound which should play when the vehicle is leaving from its location.
   * @see Vehicle
   */
  public final short snd1;
  /**
   * The working sound. This is the sound which should play when the vehicle is working, while the music is playing.
   * @see Vehicle
   */
  public final short snd2;
  /**
   * The landing sound. This is the sound which should play when the vehicle is landing into its location.
   * @see Vehicle
   */
  public final short snd3;

  /**
   * A public constructor. Takes no parameters, but sets default values for the field values.
   * @see Vehicle
   */
  protected Vehicle() {
    this("unnamed",
         (short)0, (short)0, (byte)0,
         (short)0, (short)0, (byte)0,
         (short)0, (short)0, (short)0, (short)0);
  }

  /**
   * A protected constructor. This instantiates a new {@code Vehicle} object, using the provided parameters.
   * @param s0 A {@link String} object, representing the {@link #i18n i18n}.
   * @param s1 A {@link Short} value, representing the {@link #id vehicle ID}.
   * @param s2 A {@link Short} value, representing the {@link #mapI map ID}.
   * @param b0 A {@link Byte} value, representing the {@link #mapW sub-map}.
   * @param s3 A {@link Short} value, representing the {@link #mapX map X}.
   * @param s4 A {@link Short} value, representing the {@link #mapY map Y}.
   * @param b1 A {@link Byte} value, representing the {@link #mapZ map Z}.
   * @param s5 A {@link Short} value, representing the {@link #mus1 music}.
   * @param s6 A {@link Short} value, representing the {@link #snd1 leaving} sound.
   * @param s7 A {@link Short} value, representing the {@link #snd1 working} sound.
   * @param s8 A {@link Short} value, representing the {@link #snd1 landing} sound.
   * @see Vehicle
   */
  protected Vehicle(String s0, short s1, short s2, byte b0, short s3, short s4, byte b1, short s5, short s6, short s7, short s8) {
    super(null);
    i18n = s0;
    name = String.format("Vehicle.%s.name", i18n);
    id = s1;
    mapI = s2;
    mapW = b0;
    mapX = s3;
    mapY = s4;
    mapZ = b1;
    mus1 = s5;
    snd1 = s6;
    snd2 = s7;
    snd3 = s8;
  }

  /**
   * A protected constructor. Takes a {@code DataInputStream} parameter to read in field values.
   * @param dis A {@link DataInputStream} object, representing a readable input stream.
   * @throws IOException
   * @see Vehicle
   */
  public Vehicle(DataInputStream dis) throws IOException {
    this(dis.readUTF(),
         dis.readShort(), dis.readShort(), dis.readByte(),
         dis.readShort(), dis.readShort(), dis.readByte(),
         dis.readShort(), dis.readShort(), dis.readShort(), dis.readShort());
  }

  @Override
  public synchronized final boolean isReadable() {
    return true;
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    dos.writeUTF(i18n);
    dos.writeShort(id);
    dos.writeShort(mapI);
    dos.writeByte(mapW);
    dos.writeShort(mapX);
    dos.writeShort(mapY);
    dos.writeByte(mapZ);
    dos.writeShort(mus1);
    dos.writeShort(snd1);
    dos.writeShort(snd2);
    dos.writeShort(snd3);
  }
}
