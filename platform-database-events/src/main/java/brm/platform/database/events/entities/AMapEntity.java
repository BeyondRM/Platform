package brm.platform.database.events.entities;
import brm.platform.events.entities.components.EntityPosition;
import java.awt.image.BufferedImage;


/**
 * A map entity. This abstract class defines baseline attributes for map-specific event entities; this is used for map
 * characters, static objects, and timer-based event code (including plantable and growing objects.
 * <p/>
 * The fields and methods defined herein are generalized to most all of the subclasses, such that every subclass should
 * use every bit of them in some respect.
 * @author Gregory
 */
abstract public class AMapEntity {
  protected BufferedImage[] spriteBase;
  protected EntityPosition positionSource;
  protected EntityPosition positionTarget;

  public AMapEntity() {
  }

  public AMapEntity(EntityPosition ep) {
    positionSource = ep;
  }
}
