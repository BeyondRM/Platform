package brm.platform.window.skinning;
import brm.platform.window.skinning.skin.SkinnableComponent;
import brm.platform.window.skinning.skin.SkinnableContainer;


/**
 * <h2>WindowSkin</h2>
 * The Window Skin manager. This singleton class contains fields and methods for handling all the skinning graphics and
 * properties for the system.
 * <p/>
 * TODO: Implement AModuleLoading; fill out the methods to initialize this instance, then load the skinnable objects.
 * In the initializer method, we want to obtain the compressed archive containing the window-skin definitions; they can
 * be parsed as they are loaded. This class should handle any IOException thrown from the ASkinnable class constructor;
 * if no valid window skins exist after loading of this module is complete, then we will error-out of the whole running
 * program &mdash; it's going to be graphically difficult to continue, anyway&hellip;
 * @author Gregory
 * @see #instance instance
 * @see #skinnableComponents skinnableComponents
 * @see #skinnableContainers skinnableContainers
 */
public class WindowSkin { // implements AModuleLoading
  /**
   * The default {@link WindowSkin} instance.
   * @see WindowSkin
   */
  public static final WindowSkin instance;

  static {
    instance = new WindowSkin();
  }

  // Note: both components and containers have backgrounds #1 and #2, and border clamps and decorations;
  /**
   * The skinnable components. In this case, components are objects that might display data or permit selecting things,
   * but do not hold any other components.
   * @see WindowSkin
   */
  private SkinnableComponent[] skinnableComponents;
  /**
   * The skinnable containers. In this case, containers are objects that may hold several objects, including components
   * as well as other containers. It is recommended to not get too iteratively "deep" in a hierarchy of components; i
   * @see WindowSkin
   */
  private SkinnableContainer[] skinnableContainers;
  // ... also need another class object for the miscellaneous skinning data ... ?
  /**
   * The active component index.
   * @see WindowSkin
   */
  private int activeComponentSkin;
  /**
   * The active container index.
   * @see WindowSkin
   */
  private int activeContainerSkin;

  /**
   * A private constructor. Goes Nowhere Does Nothing.
   * @see WindowSkin
   */
  private WindowSkin() {
  }

  /**
   * Load the component skins.
   * @see WindowSkin
   */
  private void loadSkinnableComponents() {
    // load the component skins -- we should end up with at least ONE that is not null and unlocked....
  }

  /**
   * Load the container skins.
   * @see WindowSkin
   */
  private void loadSkinnableContainers() {
    // load the container skins -- we should end up with at least ONE that is not null and unlocked....
  }

  /**
   * Get the component skins size.
   * @return An {@link Integer} value.
   * @see WindowSkin
   */
  public final int sizeComponentSkins() {
    return skinnableComponents.length;
  }

  /**
   * Get the container skins size.
   * @return An {@link Integer} value.
   * @see WindowSkin
   */
  public final int sizeContainerSkins() {
    return skinnableContainers.length;
  }
}
