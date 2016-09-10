package brm.platform.items.enums;


/**
 * The item types. This enumeration defines the instance-types of items that can be categorized.
 * @author Gregory
 * @see #it00 it00
 * @see #it01 it01
 * @see #it02 it02
 * @see #it03 it03
 * @see #it04 it04
 * @see #it05 it05
 * @see #it06 it06
 * @see #it07 it07
 * @see #it08 it08
 * @see #it09 it09
 * @see #it10 it10
 * @see #it11 it11
 * @see #it12 it12
 * @see #it13 it13
 * @see #it14 it14
 * @see #it15 it15
 * @see #it16 it16
 * @see #it17 it17
 * @see #it18 it18
 * @see #it19 it19
 * @see #it20 it20
 * @see #it21 it21
 * @see #it22 it22
 * @see #it23 it23
 * @see #it24 it24
 * @see #it25 it25
 * @see #it26 it26
 * @see #it27 it27
 * @see #it28 it28
 * @see #it29 it29
 * @see #it30 it30
 * @see #it31 it31
 * @see #it32 it32
 * @see #it33 it33
 * @see #it34 it34
 * @see #it35 it35
 * @see #it36 it36
 * @see #it37 it37
 * @see #it38 it38
 * @see #it39 it39
 */
public enum ItemType {
  // Consumables:
  /**
   * A consumable medicine. A medicine item is meant to be a curative, healing, or boost to a character's statistics or
   * parameters.
   * @see ItemType
   */
  it00, // consumable medicine
  /**
   * A consumable seed. This item is something that increases a character's single statistic or parameter by an amount.
   * <p>
   * The "seed" does not equate to a plantable entity, because this is something consumed, and plantable objects cannot
   * typically; see something else entirely.
   * @see ItemType
   */
  it01, // consumable seed/stat increment (a.k.a., a "booster" that increases something)
  /**
   * A consumable skill-book. This item is essentially a learnable skill instance; if the character using it is allowed
   * to learn the contained skill, this skill book will be consumed and the character will learn the skill.
   * <p>
   * It differs from a skill scroll, by the fact that this item is directly learnable, while a skill scroll is not; and
   * a scroll is usable for its skill, while a book is not.
   * @see ItemType
   */
  it02, // consumable skill-book
  /**
   * A consumable skill-scroll. This item is essentially a stored skill instance that can be used by almost anyone that
   * has it in inventory.
   * <p>
   * It differs from a skill book, by the fact that this item is not directly learnable; where a skill book is learned,
   * but not directly usable from the book.
   * @see ItemType
   */
  it03, // consumable skill-scroll
  /**
   * A consumable switch. This item operates like an actionable boolean toggle. Using the item of this type can trigger
   * a specified boolean "switch".
   * @see ItemType
   */
  it04, // consumable switch
  /**
   * A consumable event. This item, like the consumable switch, is actionable; however, unlike the other, this item may
   * contain a page of commands as an event, only triggered by manual activation.
   * @see ItemType
   */
  it05, // consumable event
  /**
   * @see ItemType
   */
  it06, // .
  /**
   * @see ItemType
   */
  it07, // .
  /**
   * @see ItemType
   */
  it08, // .
  /**
   * @see ItemType
   */
  it09, // .
  // Craftables:
  /**
   * @see ItemType
   */
  it10, // craftable container
  /**
   * @see ItemType
   */
  it11, // craftable ingredient
  /**
   * @see ItemType
   */
  it12, // craftable recipe
  /**
   * @see ItemType
   */
  it13, // craftable tool
  /**
   * @see ItemType
   */
  it14, // .
  /**
   * @see ItemType
   */
  it15, // .
  /**
   * @see ItemType
   */
  it16, // .
  /**
   * @see ItemType
   */
  it17, // .
  /**
   * @see ItemType
   */
  it18, // .
  /**
   * @see ItemType
   */
  it19, // .
  // Equipables (weapons and armors):
  /**
   * @see ItemType
   */
  it20, // equipment weapon - bladed-axes         (heavy-slashing)
  /**
   * @see ItemType
   */
  it21, // equipment weapon - bladed-daggers      (stabbing)
  /**
   * @see ItemType
   */
  it22, // equipment weapon - bladed-swords       (slashing)
  /**
   * @see ItemType
   */
  it23, // equipment weapon - bludgeon-fist/hand  (raw fist power, gloves, etc.)
  /**
   * @see ItemType
   */
  it24, // equipment weapon - bludgeon-bashing    (clubs, maces, general hitting weapons)
  /**
   * @see ItemType
   */
  it25, // equipment weapon - bludgeon-miscellany (other, noncategorized bashing weapons)
  /**
   * @see ItemType
   */
  it26, // equipment weapon - polearm-bladed      (pike/spear weapons like polearms/staves, but often blade-tipped)
  /**
   * @see ItemType
   */
  it27, // equipment weapon - polearm-staves      (non-bladed staff weapons to both deflect incoming damage and inflict light impact damage)
  /**
   * @see ItemType
   */
  it28, // equipment weapon - ranged-archery      (bows used to aim and fire arrows at a target with raw arm-power)
  /**
   * @see ItemType
   */
  it29, // equipment weapon - ranged-ballistic    (guns/crossbows that aim and fire projectiles with force to go further than archery weapons)
  /**
   * @see ItemType
   */
  it30, // equipment weapon - ranged-thrown       (dirks/dagger/shuriken that are thrown at a target to cause damage)
  /**
   * @see ItemType
   */
  it31, // equipment weapon - ranged-reach        (miscellaneous ranged weapons that have some reach and flexibility)
  /**
   * @see ItemType
   */
  it32, // equipment weapon - magic-staffs        (rods/staffs/wands that hold or focus magical ability; lightweight bashing)
  /**
   * @see ItemType
   */
  it33, // equipment weapon - magic-orbs          (crystal balls/orbs that hold or focus magical ability; often fragile)
  /**
   * @see ItemType
   */
  it34, // equipment weapon - magic-trinkets      (miscellaneous magic objects that focus magical ability)
  /**
   * @see ItemType
   */
  it35, // equipment armor - headwear-wraps       (bandanas, turbans)
  /**
   * @see ItemType
   */
  it36, // equipment armor - headwear-caps/hats   (fabric, fiber, or hide-based headgear -- straw hat, anyone?)
  /**
   * @see ItemType
   */
  it37, // equipment armor - headwear-helms       (light headgear)
  /**
   * @see ItemType
   */
  it38, // equipment armor - headwear-helmets     (full headgear)
  /**
   * @see ItemType
   */
  it39, // equipment armor - headwear-specialized (royal crowns, embeddable with jewels etc.)
  /**
   * @see ItemType
   */
  it40, // equipment armor - bodywear-chest/torso (protection from the neck to the waist)
  /**
   * @see ItemType
   */
  it41, // equipment armor - bodywear-pants/waist (protection from the waist down to feet)
  /**
   * @see ItemType
   */
  it42, // equipment armor - limbwear-arms/hands  (greaves, shoulder-guards, etc.)
  /**
   * @see ItemType
   */
  it43, // equipment armor - footwear-lightweight (sandals/shoes/socks/wraps that provide limited protection easily punctured)
  /**
   * @see ItemType
   */
  it44, // equipment armor - footwear-heavyweight (hardened shoes/boots of various materials to protect the feet)
  /**
   * @see ItemType
   */
  it45, // equipment armor - footwear-miscellany  (anything else that protects a foot).
  /**
   * @see ItemType
   */
  it46, // equipment armor - accessory-.
  /**
   * @see ItemType
   */
  it47, // equipment armor - accessory-.
  /**
   * @see ItemType
   */
  it48, // equipment armor - accessory-.
  /**
   * @see ItemType
   */
  it49, // equipment armor - miscellaneous-uncategorized.
  // Miscellaneous:
  /**
   * @see ItemType
   */
  it99; // miscellaneous - uncategorizable/unclassified

  private ItemType() {
  }

  //TODO: Would this be better as an object array in PlatformItems, or left as an enumeration?
  // If switching to an array of ItemType objects, we could allow expansion of the item types, without having to extend
  // this enumeration quite so unnecessarily....
}
