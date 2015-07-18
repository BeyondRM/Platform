package brm.platform.items;


/**
 * The Platform Items. This static-instanced class is the baseline platform module that contains all the definable item
 * objects in a game; it allows arranging the objects into their proper categories and subtypes.
 * <h1>Items: Categories and Subtypes.</h1>
 * This module should have the following defined item categorizations and subtypes, by default:
 * <pre>
 *  Consumable Items - use things to obtain a result upon activation.
 *  Craftable Items  - use things to make or unmake other things.
 *  Equipable Items  - use things on characters to enhance combat-ability.
 * </pre>
 * More categories and subtypes may be possible; however, it is left to third-party development to maintain such.
 * <h2>Consumable.</h2>
 * Consumable items are meant to be used in normal game-play, either to replenish a statistic or parameter, or to enact
 * a particular event-function when activated.
 * <ul>
 * <li/>Event items merely perform a defined event-code, when activated.
 * <li/>Medicinal items are meant as a curative or restorative objective; they replenish some depleted reserves.
 * <li/>Seed items are used to enhance some innate character parameter, above the character's baseline value. This is
 * not meant for "seeds" as in the planted entities on a map.
 * <li/>Skill book and skill scroll items both allow skills to be used by a character; in the book form, it allows some
 * characters to learn a skill they do not know yet, but the scroll form is essentially a "stored prepared skill", that
 * any character could practically use (perhaps if MP is at or above some minimum).
 * <li/>Switch items are essentially boolean toggles, flipping the state of a boolean variable to ON or OFF.
 * </ul>
 * More subtypes might be possible.
 * <h2>Craftable.</h2>
 * Craftable items are used in taking one or more items, to then produce one or more resulting items. Usually, one main
 * resulting item will be the target of the crafting process, and the remaining results may be auxiliary "waste" items,
 * more or less &mdash; even though a waste item could still be usable as a primary or supplemental ingredient in other
 * recipes. Like every other item, craftable objects depend upon the system-defined list of attributes, to specify what
 * sort of "material" the resulting item has properties of.
 * <ul>
 * <li/>Container items are objects, perhaps crafted themselves, that contain other objects. Most often, this might be
 * useful for flasks to contain liquids, such as potions, brews, et cetera; in other cases, it could be the pots, pans,
 * baking containers, and such that hold unfinished ingredients while in the "crafting" process (like baking). Further,
 * extending the baking and cooking metaphor, a container could simply be a plate or serving dish that merely presents
 * the final product to the customer.
 * <li/>Ingredient items (classified as either primary or supplemental ingredients) are used as baseline resources, for
 * crafting the recipe target item. In a baking analogy, primary items are the basis and core of the recipe, itself; it
 * may be a container of ground wheat flour that is used to make a cake. But supplemental items might be various flavor
 * ingredients that allow specialization of a produced product, such as vanilla or chocolate extract, that flavor cakes
 * and baked goods, or the finer-ground confectionery sugar that is sprinkled over bakery items for that special "look"
 * or "wow factor".
 * <li/>Recipe items are used to bring together ingredients, tools, and containers to make one or more resulting items.
 * A recipe may be single-use, but more often is something "learned" and then added to a "recipe book" or collection of
 * learned recipes; thereafter, it can be used at will (presuming the presence of the required ingredients, tools, and
 * containers).
 * <li/>Tools are items that are utensils used to craft ingredients into other items. An alchemist might have chemistry
 * rigs that allow brewing or extracting components from various ingredients; a baker may have a series of pots or pans
 * to bake their ingredients; smiths might have a forge with hammers, grippers, shaping tools, and finishing objects. A
 * specialized craft, in general, may have its own milieu and gear to perform their specialized work.
 * <li/>
 * </ul>
 * <h2>Equipable.</h2>
 * Equipable items can be attached to characters, to either increase one's attack, defense, or other statistic; an item
 * that is equipable, may or may not have secondary effects to combat, to conversations, or to general event control of
 * game-flow.
 * <ul>
 * <li/>Armors are equipment that provide an inherent defensive bonus. These are further sub-categorized into gear that
 * is either a held shield or barrier (to deflect attacks before they hit), or a worn piece of equipped body-protection
 * (to absorb, block, or deflect some or all hit-damage). The latter wearable pieces are typed based on where on a body
 * the item can be worn &mdash; as headgear, footwear, body armor, or miscellaneous accessories.
 * <li/>Weapons are equipment providing an inherent offensive bonus. These are sub-categorized into items for making an
 * attack of archery, ballistic, bladed, or bludgeon type; variations on these damage types may exist.
 * </ul>
 * Additional equippable types may be random objects that act as accessories that provide parameter or statistic bonus,
 * such as a pendant, ring, or other supplemental wearable.
 * @author Gregory
 * @see #instance instance
 * @see #PlatformItems() PlatformItems()
 */
public class PlatformItems {
  /**
   * The default {@link PlatformItems} instance.
   * @see #PlatformItems
   */
  public static final PlatformItems instance;

  static {
    instance = new PlatformItems();
  }

  private PlatformItems() {
  }
}
