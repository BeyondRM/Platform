=Template Platform Window Skins
This path is for default window-skinning features that should be included in a game, minimum. It exists so that even if
no other window skin is defined for a game, the game/engine should still have something to initialize and render.

==Skin Attributes
In comparison with RPG Maker, this window-skin format is generally twice as large, and more detailed. Background images
are twice as wide and high; border accents and tiled bordering graphics allow for greater detail and patterned repeats.
Graphical gauges have appealing layouts, background and foreground coloring, and animation. A 32-bit-per-pixel depth is
preferred, though lesser bit-depths can also be used.

===RPG Maker's Window Skin Layout.
RPG Maker's window skin is a PNG that is 128x128 pixels square;
- The upper-left quadrant is a window background graphic gradient; it could also be a more elegant pattern background.
- The lower-left quadrant in RM is a pattern sub-image meant to give the window background the look-and-feel of classic
  television or an interlaced monitor; it may perhaps be changed to other sorts of translucent/transparent effects.
- The upper-right quadrant holds an image that may be parsed for the window border, as well as navigation and scrolling
  arrows, which get overlaid on the border.
  - The outer portion of the area is parsed into border pieces:
    16x16-pixel corners, 32x16-pixel horizontal sides, 16x32-pixel vertical sides;
  - the remaining 32x32-pixel area is further parsed into four arrows, for indicating menu or window scrolling.
- The lower-right quadrant is even more iteratively parsed;
  - the upper half contains a command-cursor in the upper-left quadrant, and an animated pause sign in the upper-right;
  - the lower half is for text colors, 32 colors arranged in 4 rows of 8 columns, each an 8x8 color block.

===BeyondRM's Window Skin Layout.
In this skinning system, the colors can be doubled to 64 total (8 rows, 8 columns, 8x8 color blocks), though colors are
in a separate graphic image file; the command cursor and scrolling arrows are similarly in their own images.

BeyondRM's image size will be *at least* 256x256 pixels square, for the window background and border graphics. This has
four quadrants of 128x128 pixels each; going left to right from the upper-left, the purposes are:
- a background for disabled windows;
- a background for enabled unselected windows;
- a background for enabled selected windows;
- the border graphics, which can also be parsed into pieces, generally following the same practice that RPG Maker does.

==Template Skins/Themes
Basic skin ideas should follow a general design that is central to a game idea; that way, we have at least a minimum of
three diverse skins that may appeal to different players.

The templates that can be included by default are: a plain, "no-frills" skin that simply decorates windows as RPG Maker
default bluish skin; a semitransparent theme; a rustic "agrarian" theme; a mechanical or industrial theme; or perhaps a
"hearts-aflame" skin for more "galge" or "visual novel" style games.

Beyond this, game makers can create their own skin that is more relevant to their own game, or hire out to have someone
create one for them. Ideally, we could have a number of window-skin resources available for public selection.