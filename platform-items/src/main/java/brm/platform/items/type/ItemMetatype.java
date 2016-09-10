package brm.platform.items.type;
import abc.cryptology.logics.ICryptoWriter;
import brm.platform.architecture.PlatformArchitecture;
import brm.platform.architecture.database.AInformation;
import brm.platform.architecture.database.InformationBasic;
import brm.platform.architecture.database.usable.ObjectUsability;
import brm.platform.architecture.logger.ArchitectureLogger;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import static brm.platform.architecture.logger.ArchitectureLogger.logger;


/**
 * An item meta-type. This class allows defining an item meta-type as having textual information, constraining the item
 * category's usability, and other factors that apply across a whole subset of items.
 * <h1>Usable vs Unusable.</h1>
 * The primary idea for this class, and the similar methodology in the Item classes, is that items should be usable for
 * anyone and anywhere, so that few restrictions are necessary. But the easier way of creating consumable or equippable
 * objects that members of certain classes or races cannot or do not use, becomes apparent &mdash; this class came into
 * being.<p>
 * This contains four boolean fields, for tracking whether an item is usable in an item menu, on a map, or for battling
 * something; more booleans could potentially be added, if and when required, then possibly even parsed from and into a
 * byte value.<p>
 * The logic we use for this is then that we only need to set "unusable" the races, classes, and characters which would
 * not be able to use something &mdash; first, for the item meta-type, then for the item data itself. If that meta-type
 * does not allow the entity to use it, no further query needs to occur; a boolean {@code false} value is returned; or
 * the item checks the same things on itself, and returns <i>that</i> state instead.
 * @author Gregory
 * @see ICryptoWriter
 * @see ObjectUsability
 */
public final class ItemMetatype implements ICryptoWriter, ObjectUsability {
  /**
   * If usable in the item menu.
   * <p>
   * If true, an item under this meta-type is enabled to be displayed or used from within an items-list menu or screen.
   * @see ItemMetatype
   */
  private final boolean usableInGameItemMenu;
  /**
   * If usable in the over-world.
   * <p>
   * If true, an item under this meta-type is enabled to be displayed or used while the player is on an over-world map.
   * @see ItemMetatype
   */
  private final boolean usableInMapOverworld;
  /**
   * If usable in other game maps.
   * <p>
   * If true, this controls whether an item under this meta-type is enabled to be displayed or used while the player is
   * not on an over-world map.
   * @see ItemMetatype
   */
  private final boolean usableInMapSomewhere;
  /**
   * If usable while in combat.
   * <p>
   * If true, this controls whether an item under this meta-type is enabled to be displayed or used while the player is
   * engaged in combat.
   * @see ItemMetatype
   */
  private final boolean usableWhenCombatting;
  /**
   * Races which cannot use. This is used to list any of the race IDs which cannot use an item in this meta-type.
   * <p>
   * This shall preempt an individual item's usability, so care should be taken to only include those elements that are
   * certain to not use a thing.
   * @see ItemMetatype
   */
  private final byte[] unusableByRace;
  /**
   * Classes which cannot use. This is used to list any of the class IDs which cannot use an item in this meta-type.
   * <p>
   * This shall preempt an individual item's usability, so care should be taken to only include those elements that are
   * certain to not use a thing.
   * @see ItemMetatype
   */
  private final short[] unusableByClass;
  /**
   * Characters which cannot use. This is used to list any of the hero IDs which cannot use an item in this meta-type.
   * <p>
   * This shall preempt an individual item's usability, so care should be taken to only include those elements that are
   * certain to not use a thing.
   * @see ItemMetatype
   */
  private final short[] unusableByChar;
  /**
   * The information. This is an informational object, which only defines a few textual descriptors: name, description,
   * and note. These are things which are typically only shown from within a game menu.
   * @see ItemMetatype
   * @see AInformation
   */
  public final AInformation information;

  /**
   * A public constructor. This allows instantiating a blank, default item meta-type, with generic values. The "usable"
   * fields default to true; the "unusable" fields default to null; and the information field is initialized with blank
   * texts.
   * @see ItemMetatype
   */
  public ItemMetatype() {
    logger.entering(ItemMetatype.class.getName(), "ItemMetatype");
    usableInGameItemMenu = true;
    usableInMapOverworld = true;
    usableInMapSomewhere = true;
    usableWhenCombatting = true;
    unusableByRace = null;
    unusableByClass = null;
    unusableByChar = null;
    information = new InformationBasic();
    logger.finest(ArchitectureLogger.message_class_ctor_default);
    logger.exiting(ItemMetatype.class.getName(), "ItemMetatype");
  }

