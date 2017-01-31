package brm.platform.database.events.entities;


/**
 * A baseline timed planting object. This class defines a baseline plantable location, such as when a seed or sprout is
 * already "planting" in the ground, in a pot, or some special location.
 * <p/>
 * Nearly all crop-type plants in a game are meant to be annual-only; that is, after their normal life stage, ending in
 * their being harvested, they will wilt or die, and not be present the next "year" in the game. If a plant is meant to
 * return in successive years, then {@link TimeablePlantingPerennial} should be used instead.
 * @author Gregory
 */
public class TimeablePlanting extends AMapEntityTimeable {
  protected boolean plantable;
  protected boolean planted;
  protected boolean waterable;
  protected boolean watered;
  protected boolean fertilizable;
  protected boolean fertilized;
  protected boolean harvestable;
  protected boolean harvested;
  protected int typeSeeds;
  protected int typePlant;
  protected int currentWater, currentFertilizer;
}
