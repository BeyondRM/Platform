package brm.platform.items.item;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A consumed item. This is the abstract parent class for all consumable objects that may exist in a character's actual
 * inventory; it is sub-classed to allow definition of more specific categorized items.
 * <h1>Consumable.</h1>
 * Consumable items are meant to be used in normal game-play, either to replenish a statistic or parameter, or to enact
 * a particular event-function when activated.
 * <ul>
 * <li>Event items merely perform a defined event-code, when activated.
 * <li>Medicinal items are meant as a curative or restorative objective; they replenish some depleted reserves.
 * <li>Seed items are used to enhance some innate character parameter(s), above the character's baseline value. This is
 * not meant for "seeds" as in the planted entities on a map; but rather in the "classic rpg" sense, an item that gives
 * a statistics-boost to a character's statistics.
 * <li>Skill-based books and scrolls will both allow skills to be used by a character; in the book form, it allows some
 * characters to learn a skill they do not know yet, but the scroll form is essentially a "stored prepared skill", that
 * any character could practically use (perhaps either with or without the skill`s prerequisite MP).
 * <li>Switch items are essentially boolean toggles, flipping the state of a boolean variable to ON or OFF. These could
 * be used enable or disable something, to allow a player-character access through somewhere, or for moving a game plot
 * forward.
 * </ul>
 * More subtypes might be possible.
 * @author Gregory
 */
abstract public class ItemConsumable extends Item {
  protected byte quantityUsesBase;
  protected byte quantityUsesXtra;

  public ItemConsumable(DataInputStream dis) throws IOException {
    super(dis);
  }

  @Override
  public synchronized void performEncryption(DataOutputStream dos) throws IOException {
    if(isWritable()) {
    }
  }
}
