package brm.platform.resource.graphics.enums;


/**
 * Game graphic types. This enumeration defines the specialty types of graphic elements that are used within a game; it
 * lists both non-tileable static images (do not parse) and assorted tileable images (animations, tilesets, anything to
 * be parsed into sub-images).
 * <h1>The Major Types.</h1>
 * At its base, we categorize the images by a pseudo-classification system to help in loading the encrypted binary data
 * that goes with each major graphical file object. This makes it easier in first reading a byte and then parsing it to
 * an instance of this enumeration.
 * <h2>1. Static Graphics: Non-Tileable Images.</h2>
 * We start at the beginning, with (of course) the default, a "non-tileable" image object. This type is merely used for
 * displaying a static image that is not animated, and not parsed into sub-images.
 * <p/>
 * These images could be for background graphics used in many places: map parallax, menu/screen backgrounds, battle map
 * backgrounds, et cetera. They could also potentially be used for full-body character portraits, sometimes displayable
 * in some games as the character who is "talking". Or, they could be used as repeatable weather effects, like raindrop
 * images streaking down the screen; or dust particles floating in the world, or other "weather" objects.
 * <h2>2. Primary Tiles: Parsed Tileable Objects.</h2>
 * The next major type is for images that are parsed, but only broken into an array of tiles of equal size or placement
 * in the main image. This is for a tile-set's tilesheet of tile units, for simple animations of one animation per file
 * image, or for other images like icon-sets of icons to use in menus.
 * <p/>
 * The icon-set and tile-set examples being the most common, other uses are possible.
 * <h2>3. Secondary Sub-Tileable: Arrayed Tiles.</h2>
 * A third major type is for images that are also parsed, although they may be made of sub-sub-images of the full image
 * &mdash; for example, an image file contains an array of animation sheets, each of which can further be subdivided to
 * individual animation cells, et cetera, and so forth.
 * <h2>4. Miscellaneous/Other/Unknown.</h2>
 * A final but less common type might be for basic images which might contain sub-image components of irregular size or
 * positioning. They require unique class methodology of their own to load and parse the specific sub-images with data.
 * <p/>
 * For example, a "font set" is essentially a sheet of letter graphics which can be obtained from a font graphic. Every
 * font character may depend upon the same positioning to the inferred "above or below the line", but each one may have
 * their own specific width, "kerning" (space between it and another character), and so on. Search the Internet for any
 * information on fonts, and we see just how complex they can get....
 * @author Gregory
 */
public enum TileableType {
  // Type 0
  tt00(), // default, not tileable?
  tt01(), // abstract animation -- any core animation that is obtained via dividing an image into equal widths/heights.
  tt02(), // balloon animation -- character emotes on the map screen, bubbles or balloons that appear over a character.
  tt03(), // battlers/battle sprites -- static or animated images used in combat scenarios that fight the heroes.
  tt04(), // character face sprite(s) -- character images shown in menu screens and message boxes.
  tt05(), // character pose sprite(s) -- map sprites for facing directions, animated actions, etc.
  tt06(), //
  tt07(), //
  tt08(), //
  tt09(), //
  // Type 1
  tt10(), // map tilesheet sprites -- various tileable images that are rendered to make the game maps.
  tt11(), //
  tt12(), //
  tt13(), //
  tt14(), //
  tt15(), //
  tt16(), //
  tt17(), //
  tt18(), //
  tt19(), //
  // Type 2
  tt20(), // map tilesheet sprites -- various tileable images that are rendered to make the game maps.
  tt21(), //
  tt22(), //
  tt23(), //
  tt24(), //
  tt25(), //
  tt26(), //
  tt27(), //
  tt28(), //
  tt29(); //

  private TileableType() {
  }

  // a static sub-enumeration defining the "metatype" or "level" of the graphics type
  // a static sub-enumeration defining the .. some other property?
}
