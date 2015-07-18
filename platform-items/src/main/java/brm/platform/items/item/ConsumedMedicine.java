package brm.platform.items.item;
import brm.platform.items.enums.ItemType;


/**
 * A consumable medicine. This class defines a medicine item &mdash; used as a curative or restorative object, it could
 * be something that cures or diminishes negative character states, or brings back diminished parameters or statistics.
 * A medicine is almost always a positive thing to use, when battle conditions or events may have decreased a character
 * in some fashion, and the player wants to restore the character to a better status.
 * @author Gregory
 */
public class ConsumedMedicine extends AItemConsumed {

  public ConsumedMedicine() {
    super(ItemType.it00);
  }
}
