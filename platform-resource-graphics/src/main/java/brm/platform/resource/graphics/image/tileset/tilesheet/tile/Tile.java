package brm.platform.resource.graphics.image.tileset.tilesheet.tile;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.IOException;


/**
 * A tile definition. This object defines the individual tile data, such as bit-based and byte-based attributes.<p/>
 * Parsing the bits that are read into the constructor, we see the following:
 * <pre>
 * <li/>2 bits for passable; a tile may allow or disallow passage, or may allow passage but cover objects behind them;
 * <li/>4 bits for passways; a tile may be passable to north, south, west, and east; the diagonals can be abstracted.
 * <li/>1 bit each for ladder, bush, counter, damage; these allow the specified functionality to occur.
 * <li/>3 bits for terrain; a tile can be assigned a terrain where encounters are identical for same-numbered terrain.
 * </pre>
 * @author Gregory
 */
abstract public class Tile {
  /**
   * Whether passable. This defines a pseudo-boolean property, which RM used to define 3 states: un-passable, passable,
   * and passable but hides overlapped objects. In BeyondRM, we might as well use the fourth state in a two-bits value,
   * to use as an alternative or miscellaneous passability. (For example: the fourth state could be used for the entity
   * being visible but "ghosted" or alpha-shifted to be partially visible.)
   * @see Tile
   */
  public byte passable;
  /**
   * The directional passage. This could define either a 4-way or 8-way passability; this object typically only needs a
   * 4-bit value to parse for the four cardinal passabilities, and can then parse that to the remaining four directions
   * (the diagonals).
   * @see Tile
   */
  public byte passways;
  /**
   * Use as a ladder. This allows an entity to "climb"a tile as if it were a ladder object, allowing moving to a higher
   * location. It can be useful for restricting movement between different parts of a map, especially when creating the
   * events and objects which need to be interacted with, just to get somewhere specific.
   * @see Tile
   */
  public boolean ladder;
  /**
   * Use as a bush. This allows "hiding" or "submerging" an entity's bottom few pixels, making it seem as if the entity
   * is walking through some tall grass, low bushes, or other leg-height vegetation.
   * @see Tile
   */
  public boolean bush;
  /**
   * Use as a counter. This tile feature allows interacting with characters or objects placed behind counters/barriers,
   * by standing next to the counter.<p/>
   * When set on an A2 tile, the tile graphic is shifted 8 pixels (half the default tile height) "downward" in the map.
   * @see Tile
   */
  public boolean counter;
  /**
   * Use as a damager. This denotes whether the tile does or does not harm an entity crossing it. Damages might be from
   * something that causes physical harm, such as a spike trap, or cause other penalties, such as adding the "poisoned"
   * condition to the entity. Another example may be of a "swamp" tile, which (along with the "bush" condition) equates
   * to a character "wading" through a toxic, fetid swampy biome that could inflict a poisoned state, a sleepy state, a
   * confused state, or any other condition which may be appropriate. Or, in games which feature magic or mana, perhaps
   * the tile may cause those effects and more.<p/>
   * On the other hand, why not adapt this to a two- or three-bit "byte", whose values refer to <i>healing</i> effects,
   * as well as the harmful effects? Would be nice to have some tile instance automatically doing one of the following:
   * no action, heal a little, heal a lot, heal all, damage a little, damage a medium amount, damage a lot, or damage a
   * <i>major</i> amount.
   * @see Tile
   */
  public boolean damage;
  /**
   * The terrain tag. This allows specifying the terrain type that the tile corresponds to being. Originally, it was an
   * object of three bits, with values zero through seven, making eight total values possible.<p/>
   * This is a candidate for using more bits to make more possible values; four bits would allow sixteen total values.
   * @see Tile
   */
  public byte terrain;

  /**
   * A public constructor.
   * @param dis A {@link DataInputStrema} object, representing the input stream.
   * @throws java.io.IOException If the stream cannot be read.
   * @see Tile
   */
  public Tile(DataInputStream dis) throws IOException {
  }

  /**
   * Get an image. This returns the image at the specified index (for animated tiles).
   * @param i An {@link Integer} value, representing the ordinal value.
   * @return A {@link BufferedImage} object.
   * @see Tile
   */
  abstract protected BufferedImage get(int i);
}
