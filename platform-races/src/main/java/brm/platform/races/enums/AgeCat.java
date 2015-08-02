package brm.platform.races.enums;


/**
 * The age category. This specifies what age or time-period in the race's life-span this image appears to relate to.
 * Unless you are defining an elemental being or a god that sprang forth fully-formed, age may be less important; but
 * <p/>
 * Generic age-categories may be one of the following (with equivalent information to a human lifespan):
 * <pre>
 * infant         -  0-2? post-birth life and experiences
 * toddler        -  2-5? after infancy, before elementary school
 * child          -  5-9? elementary school through middle school
 * preadolescent  -  9-13? middle school years
 * adolescent     - 13-18? high school years, puberty, dating, romance
 * early adult    - 19-25? collegiate schooling / traditional employment
 * middle adult   - 25-40? advancement to stable career/relationships
 * mature adult   - 40-60? the peak of a career
 * elderly adult  - 60-80? a person respected for accomplishments, age
 * ancient adult  - 80s++? a person venerated for accomplishments, age, knowledge
 * </pre> Not all of the above need include an image; they are merely listed for generalization. Anything up to
 * "adolescent" probably will not be characters in a game; and characters that are "elderly" or older will probably be
 * few and far between in a game, perhaps literally reserved for the few respected and venerated masters of their realm.
 * @author Gregory <gregory.cheyney@gmail.com>
 */
public enum AgeCat {
  /**
   * Age is "infant". This is for the earliest stages of life after being born; an infant is helpless and defenseless,
   * requiring care.
   * <p/>
   * In game terms, an infant character should be incapable of being a party member (unless it is secretly a godlike or
   * omnipotent being in disguise). Unless fitting the theme of a game itself, game creators should think again, before
   * deciding to use an infant as a playable character...
   * @see AgeCat
   */
  ac0,
  /**
   * Age is "toddler".
   * <p/>
   * In game terms, like the infant and the child, a toddler is still too young, inexperienced, and incapable of normal
   * battle to be a playable character.
   * @see AgeCat
   */
  ac1,
  /**
   * Age is "child".
   * <p/>
   * In game terms, any individuals which are younger than preadolescent may not be suitable to be an adventuring party
   * member, due to the tendency to not have common sense, emotional stability, maturity, or strength (and not just for
   * physiological reasons, either). Although, it is possible that the rare exception might occur; the game creator may
   * ask, "What makes such a character remarkable, or worthy of being a playable character?"
   * @see AgeCat
   */
  ac2,
  /**
   * Age is "preadolescent". The earliest phases of puberty and maturing from a "no longer a child" into an "almost an
   * adult" character.
   * <p/>
   * In game terms, a preadolescent is capable of being a lower-quality adventurer, although a rare exception may occur
   * in a game world.
   * @see AgeCat
   */
  ac3,
  /**
   * Age is "adolescent". Like {@link #ac3 ac3}, but with a little more progression in the ways of becoming an adult.
   * For humans, this is a time when the individual is becoming who they will be for a long time to come.
   * <p/>
   * In game terms, an adolescent makes a decent entry-level adventurer; in some manner, an adolescent is a blank slate
   * by which their life, and life-experiences, are just beginning.
   * @see AgeCat
   */
  ac4,
  /**
   * Age is "early adult".
   * @see AgeCat
   */
  ac5,
  /**
   * Age is "middle adult".
   * @see AgeCat
   */
  ac6,
  /**
   * Age is "mature adult".
   * @see AgeCat
   */
  ac7,
  /**
   * Age is "elder adult".
   * @see AgeCat
   */
  ac8,
  /**
   * Age is "ancient adult".
   * @see AgeCat
   */
  ac9,
  /**
   * Age is "immortal".
   * @see AgeCat
   */
  acA;

  private AgeCat() {
  }

  public static final AgeCat fromId(byte b) {
    return values()[b];
  }
}
