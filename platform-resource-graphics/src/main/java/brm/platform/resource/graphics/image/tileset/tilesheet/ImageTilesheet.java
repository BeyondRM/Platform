package brm.platform.resource.graphics.image.tileset.tilesheet;
import brm.platform.resource.graphics.image.tileset.tilesheet.tile.Tile;


/**
 * An image tilesheet.
 * @author Gregory
 */
abstract public class ImageTilesheet {
  public String file;
  public Tile[] tiles; // can be either animated or basic/normal tiles

  /**
   * get a tile by ordinal number and time
   * @param i ordinal tile number
   * @param j in-game tick/time
   * @return A {@link Tile} object.
   */
  abstract public Tile get(int i, int j);
}
