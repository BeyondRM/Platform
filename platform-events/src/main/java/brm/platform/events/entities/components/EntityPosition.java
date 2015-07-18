package brm.platform.events.entities.components;


/**
 * The entity position. This provides fields and methods for managing an in-map entity's specified position, namely its
 * X, Y, and Z values.
 * something
 * @author Gregory
 */
public class EntityPosition {
  /**
   * The entity's X coordinate. This relates to the position on the East-West plane (left or right on the screen).
   * @see EntityPosition
   */
  private int currentX;
  /**
   * The entity's Y coordinate. This relates to the position on the North-South plane (up or down on the screen).
   * @see EntityPosition
   */
  private int currentY;
  /**
   * The entity's Z coordinate. This relates to an inferred altitude on the map, which can be difficult to present to a
   * player; but it's meant to allow controlling movement and access to other parts of a map, via alternate thinking.
   * <p/>
   * A primary example of its use is for a player-party needing to get inside some walled fortress; from walking around
   * the fortress, no primary door or entry is present, but perhaps a vine is growing up the side of the wall &mdash; a
   * perfect chance to climb it, to get up to the top of the wall and find a way to descend to the fortress interior.
   * <p/>
   * Another example could be a location map with a river or narrow body of water, a perfect place to control access to
   * towns on the other side, and vice-versa. On this map may be a boat dock or a beached raft. Say that our party will
   * need to barter for the use of a boat, or fix the raft, and that character movement while on the boat or raft could
   * be part of the scene &mdash; such as a battle event at some point in crossing the river. The boat or raft might be
   * a pseudo-vehicle that ferries the party across the water, while allowing free movement.
   * @see EntityPosition
   */
  private int currentZ;
  /**
   * The entity's target X coordinate. This is meant to be zero-based; a value other than zero means a 'delta' change.
   * @see EntityPosition
   */
  private int targetX;
  /**
   * The entity's target Y coordinate. This is meant to be zero-based; a value other than zero means a 'delta' change.
   * @see EntityPosition
   */
  private int targetY;
  /**
   * The entity's target Z coordinate. This is meant to be zero-based; a value other than zero means a 'delta' change.
   * @see EntityPosition
   */
  private int targetZ;

  /**
   * A public constructor. This redirects class instantiation to the other constructor, passing along the values of the
   * parameter {@code ep}.
   * @param ep An {@link EntityPosition} object, representing an alternate position to set.
   * @see EntityPosition
   */
  public EntityPosition(EntityPosition ep) {
    this(ep.getCurrentX(), ep.getCurrentY(), ep.getCurrentZ());
  }

  /**
   * A public constructor. This directly sets the x, y, and z coordinates of a map entity.
   * @param x An {@link Integer} value, representing a specified 'X' coordinate.
   * @param y An {@link Integer} value, representing a specified 'Y' coordinate.
   * @param z An {@link Integer} value, representing a specified 'Z' coordinate.
   * @see EntityPosition
   */
  public EntityPosition(int x, int y, int z) {
    currentX = x;
    currentY = y;
    currentZ = z;
  }

  /**
   * Whether the entity is at the target position.
   * @return A {@link Boolean} condition.
   * @see EntityPosition
   */
  public boolean isAtTarget() {
    return currentX == targetX && currentY == targetY && currentZ == targetZ;
  }

  /**
   * Get the current X coordinate.
   * @return An {@link Integer} value.
   * @see EntityPosition
   */
  public int getCurrentX() {
    return currentX;
  }

  /**
   * Get the current Y coordinate.
   * @return An {@link Integer} value.
   * @see EntityPosition
   */
  public int getCurrentY() {
    return currentY;
  }

  /**
   * Get the current Z coordinate.
   * @return An {@link Integer} value.
   * @see EntityPosition
   */
  public int getCurrentZ() {
    return currentZ;
  }

  /**
   * Move to the target position.
   * @see EntityPosition
   */
  public void moveToTarget() {
  }

  /**
   * Set the current X, Y, and Z coordinates.
   * @param x An {@link Integer} value, representing a specified 'X' coordinate.
   * @param y An {@link Integer} value, representing a specified 'Y' coordinate.
   * @param z An {@link Integer} value, representing a specified 'Z' coordinate.
   * @see EntityPosition
   */
  public void setCurrentXYZ(int x, int y, int z) {
    currentX = x;
    currentY = y;
    currentZ = z;
  }

  /**
   * @param x An {@link Integer} value, representing a specified 'X' coordinate.
   * @param y An {@link Integer} value, representing a specified 'Y' coordinate.
   * @param z An {@link Integer} value, representing a specified 'Z' coordinate.
   * @see EntityPosition
   */
  public void setTargetXYZ(int x, int y, int z) {
    targetX = x;
    targetY = y;
    targetZ = z;
  }

  /**
   * @param x An {@link Integer} value, representing a specified 'X' coordinate.
   * @param y An {@link Integer} value, representing a specified 'Y' coordinate.
   * @param z An {@link Integer} value, representing a specified 'Z' coordinate.
   * @see EntityPosition
   */
  public void skewTarget(int x, int y, int z) {
    targetX += x;
    targetY += y;
    targetZ += z;
  }
}
