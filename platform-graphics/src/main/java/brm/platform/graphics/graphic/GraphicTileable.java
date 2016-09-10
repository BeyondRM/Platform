package brm.platform.graphics.graphic;
import brm.platform.graphics.graphic.tileable.TileData;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.IOException;


/**
 * A tileable graphic definition.
 * @author Gregory
 */
abstract public class GraphicTileable extends Graphic {
  private TileData[] data;

  public GraphicTileable(File f) throws IOException {
    super(f);
  }

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    // In this implementation, we read in the number of tiles in this tileable object, create the 'data' array with the
    // aforementioned size, then iterate through the array to read in that tileable object's metadata.
    int i = dis.readInt(); //  the size of the tiledata array...
    data = new TileData[i];
    for(TileData td : data) {
      td = new TileData();
      td.performDecryption(dis);
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    // This implementation should do everything the decryption method does, only writing instead of reading.
    dos.writeInt(data.length);
    for(TileData td : data) {
      td.performEncryption(dos);
    }
  }

  public BufferedImage getImage(int i) throws IOException {
    if(!loaded) {
      imageLoad();
    }
    TileData td = data[i];
    return image.getSubimage(td.getPosX(), td.getPosY(), td.getWide(), td.getHigh());
  }

  /**
   * Get a sub-image. This is used to obtain a sub-image by a singular integer index; this is useful for subclasses who
   * parse the main graphic into tileable images, and store the image in an array, where any image can be found through
   * an ordinal value.
   * @param i An {@link Integer} value, representing the ordinal index to find.
   * @return A {@link BufferedImage} object.
   * @see Graphic
   */
  abstract public BufferedImage getSubimage(int i);
}
///**
// * Get a sub-image. This is used to obtain a sub-image by a set of coordinates (beginning x and y, width and height),
// * then returned to the calling object as a buffered image object.
// * @param x An {@link Integer} value, representing the X position.
// * @param y An {@link Integer} value, representing the Y position.
// * @param w An {@link Integer} value, representing the tile width.
// * @param h An {@link Integer} value, representing the tile height.
// * @return A {@link BufferedImage} object.
// * @see Graphic
// */
//abstract public BufferedImage getSubimage(int x, int y, int w, int h);
