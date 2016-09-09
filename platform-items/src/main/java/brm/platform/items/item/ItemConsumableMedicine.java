package brm.platform.items.item;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A consumable medicine. This class defines a medicine item &mdash; used as a curative or restorative object, it could
 * be something that cures or diminishes negative character states, or brings back diminished parameters or statistics.
 * A medicine is almost always a positive thing to use, when battle conditions or events may have decreased a character
 * in some fashion, and the player wants to restore the character to a better status.
 * @author Gregory
 */
public class ItemConsumableMedicine extends ItemConsumable {
  public ItemConsumableMedicine(DataInputStream dis) throws IOException {
    super(dis);
  }

  @Override
  public synchronized void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
    }
  }
}
