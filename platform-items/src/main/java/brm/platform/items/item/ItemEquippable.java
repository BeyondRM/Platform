package brm.platform.items.item;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * An equippable item. This is an abstract class defining subclasses meant to be worn or held in combat, to provide the
 * wearer a statistical bonus of their attack or defense.
 * <h1>Equippable.</h1>
 * Equippable items can be attached to characters to either increase one's attack, defense, or other statistic; an item
 * that is equippable, may or may not have secondary states to combat, to conversations, or to general event control or
 * game-flow.
 * <ul>
 * <li>Armors are equipment that provide an inherent defensive bonus, in either complete blocking or partial abatement,
 * of inbound damage. They are further sub-categorized from gear that is either a worn item of equipped body-protection
 * (to absorb, block, or deflect some or all hit-damage) or a held shielding item (to deflect attacks before they hit).
 * The former wearable items are typed based on where on the body the item can be worn &mdash; headgear, footwear, body
 * armor, or miscellaneous accessories.
 * <li>Weapons are equipment providing an inherent offensive bonus. They are sub-categorized as items for performing an
 * attack of archery, ballistic, bladed, or bludgeon type; variations on these damage types may also exist.
 * </ul>
 * Additional equippable types may be random objects that act as accessories that provide parameter or statistic bonus,
 * such as a pendant, ring, or other supplemental wearable.
 * @author Gregory
 */
abstract public class ItemEquippable extends Item {
  public ItemEquippable(DataInputStream dis) throws IOException {
    super(dis);
  }

  @Override
  public synchronized void performEncryption(DataOutputStream dos) throws IOException {
    if(isWritable()) {
    }
  }
}
