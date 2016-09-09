package brm.platform.items.item;
import brm.platform.architecture.PlatformArchitecture;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * A crafting item. This abstract parent class defines a crafting object. It has subclasses for specialization of three
 * major subtypes of craftable object:
 * <h1>Craftable.</h1>
 * Craftable items are used in taking one or more items, to then produce one or more resulting items. Usually, one main
 * resulting item will be the target of the crafting process, and the remaining results may be auxiliary "waste" items,
 * more or less &mdash; even though a waste item could still be usable as a primary or supplemental ingredient in other
 * recipes. Like every other item, craftable objects depend upon the system-defined list of attributes, to specify what
 * sort of "material" the resulting item has properties of.
 * <ul>
 * <li>Container items are objects, perhaps crafted themselves, which contain other objects. Most often, these might be
 * useful for flasks to contain liquids, such as potions, brews, et cetera; in other cases, it could be the pots, pans,
 * baking containers, and such that holds unfinished ingredients while in the "crafting" process (like baking). Further
 * extending the baking and cooking metaphor, a container may simply be the plate or serving dish which merely presents
 * the final product to the customer.
 * <li>Ingredient items (classified as either primary or supplemental ingredients) are used as baseline resources, for
 * crafting the recipe target item. In a baking analogy, primary items are the basis and core of the recipe, itself; it
 * may be a container of ground wheat flour that is used to make a cake. But supplemental items might be various flavor
 * ingredients that allow specialization of a produced product, such as vanilla or chocolate extract, that flavor cakes
 * and baked goods, or the finer-ground confectionery sugar that is sprinkled over bakery items for that special "look"
 * or "wow factor".
 * <li>Recipe items are used to bring together ingredients, tools, and containers to make one or more resulting items.
 * A recipe may be single-use, but more often is something "learned" and then added to a "recipe book" or collection of
 * learned recipes; thereafter, it can be used at will (presuming the presence of the required ingredients, tools, and
 * containers).
 * <li>Tools are items that are utensils used to craft ingredients into other items. An alchemist might have chemistry
 * rigs that allow brewing or extracting components from various ingredients; a baker may have a series of pots or pans
 * to bake their ingredients; smiths might have a forge with hammers, grippers, shaping tools, and finishing objects. A
 * specialized craft, in general, may have its own milieu and gear to perform their specialized work.
 * <li>
 * </ul>
 * @author Gregory
 */
abstract public class ItemCraftable extends Item {
  public ItemCraftable(DataInputStream dis) throws IOException {
    super(dis);
  }

  @Override
  public synchronized void performEncryption(DataOutputStream dos) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
    }
  }
}