  /**
   * A public constructor. This allows instantiating an item metatype, using an input stream to read values.
   * @param dis A {@link DataInputStream} object, representing the input stream source.
   * @throws java.io.IOException
   * @see ItemMetatype
   */
  public ItemMetatype(DataInputStream dis) throws IOException {
    logger.entering(ItemMetatype.class.getName(), "ItemMetatype", new Object[]{dis});
    byte b;
    // start usable-in states
    logger.info("TODO: This first section is broken until I have a byte-to-booleans translation method.");
    b = dis.readByte();
    logger.info(String.format("  dis.readByte() is %s but value is unused until above is figured out.", b));
    usableInGameItemMenu = true; // b1[0];
    usableInMapOverworld = true; // b1[1];
    usableInMapSomewhere = true; // b1[2];
    usableWhenCombatting = true; // b1[3];
    // start reading races
    b = dis.readByte();
    if(b <= 0) {
      unusableByRace = null;
    } else {
      unusableByRace = new byte[b];
      for(int i = 0; i < unusableByRace.length; i++) {
        unusableByRace[i] = dis.readByte();
      }
    }
    // start reading classes
    b = dis.readByte();
    if(b <= 0) {
      unusableByClass = null;
    } else {
      unusableByClass = new short[b];
      for(int i = 0; i < unusableByClass.length; i++) {
        unusableByClass[i] = dis.readShort();
      }
    }
    // start reading characters
    b = dis.readByte();
    if(b <= 0) {
      unusableByChar = null;
    } else {
      unusableByChar = new short[b];
      for(int i = 0; i < unusableByChar.length; i++) {
        unusableByChar[i] = dis.readShort();
      }
    }
    // start reading information
    information = new InformationBasic(dis);
    logger.exiting(ItemMetatype.class.getName(), "ItemMetatype");
  }

  /**
   * A public constructor. This allows instantiating an item metatype, by giving initial values for the fields. This is
   * to allow fields to stay private and final, as much as possible, which reduces the capacity for static values to be
   * changed mid-game.<p>
   * The first parameter, a boolean array, represents (in order) the following usability modes: in item menu, overworld
   * maps, other maps, and while in combat; these four booleans could be shrunk into a byte value and parsed to boolean
   * values, to save space in a data-file (if necessary).
   * @param b1 A {@link Boolean} array, representing the usable-from states.
   * @param b2 A {@link Byte} array, representing the unusable race IDs.
   * @param s1 A {@link Short} array, representing the unusable class IDs.
   * @param s2 A {@link Short} array, representing the unusable character IDs.
   * @see ItemMetatype
   */
  public ItemMetatype(boolean[] b1, byte[] b2, short[] s1, short[] s2) {
    logger.entering(ItemMetatype.class.getName(), "ItemMetatype", new Object[]{b1, b2, s1, s2});
    usableInGameItemMenu = b1[0];
    usableInMapOverworld = b1[1];
    usableInMapSomewhere = b1[2];
    usableWhenCombatting = b1[3];
    unusableByRace = b2;
    unusableByClass = s1;
    unusableByChar = s2;
    information = new InformationBasic();
    logger.exiting(ItemMetatype.class.getName(), "ItemMetatype");
  }

  @Override
  public boolean isUsableBy(byte b, short s, short t) {
    if(b == Byte.MIN_VALUE && s == Short.MIN_VALUE && t == Short.MIN_VALUE) {
      return true;
    } else if(unusableByRace != null && unusableByRace.length > 0) {
      for(byte c : unusableByRace) {
        if(b == c) {
          return false;
        }
      }
    } else if(unusableByClass != null && unusableByClass.length > 0) {
      for(short u : unusableByClass) {
        if(s == u) {
          return false;
        }
      }
    } else if(unusableByChar != null && unusableByChar.length > 0) {
      for(short u : unusableByChar) {
        if(t == u) {
          return false;
        }
      }
    }
    return true;
  }

  @Override
  public boolean isUsableWhen(byte b) {
    logger.entering(ItemMetatype.class.getName(), "ItemMetatype", new Object[]{b});
    switch(b) {
      case 0:
        logger.finest("  Type is usable from an item menu or skill menu.");
        return usableInGameItemMenu;
      case 1:
        logger.finest("  Type is usable from the over-world map.");
        return usableInMapOverworld;
      case 2:
        logger.finest("  Type is usable from maps other than the over-world.");
        return usableInMapSomewhere;
      case 3:
        logger.finest("  Type is usable when player is in combat.");
        return usableWhenCombatting;
      default:
        // For additional states. Should more booleans be added, add more case statements and return the right boolean.
        logger.finest(String.format("  Usability is undefined; expected a byte (value 0-3, inclusive) but got %d", b));
        return false;
    }
  }

  @Override
  public boolean isWritable() {
    return PlatformArchitecture.mode.devOnly;
  }

  @Override
  public synchronized void performEncryption(DataOutputStream dos) throws IOException {
    if(isWritable()) {
      dos.writeBoolean(usableInGameItemMenu);
      dos.writeBoolean(usableInMapOverworld);
      dos.writeBoolean(usableInMapSomewhere);
      dos.writeBoolean(usableWhenCombatting);
      if(unusableByRace == null || unusableByRace.length == 0) {
        dos.writeByte(Byte.MIN_VALUE);
      } else {
        dos.writeByte(unusableByRace.length);
        for(byte b : unusableByRace) {
          dos.writeByte(b);
        }
      }
      if(unusableByClass == null || unusableByClass.length == 0) {
        dos.writeShort(Short.MIN_VALUE);
      } else {
        dos.writeByte(unusableByClass.length);
        for(short s : unusableByClass) {
          dos.writeShort(s);
        }
      }
      if(unusableByChar == null || unusableByChar.length == 0) {
        dos.writeShort(Short.MIN_VALUE);
      } else {
        dos.writeByte(unusableByChar.length);
        for(short s : unusableByChar) {
          dos.writeShort(s);
        }
      }
      information.performEncryption(dos);
    }
  }
}
