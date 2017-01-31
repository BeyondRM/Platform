package brm.platform.database.events.entities;
import java.awt.image.BufferedImage;


/**
 * A map entity representing a character. This class defines fields and methods for managing an on-map entity that will
 * be an interactive character or object, and typically one that may move at random or according to a movement-route.
 * @author Gregory
 */
abstract public class AMapEntityChar extends AMapEntity {
  protected BufferedImage[] spriteFace;
}
