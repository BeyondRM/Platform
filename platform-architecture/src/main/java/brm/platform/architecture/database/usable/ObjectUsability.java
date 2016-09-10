package brm.platform.architecture.database.usable;
import static brm.platform.architecture.logger.ArchitectureLogger.logger;


/**
 * Object-usability methods.
 * @author Gregory
 * @see #isUsableBy(byte,short,short) isUsableBy(byte,short,short)
 */
public interface ObjectUsability {
  /**
   * If usable by entity. This method returns whether a given entity is allowed for usage by the specified race, class,
   * and character indices, in this order.<p>
   * Normal expected values for the parameters are ordinal whole numbers in the range of zero to the last index of that
   * object's array. The first parameter is a byte because I am currently presuming most games may not have 128 or more
   * unique races; many games could get by with half that, and even with complex games, I am unsure of needing any more
   * than allotted. The second and third parameters <i>are</i> {@code Short} values, however, because their arrays can
   * be larger than 128 objects; the number of classes could ostensibly grow to more than that, though perhaps not much
   * larger, while the number of characters can and should be definitely larger than the byte limit.<p>
   * If all three parameters receive their type's "MIN_VALUE" value, then this returns true; implementors must override
   * this and do their own analysis. The most common usage for this method is within the PlatformItems module, within a
   * majority of the item classes.
   * @param b A {@link Byte} value, representing the user's race ID.
   * @param s A {@link Short} value, representing the user's class ID.
   * @param t A {@link Short} value, representing the user's character ID.
   * @return A {@link Boolean} condition.
   * @see ObjectUsability
   * @see Byte#MIN_VALUE
   * @see Short#MIN_VALUE
   */
  default public boolean isUsableBy(byte b, short s, short t) {
    logger.finest(String.format("  Attempting to find usability for an object: raceID=%d, classID=%d, characterID=%d", b, s, t));
    return b == Byte.MIN_VALUE
        && s == Short.MIN_VALUE
        && t == Short.MIN_VALUE;
  }

  /**
   * If usable from somewhere. This method is used to specify if an item of this metatype is usable from an appropriate
   * context; it uses a byte-based value to control which boolean value is returned. The following values are supported
   * at this time:
   * <pre>
   *  ID  Usable From:
   *  ==  ============
   *   0  the item menu
   *   1  the overworld
   *   2  any other map
   *   3  in combat</pre>
   * Also note that the default method in the interface will return true, so implementors might not want to let methods
   * depend on a {@code super.isUsableWhen(b)} value too much.
   * @param b A {@link Byte} value, representing the requested mode or location.
   * @return A {@link Boolean} condition.
   * @see ObjectUsability
   */
  default public boolean isUsableWhen(byte b) {
    return true;
  }
}
