package brm.platform.database.events.entities;


/**
 * A perennial planting. This class extends {@link TimeablePlanting} and defines fields and methods that defines how a
 * perennial planted object (such as something meant to grow and produce a repeatable crop) will perform in a game map.
 * The intended output may vary &mdash; a fruit, for instance; or a harvestable fiber such as cotton.
 * <p/>
 * The intended result could also be for no necessary harvestable product; it could be something ornamental like a tree
 * or flower that does nothing more than provide shade and environment to a map. But, for the most part, most perennial
 * plants should provide the same basic methodology as annual plants; albeit, that plant growth may continue throughout
 * additional years or seasons. (This depends upon the game clock and calendar; a world with cooler and warmer seasons,
 * as well as nominal water presence, may allow plant cycles.)
 * @author Gregory
 */
public class TimeablePlantingPerennial extends TimeablePlanting {
}
