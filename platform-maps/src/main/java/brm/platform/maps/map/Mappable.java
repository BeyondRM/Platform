package brm.platform.maps.map;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A Mappable object.
 * @author Gregory
 */
abstract public class Mappable extends Crypto {
  protected static class  MappableMedias extends Crypto {
    /**
     * The background music.
     * @see MappableMedias
     */
    public Object bgm; // originally uses RGSS class BGM
    /**
     * The background sound.
     * @see MappableMedias
     */
    public Object bgs; // originally uses RGSS class BGS
    /**
     * Whether BGM auto-plays.
     * @see MappableMedias
     */
    public boolean autoplay_bgm;
    /**
     * Whether BGM auto-plays.
     * @see MappableMedias
     */
    public boolean autoplay_bgs;

    {
      autoplay_bgm = false;
      autoplay_bgs = false;
      bgm = null;
      bgs = null;
    }

    @Override
    public void performDecryption(DataInputStream dis) throws IOException {
      if(!PlatformArchitecture.mode.devOnly && dis != null) {
        autoplay_bgm = dis.readBoolean();
        autoplay_bgs = dis.readBoolean();
        // then, read the bgm and bgs properties...
      }
    }

    @Override
    public void performEncryption(DataOutputStream dos) throws IOException {
      if(PlatformArchitecture.mode.devOnly && dos != null) {
        dos.writeBoolean(autoplay_bgm);
        dos.writeBoolean(autoplay_bgs);
        // then, write the bgm and bgs properties...
      }
    }
  }

  /**
   * The default name. Game progress could change the map name; this is overridden in the engine's map class....
   * @see Mappable
   */
  public String display_name;
  /**
   * The tileset ID. Should probably be either a byte or a short; byte would probably be best.
   * @see Mappable
   */
  public int tileset_id;
  /**
   * The map width. This is the number of tiles across the map.
   * @see Mappable
   */
  public int width;
  /**
   * The map height. This is the number of tiles down the map.
   * @see Mappable
   */
  public int height;
  /**
   * The scrolling type. This controls whether a map is looped when a character comes to an edge; possible values are:
   * no loop, loop vertical, loop horizontal, or loop both. (We could make this an enumeration instance...)
   * <p/>
   * 0: no loop; 1: loop vertical; 2: loop horizontal; 3: loop both;
   * @see Mappable
   */
  public int scroll_type;
  /**
   * Battle background specification enabled.
   * @see Mappable
   */
  public boolean specify_battleback;
  /**
   * Battle background 1. This is the upper half of the battle-scene background.
   * @see Mappable
   */
  public String battleback1_name;
  /**
   * Battle background 1. This is the lower half of the battle-scene background.
   * @see Mappable
   */
  public String battleback2_name;
  /**
   * whether dashing disabled.
   * @see Mappable
   */
  public boolean disable_dashing;
  /**
   * the encounter list.
   * @see Mappable
   */
  public Object[] encounter_list; // originally an Encounter[] field
  /**
   * Steps until encounter.
   * @see Mappable
   */
  public int encounter_step;
  /**
   * The parallax name.
   * @see Mappable
   */
  public String parallax_name;
  /**
   * Parallax loops horizontal.
   * @see Mappable
   */
  public boolean parallax_loop_x;
  /**
   * Parallax loops vertical.
   * @see Mappable
   */
  public boolean parallax_loop_y;
  /**
   * Parallax value 'x'.
   * @see Mappable
   */
  public int parallax_sx;
  /**
   * Parallax value 'y'.
   * @see Mappable
   */
  public int parallax_sy;
  /**
   * Show parallax.
   * @see Mappable
   */
  public boolean parallax_show;
  /**
   * The map note text.
   * @see Mappable
   */
  public String note;
  /**
   * The map tile data.
   * @see Mappable
   */
  public Object data; // originally an Event object
  /**
   * The map event list.
   * @see Mappable
   */
  public Object[] events; // originally an Event[] object

  {
    display_name = "";
    tileset_id = 1;
    scroll_type = 0;
    specify_battleback = false;
    battleback1_name = ""; // the floor graphic
    battleback2_name = ""; // the wall graphic
    // autoplay and sound objects moved into class MappableMedias
    MappableMedias medias = new MappableMedias();
    disable_dashing = false;
    encounter_list = new Object[64]; // originally an Encounter[] object
    encounter_step = 30;
    parallax_name = "";
    parallax_loop_x = false;
    parallax_loop_y = false;
    parallax_sx = 0;
    parallax_sy = 0;
    parallax_show = false;
    note = "";
    events = new Object[10]; // originally an Event[] object
  }

  /**
   * A public constructor. This instantiates a new {@link Mappable} object, setting the width and height in map tiles.
   * @param i the map width
   * @param j the map height
   * @see Mappable
   */
  public Mappable(int i, int j) {
    width = i;
    height = j;
    //data = new Table(width, height, 4);
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
  }
}
