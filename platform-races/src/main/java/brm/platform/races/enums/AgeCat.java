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
 * few and far between in a game, perhaps literally reserved for a few respected or "venerated" masters of their realm.
 * <p/>
 * Also, keep in mind, the "classic" console-based games often had a somewhat skewed representation of ages. Heroes are
 * generally among the pre-teen, teen/adolescent, and post-teen ages &mdash; adults, and older characters, often become
 * either mentors, merchants and support characters, or "obstacle characters" of some kind (up to and including primary
 * bosses/opponent(s) and their lieutenants).
 * @author Gregory
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
   * Age is "early adult". Very much like {@link #ac4 ac4}, but generally as characters that are on their way to being
   * considered a legitimate adult; often, these are the hero's friends, that may be two or three years older. If named
   * adolescent heroes are in the middle of their high-school years, then this age category is for a senior class-mate.
   * <p/>
   * For a classic RPG, these early adults are often the young soldier NPC that might wander around their guard points,
   * the typical man or woman shopper NPC in merchant's shops, and assorted other appearances.
   * @see AgeCat
   */
  ac5,
  /**
   * Age is "middle adult". These are adults which are generally settled in life, either a lesser-noted adventurer from
   * a local area, a merchant, or even a parental NPC. The notable "Harvest Moon" series of games have several mothers
   * who gather in the "town square to chat every day.
   * <p/>
   * Should a middle-aged adult appear as a recruitable member, he/she is likely a mentor-figure that can fight, and do
   * so quite well, but in some cases their joining a party is temporary, due to the long-term overpowering effects.
   * @see AgeCat
   */
  ac6,
  /**
   * Age is "mature adult". Very much like the {@link #ac6 ac6} "middle-aged adult", these adults are quite a bit more
   * mature than their younger fellows. If these were parent NPC individuals, then their children are likely old enough
   * to be the hero's age as well, or perhaps barely older; but the parent is typically not a "grandparent", yet. Often
   * people at this age in villages were once adventurers themselves, who left the dangers behind, for the certainty of
   * owning their own home and maintaining their own family.
   * <p/>
   * On the adventurers side of things, an adult recruitable character of this age is more likely a respected or feared
   * magician or wizard; or someone who has a technical proficiency for some task, lent to the heroic-party for a brief
   * period of time, such as to accomplish a specific task or defeat a particular opponent (and sometimes the backstory
   * for such a character would include reasons for their being the one to do it).
   * @see AgeCat
   */
  ac7,
  /**
   * Age is "elder adult". These are people of "grandparent" age; they have lived life to the full, but are by no means
   * done living. They may hold a wealth of knowledge within their brains, they might be considered affluent or wealthy
   * in the way of owning assets or property, and they may even have specific lines of dialog for the players. Or, not;
   * they could just as well be a "flavor NPC", merely a wandering old gentleman or woman to fill up empty scenery.
   * @see AgeCat
   */
  ac8,
  /**
   * Age is "ancient adult". The game character of this age is so old, he or she is so far beyond a typical grandparent
   * character; they are extremely long-lived, and perhaps in some respects may expect their own death to come. (In one
   * indie RPG Maker game, Homework Salesman, an elderly character *does* die, and results in a new character taking up
   * the family business).
   * @see AgeCat
   */
  ac9,
  /**
   * Age is "immortal". This is very infrequently encountered, except for terms of the game's villains, or of a variety
   * of deities, or of all sorts of "undead" characters.
   * @see AgeCat
   */
  acA;

  private AgeCat() {
  }

  public static final AgeCat fromId(byte b) {
    return values()[b];
  }
}
