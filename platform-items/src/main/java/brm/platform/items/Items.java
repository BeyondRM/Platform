package brm.platform.items;
import abc.cryptology.logics.Crypto;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.items.item.ItemConsumable;
import brm.platform.items.item.ItemCraftable;
import brm.platform.items.item.ItemEquippable;
import brm.platform.items.type.ItemMetatype;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * The items. This class extracts all the fields and methods for the actual item objects away from PlatformArchitecture
 * and brings it here.
 * @author Gregory
 */
public final class Items extends Crypto {
  /**
   * @see Items
   */
  private static final ItemMetatype defaultMetatype;
  // Do other default item instances need to go here? Might be nice to always include a small handful of the consumable
  // and equippable item prototypes; like, a very small collection of healing potions, armors, weapons, and such.

  static {
    defaultMetatype = new ItemMetatype();
  }

  /**
   * The consumables. This array object is for the various item-definitions which are usable in many manners: either as
   * something consumed as food or for healing or restoration, or as a statistics-boost, or as something which gives an
   * amount of knowledge or unlocks some boolean condition somewhere; in some cases, an item might be a container which
   * opens to give its contents into the player's inventory. Other uses might even be to fire a common event.
   * @see Items
   * @see ItemConsumable
   */
  private ItemConsumable[] consumable;
  /**
   * The craftables. This array object is for the various ingredients, recipes, tools, and utensils which are necessary
   * to successfully complete a crafting event. Ingredients are essentially non-consumables, that would otherwise leave
   * the inventory full from the ingredients that were collected; they are usable in a crafting session to make objects
   * of greater value than the parts are worth. Recipes are the specific "driving directions" which a craftsman can use
   * to create something from other objects; this may give some amount of experience, as well as have requirements that
   * must be met before its use. The tools and utensils are non-consumable items which may be required in some recipes,
   * in order to make the recipe's resultant item.
   * @see Items
   * @see ItemCraftable
   */
  private ItemCraftable[] craftable;
  /**
   * The equippables. This array object is for the various items which are used in battle states: for attack or defense
   * on a character's turn, or perhaps for various status modes, boosting the bonuses and negating or diminishing those
   * negatives. They are divided into several different categories (which could be customized): armors that provide the
   * defense against incoming attacks; weapons to inflict damage upon the opponents; miscellaneous accessories, unusual
   * trinkets, and attire that provides other properties; and so on.
   * <p>
   * It should be remembered that it's in the race definitions that we apply the types of equipment that a character is
   * capable of wearing or using, not the class; because different races or species of beings could have different loci
   * for attaching various equipment, and unique considerations for each, that the race is the place to constrain them.
   * @see Items
   * @see ItemEquippable
   */
  private ItemEquippable[] equippable;
  /**
   * The meta-types. This array object is used for defining item meta-categorizations that may crossover various items:
   * consumable, craftable, and equippable items could, in theory, share a meta-type which defines common properties. A
   * prototypical reason for this, is that several items may share the usability-constraint options among them, and the
   * values in this array will template that, for later usage.
   * @see Items
   * @see ItemMetatype
   */
  private ItemMetatype[] metatype;
  /**
   * If the data is loaded. This is used to determine how loading is processed. It is false by default, but once set to
   * true, should never be set back to false (<i>id-est</i>, is set once for the duration of the game session).<p>
   * This is only set within the {@link #performDecryption(DataInputStream) performDecryption(DataInputStream)} method,
   * but is also used within the {@link #performEncryption(DataOutputStream) performEncryption(DataOutputStream)} base
   * method.
   * @see Items
   */
  private boolean loaded = false;

  @Override
  public void performDecryption(DataInputStream dis) throws IOException {
    if(!PlatformArchitecture.mode.devOnly && !loaded) {
      // perform a decryption and then set loaded to true
      loaded = true;
    }
  }

  @Override
  public void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly && loaded) {
    }
  }

  /**
   * Get a consumable item. This is an array of items that are consumed or expended, to provide something to someone or
   * something else of value. This includes various medicines, seeds, and other items.
   * @param b A {@link Byte} value, representing the ordinal index to return.
   * @return An {@link ItemConsumable} object.
   * @see Items
   * @see PlatformItems
   */
  public ItemConsumable itemConsumable(byte b) {
    return consumable == null ? null : consumable[b];
  }

  /**
   * Get a craftable item.
   * @param b A {@link Byte} value, representing the ordinal index to return.
   * @return An {@link ItemCraftable} object.
   * @see Items
   * @see PlatformItems
   */
  public ItemCraftable itemCraftable(byte b) {
    return craftable == null ? null : craftable[b];
  }

  /**
   * Get an equippable item.
   * @param b A {@link Byte} value, representing the ordinal index to return.
   * @return An {@link ItemEquippable} object.
   * @see Items
   * @see PlatformItems
   */
  public ItemEquippable itemEquippable(byte b) {
    return equippable == null ? null : equippable[b];
  }

  /**
   * Get an item meta-type. The meta-type defines preemptive allowing or disallowing of usability of an item within its
   * category, and is primarily called from the item's own method to find usability per user or per location.<p>
   * Note that if the meta-type array is null, a default one will be used, which allows usage from anywhere: all races,
   * classes, and characters, as well as from any menu screen, in any map, or even in battle. This meta-type array only
   * needs to contain custom objects, IF some items need to be specialized by when, where, or from what entity they are
   * usable.
   * @param b
   * @return An {@link ItemMetatype} object.
   * @see Items
   * @see PlatformItems
   */
  public ItemMetatype itemMetatype(byte b) {
    return metatype == null || b >= metatype.length ? defaultMetatype : metatype[b];
  }
}
