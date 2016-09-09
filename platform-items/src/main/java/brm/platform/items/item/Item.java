package brm.platform.items.item;
import abc.cryptology.logics.ICryptoWriter;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.architecture.database.AInformation;
import brm.platform.architecture.database.InformationBasic;
import brm.platform.architecture.database.usable.ObjectUsability;
import brm.platform.items.PlatformItems;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;


/**
 * An item definition. Contains fields and methods for managing the details of an Item instance, based off an object in
 * the game database. It contains fields to centralize information, enumerations to define the item type, et cetera.<p>
 * <h1>Usability and Usage.</h1>
 * This class contains fields which are meant to contain whether the base item is usable from a certain context or from
 * a certain entity or character. The {@code ObjectUsability} interface also defines the methods that control how they
 * are used.<p>
 * The first part of this is in determining usability in relation to a source entity (a character) given a race, class,
 * or character IDs; these are used in matching whether the item should be "disallowed" for use by the entity.<p>
 * Second is the method for determining whether another aspect of the game should display the item, such as a selection
 * menu or for inventory management.
 * @author Gregory
 */
abstract public class Item implements ICryptoWriter, ObjectUsability {
  // first, the usability-constraint fields:
  /**
   * If usable in the item menu.
   * <p>
   * If true, an item under this meta-type is enabled to be displayed or used from within an items-list menu or screen.
   * @see Item
   */
  private final boolean usableInGameItemMenu;
  /**
   * If usable in the over-world.
   * <p>
   * If true, an item under this meta-type is enabled to be displayed or used while the player is on an over-world map.
   * @see Item
   */
  private final boolean usableInMapOverworld;
  /**
   * If usable in other game maps.
   * <p>
   * If true, this controls whether an item under this meta-type is enabled to be displayed or used while the player is
   * not on an over-world map.
   * @see Item
   */
  private final boolean usableInMapSomewhere;
  /**
   * If usable while in combat.
   * <p>
   * If true, this controls whether an item under this meta-type is enabled to be displayed or used while the player is
   * engaged in combat.
   * @see Item
   */
  private final boolean usableWhenCombatting;
  /**
   * Unusable by race IDs. The byte values found in this array depict ordinal race indices, that should not be able to,
   * by normal means, use the given item.<p>
   * Not all races should need to be able to use all items; in fact, it enhances game-play to a great extent in forcing
   * players to choose from a pre-filtered items list which is allowed from the total items arrays (in conjunction with
   * filtering by class and character IDs). For example, among the armors and weapons items, a being of a morphological
   * race might not have need of hardened shields or armors in the same way that a soft-skinned human would. In another
   * example, medicines to cure a human(oid) condition may not work at all for a non-humanoid race, so why not deselect
   * them entirely (or show as disabled) when selecting consumables?
   * @see Item
   */
  private final byte[] unusableByRaces;
  /**
   * Unusable by character IDs. The short values found in this array depict ordinal character indices, which should not
   * be able to, by normal means, use the given item.<p>
   * Not all characters should need to be able to use all items; in fact, it enhances game-play to an extent in forcing
   * players to choose from a pre-filtered items list which is allowed from the total items arrays (in conjunction with
   * filtering by race and classIDs). For example, this factor can be used to simulate differences between individuals
   * of the same race and class, so that not all of them are cookie-cutter clones. Tom, Dick, and Harry may all be good
   * soldiers and experienced with swords; while Tom and Dick can also use lances, perhaps Harry cannot use them, since
   * he may have seen a loved one killed by one when young, and cannot un-learn the fear of them.
   * @see Item
   */
  private final short[] unusableByChars;
  /**
   * Unusable by class IDs. The short values found in this array depict ordinal class indices, which should not be able
   * to, by normal means, use the given item.<p>
   * Not all classes should need to be able to use all items; in fact, it enhances game-play to an extent in forcing of
   * players to choose from a pre-filtered items list which is allowed from the total items arrays (in conjunction with
   * filtering by race and character IDs).
   * @see Item
   */
  private final short[] unusableByClass;
  // finally, the other fields:
  /**
   * The information.
   * @see Item
   */
  protected final AInformation information; // Descriptors for UI: name, note, text. If more is needed, use another class.
  /**
   * The maximum stack size. This is a maximum value for allowing this item to be stacked with other identical items of
   * this type. As this is a byte, values between -128 and 127 can be handled; but we only expect positive integers....
   * @see Item
   */
  protected final byte maxStackSize;
  /**
   * The item type. This was an enumeration instance, but is now a byte so that it can be parsed as the index into the
   * array of {@code ItemType} objects, in the {@code PlatformItems} class.
   * @see Item
   */
  protected final byte type;
  /**
   * The item weight. This is a metric measurement of per-unit weight of one item.
   * <p>
   * Weight can be used to total the carrying weight of a character, a party, et cetera; with it, we could, sometime in
   * the future, create a methodology for constraining how many items a character or party could possess. Further, such
   * a methodology might allow for worn armor and weapons might have a lower apparent weight; and that multiple persons
   * working together might be able to carry slightly more weight than individually.
   * @see Item
   */
  protected final float weight; // but does weight really need to be a float?
  /**
   * The item price. This price is the cost for one unit of this item to be purchased by the player's party. Many items
   * may be sold for only a portion of this cost. A price could at some point also be somewhat variable; but for now, a
   * price should be used as a baseline cost across the whole game.
   * @see Item
   */
  protected final int price;    // have a price (either static or formulaic), ...

