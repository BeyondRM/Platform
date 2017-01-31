package brm.platform.resource.graphics.image.tileset.tilesheet;
import brm.platform.resource.graphics.image.tileset.tilesheet.tile.Tile;
import brm.platform.resource.graphics.image.tileset.tilesheet.tile.TileBase;


/**
 * An animated tilesheet.
 * @author Gregory
 */
public final class ImageTilesheetAnim extends ImageTilesheet {
  private byte mode;

  public ImageTilesheetAnim(byte b) {
    tiles = new TileBase[256];
  }

  @Override
  public Tile get(int i, int j) {
    return null;
  }
}
