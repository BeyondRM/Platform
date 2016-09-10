package brm.platform.graphics.graphic.tileable;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A tileable graphic data.
 * @author Gregory
 */
public class TileData extends Crypto {
  /**
   * A tile name.
   * @see TileData
   */
  private String name;
  /**
   * A tile note.
   * @see TileData
   */
  private String note;
  /**
   * The X position.
   * @see TileData
   */
  private int posX;
  /**
   * The Y position.
   * @see TileData
   */
  private int posY;
  /**
   * The tile width.
   * @see TileData
   */
  private int wide;
  /**
   * The tile height.
   * @see TileData
   */
  private int high;

  /**
   * A public constructor. Tosses to the other constructor with zeroed or empty values.
   * @see TileData
   */
  public TileData() {
    this(0, 0, 0, 0, "", "");
  }

  /**
   * A public constructor.
   * @param x1 An {@link Integer} value, representing the {@link #posX posX}.
   * @param y1 An {@link Integer} value, representing the {@link #posY posY}.
   * @param x2 An {@link Integer} value, representing the {@link #wide wide}.
   * @param y2 An {@link Integer} value, representing the {@link #high high}.
   * @param s1 A {@link String} object, representing the {@link #name name}.
   * @param s2 A {@link String} object, representing the {@link #note note}.
   * @see TileData
   */
  public TileData(int x1, int y1, int x2, int y2, String s1, String s2) {
    posX = x1;
    posY = y1;
    wide = x2;
    high = y2;
    name = s1;
    note = s2;
  }

  @Override
  public synchronized final void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly) {
      posX = dis.readInt();
      posY = dis.readInt();
      wide = dis.readInt();
      high = dis.readInt();
      name = dis.readUTF();
      note = dis.readUTF();
    }
  }

  @Override
  public synchronized final void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      dos.writeInt(posX);
      dos.writeInt(posY);
      dos.writeInt(wide);
      dos.writeInt(high);
      dos.writeUTF(name);
      dos.writeUTF(note);
    }
  }

  /**
   * Get the name.
   * @return A {@link String} object.
   * @see TileData
   */
  public final String getName() {
    return name;
  }

  /**
   * Get the note.
   * @return A {@link String} object.
   * @see TileData
   */
  public final String getNote() {
    return note;
  }

  /**
   * Get the height.
   * @return An {@link Integer} value.
   * @see TileData
   */
  public final int getHigh() {
    return high;
  }

  /**
   * Get the X position.
   * @return An {@link Integer} value.
   * @see TileData
   */
  public final int getPosX() {
    return posX;
  }

  /**
   * Get the Y position.
   * @return An {@link Integer} value.
   * @see TileData
   */
  public final int getPosY() {
    return posY;
  }

  /**
   * Get the width.
   * @return An {@link Integer} value.
   * @see TileData
   */
  public final int getWide() {
    return wide;
  }

  /**
   * Set the height.
   * @param i An {@link Integer} value, representing
   * @see TileData
   */
  public final void setHigh(int i) {
    if(PlatformArchitecture.mode.devOnly) {
      high = i;
    }
  }

  /**
   * Set the name.
   * @param s A {@link String} object, representing
   * @see TileData
   */
  public final void setName(String s) {
    if(PlatformArchitecture.mode.devOnly) {
      name = s;
    }
  }

  /**
   * Set the note.
   * @param s A {@link String} object, representing
   * @see TileData
   */
  public final void setNote(String s) {
    if(PlatformArchitecture.mode.devOnly) {
      note = s;
    }
  }

  /**
   * Set the X position.
   * @param i An {@link Integer} value, representing
   * @see TileData
   */
  public final void setPosX(int i) {
    if(PlatformArchitecture.mode.devOnly) {
      posX = i;
    }
  }

  /**
   * Set the Y position.
   * @param i An {@link Integer} value, representing
   * @see TileData
   */
  public final void setPosY(int i) {
    if(PlatformArchitecture.mode.devOnly) {
      posY = i;
    }
  }

  /**
   * Set the width.
   * @param i An {@link Integer} value, representing
   * @see TileData
   */
  public final void setWide(int i) {
    if(PlatformArchitecture.mode.devOnly) {
      wide = i;
    }
  }
}
