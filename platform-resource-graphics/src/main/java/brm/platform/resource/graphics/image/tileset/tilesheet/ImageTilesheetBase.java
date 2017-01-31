package brm.platform.resource.graphics.image.tileset.tilesheet;
import brm.platform.resource.graphics.image.tileset.tilesheet.tile.Tile;
import brm.platform.resource.graphics.image.tileset.tilesheet.tile.TileBase;


/**
 * A base tilesheet.
 * @author Gregory
 */
public final class ImageTilesheetBase extends ImageTilesheet {
  public ImageTilesheetBase() {
    tiles = new TileBase[256];
    //TODO: instantiate additional fields of the tilesheet.
  }

  @Override
  public Tile get(int i, int j) {
    return tiles[i];
  }
}
