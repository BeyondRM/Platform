package brm.platform.items.item;
import brm.platform.items.enums.ItemType;


/**
 * A consumed item. This is the abstract parent class for all consumable objects that may exist in a character's actual
 * inventory; it is sub-classed to allow definition of more specific categorized items.
 * @author Gregory
 */
abstract public class AItemConsumed extends AItem {

  public AItemConsumed(ItemType it) {
    super(it);
  }
}