  /**
   * A public constructor. This reads data in from an input stream, and sets up the class fields to their basic values.
   * @param dis
   * @throws java.io.IOException
   * @see BaseItem
   */
  public Item(DataInputStream dis) throws IOException {
    if(PlatformArchitecture.mode.devOnly) {
      usableInGameItemMenu = true;
      usableInMapOverworld = true;
      usableInMapSomewhere = true;
      usableWhenCombatting = true;
      unusableByRaces = null;
      unusableByClass = null;
      unusableByChars = null;
      type = Byte.MAX_VALUE;
      maxStackSize = Byte.MAX_VALUE;
      price = 0;
      weight = 0F;
      information = new InformationBasic();
    } else {
      //TODO: Should the four booleans be parsed from the bits in a byte?
      usableInGameItemMenu = dis.readBoolean();
      usableInMapOverworld = dis.readBoolean();
      usableInMapSomewhere = dis.readBoolean();
      usableWhenCombatting = dis.readBoolean();
      byte b;
      // usability
      b = dis.readByte(); // starting with the unusable races...
      unusableByRaces = b > 0 ? new byte[b] : null;
      if(unusableByRaces.length > 0) {
        for(int i = 0; i < unusableByRaces.length; i++) {
          unusableByRaces[i] = dis.readByte();
        }
      }
      b = dis.readByte(); // starting with the unusable classes...
      unusableByClass = b > 0 ? new short[b] : null;
      if(unusableByClass.length > 0) {
        for(int i = 0; i < unusableByClass.length; i++) {
          unusableByClass[i] = dis.readByte();
        }
      }
      b = dis.readByte(); // starting with the unusable classes...
      unusableByChars = b > 0 ? new short[b] : null;
      if(unusableByChars.length > 0) {
        for(int i = 0; i < unusableByChars.length; i++) {
          unusableByChars[i] = dis.readByte();
        }
      }
      // all else.
      type = dis.readByte();
      maxStackSize = dis.readByte();
      price = dis.readInt();
      weight = dis.readFloat();
      information = new InformationBasic(dis);
    }
  }

  @Override
  public final boolean isUsableBy(byte b, short s, short t) {
    if(PlatformItems.instance.getItems().itemMetatype(type).isUsableBy(b, s, t)
        && b != Byte.MIN_VALUE && s != Short.MIN_VALUE && t != Short.MIN_VALUE) {
      for(byte b1 : unusableByRaces) {
        if(b == b1) {
          return false;
        }
      }
      for(short s1 : unusableByClass) {
        if(s == s1) {
          return false;
        }
      }
      for(short s1 : unusableByChars) {
        if(t == s1) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public final boolean isUsableWhen(byte b) {
    return false;
  }

  @Override
  public final boolean isWritable() {
    return PlatformArchitecture.mode.devOnly;
  }

  @Override
  public synchronized void performEncryption(DataOutputStream dos) throws IOException {
    if(isWritable()) {
      if(unusableByRaces == null || unusableByRaces.length == 0) {
        dos.writeByte(0);
      } else {
        dos.writeByte(unusableByRaces.length);
      }
      if(unusableByClass == null || unusableByClass.length == 0) {
        dos.writeByte(0);
      } else {
        dos.writeByte(unusableByClass.length);
      }
      if(unusableByChars == null || unusableByChars.length == 0) {
        dos.writeByte(0);
      } else {
        dos.writeByte(unusableByChars.length);
      }

      information.performEncryption(dos);
      dos.writeByte(type);
      dos.writeByte(maxStackSize);
      dos.writeInt(price);
      dos.writeFloat(weight);
    }
  }

  public AInformation getInformation() {
    return information;
  }

  public final byte getMaxStackSize() {
    return maxStackSize;
  }

  public final byte getType() {
    return type;
  }

  public final float getWeight() {
    return weight;
  }

  public final int getPrice() {
    return price;
  }
}
